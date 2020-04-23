package io.swagger.service;

import io.swagger.enumtype.DayTime;
import io.swagger.enumtype.NightChecking;
import io.swagger.enumtype.ReadingType;
import io.swagger.enumtype.TimeOfRecording;
import io.swagger.model.*;
import io.swagger.repository.DiabetesDataRepository;
import io.swagger.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    DiabetesDataRepository diabetesDataRepository;

    @Autowired
    UserService userService;

    @Override
    public DiabetesData saveReading(DiabetesDataDto diabetesDataDto) {
        DiabetesData diabetesData = new DiabetesData();
        diabetesData.setUserId(userService.findByUserId(diabetesDataDto.getUserId()));
        diabetesData.setDate(diabetesDataDto.getDate());
        diabetesData.setDay(diabetesDataDto.getDay());
        diabetesDataRepository.save(diabetesData);

        List<Reading> readingList = new ArrayList<>();
        for (ReadingDto dto: diabetesDataDto.getReadings()){
            Reading reading = new Reading();
            reading.setNightChecking(dto.getNightChecking());
            reading.setTime(dto.getTime());
            reading.setPlace(dto.getPlace());
            reading.setReadingType(dto.getReadingType());
            reading.setDayTime(dto.getDayTime());
            reading.setTimeOfRecording(dto.getTimeOfRecording());
            reading.setReading(dto.getReading());
            reading.setDiabetesData(diabetesData);
            readingRepository.save(reading);
            readingList.add(reading);
        }
        return diabetesData;
    }

    @Override
    public List<DataListDto> findReadingsOflastWeek(Integer userId) {
        User user =  userService.findByUserId(userId);
        List<DiabetesData> diabetesDatas = null;
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate= formatter.format(now);
        try {
            now = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.setTime(now);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -7);
        Date dateOneWeekAgo = oneWeekAgo.getTime();
        String strOneWeekAgo= formatter.format(dateOneWeekAgo);
        try {
            dateOneWeekAgo = formatter.parse(strOneWeekAgo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diabetesDatas = diabetesDataRepository.findByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(userId, now, dateOneWeekAgo);
        //List<DiabetesDataDto> diabetesDataDtos = mapDataObjectToDto(diabetesDatas);
        List<DataListDto> diabetesDataDtos = mapDataObjectToDto(diabetesDatas);
        return diabetesDataDtos;
    }

    private List<DataListDto> mapDataObjectToDto(List<DiabetesData> diabetesDatas) {
        //List<DiabetesDataDto> diabetesDataDtos = new ArrayList<>();
        List<DataListDto> dataListDtos = new ArrayList<>();
        for(DiabetesData data:diabetesDatas){
            DataListDto dataListDto = new DataListDto();
            dataListDto.setDate(data.getDate().toString());
            dataListDto.setDay(data.getDay());
            for(Reading reading:data.getReadings()){
                if(reading.getDayTime().equals(DayTime.NIGHT)){
                    if(reading.getReadingType().equals(ReadingType.INSULIN)){
                        if(reading.getNightChecking().equals(NightChecking.BEFORE_BED)){
                            dataListDto.setNightInsulinBeforeBed(reading.getReading().toString());
                        }
                    }else if(reading.getReadingType().equals(ReadingType.SUGAR)){
                        if(reading.getNightChecking().equals(NightChecking.SUGAR_AT_FAST)){
                            dataListDto.setNightSugarAtFast(reading.getReading().toString());
                        }
                    }
                } else if(reading.getDayTime().equals(DayTime.MORNING)){
                    dataListDto.setMorningPlace(reading.getPlace());
                    if(reading.getReadingType().equals(ReadingType.INSULIN)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setMorningInsulinBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setMorningInsulinAfterFood(reading.getReading().toString());
                        }
                    }else if(reading.getReadingType().equals(ReadingType.SUGAR)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setMorningSugarBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setMorningSugarAfterFood(reading.getReading().toString());
                        }
                    }
                } else if(reading.getDayTime().equals(DayTime.NOON)){
                    dataListDto.setNoonPlace(reading.getPlace());
                    if(reading.getReadingType().equals(ReadingType.INSULIN)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setNoonInsulinBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setNoonInsulinAfterFood(reading.getReading().toString());
                        }
                    }else if(reading.getReadingType().equals(ReadingType.SUGAR)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setNoonSugarBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setNoonSugarAfterFood(reading.getReading().toString());
                        }
                    }
                }else if(reading.getDayTime().equals(DayTime.EVENING)){
                    dataListDto.setEveningPlace(reading.getPlace());
                    if(reading.getReadingType().equals(ReadingType.INSULIN)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setEveningInsulinBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setEveningInsulinAfterFood(reading.getReading().toString());
                        }
                    }else if(reading.getReadingType().equals(ReadingType.SUGAR)){
                        if(reading.getTimeOfRecording().equals(TimeOfRecording.BEFORE_FOOD)){
                            dataListDto.setEveningSugarBeforeFood(reading.getReading().toString());
                        }else if(reading.getTimeOfRecording().equals(TimeOfRecording.AFTER_FOOD)){
                            dataListDto.setEveningSugarAfterFood(reading.getReading().toString());
                        }
                    }
                }
            }
            /*DiabetesDataDto diabetesDataDto = new DiabetesDataDto();
            diabetesDataDto.setDate(data.getDate());
            diabetesDataDto.setDay(data.getDay());
            diabetesDataDto.setUserId(data.getUserId().getUserId());

            List<ReadingDto> dtos = mapReadingListToDtos(data.getReadings());
            diabetesDataDto.setReadings(dtos);
            diabetesDataDtos.add(diabetesDataDto);*/
            dataListDtos.add(dataListDto);
        }
        return dataListDtos;
    }

    /*private List<DataListDto> mapReadingListToDtos(List<Reading> readings) {
        List<ReadingDto> readingDtos = new ArrayList<>();
        for(Reading reading:readings){
            ReadingDto readingDto = new ReadingDto();
            readingDto.setTime(reading.getTime());
            readingDto.setPlace(reading.getPlace());
            readingDto.setReadingType(reading.getReadingType());
            readingDto.setDayTime(reading.getDayTime());
            readingDto.setNightChecking(reading.getNightChecking());
            readingDto.setTimeOfRecording(reading.getTimeOfRecording());
            readingDtos.add(readingDto);
        }
        return readingDtos;
    }*/
}
