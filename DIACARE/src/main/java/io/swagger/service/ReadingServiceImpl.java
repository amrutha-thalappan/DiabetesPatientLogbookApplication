package io.swagger.service;

import io.swagger.model.*;
import io.swagger.repository.ReadingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingDetailsRepository readingDetailsRepository;

    @Autowired
    UserService userService;

    @Override
    public ReadingDetails saveReading(ReadingDetailsDto readingDetailsDto) {
        ReadingDetails readingDetails = mapDtoToObject(readingDetailsDto);
        readingDetailsRepository.save(readingDetails);
        return readingDetails;
    }

    @Override
    public ReadingDetails findByReadingId(Integer readingId) {
        Optional<ReadingDetails> readingDetails = readingDetailsRepository.findById(readingId);
        ReadingDetails details = null;
        if(readingDetails.isPresent()){
            details = readingDetails.get();
        }
        return details;
    }

    @Override
    public ReadingDetails updateReading(ReadingDetailsDto dto) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = null;
        try {
            today = formatter.parse(dto.getDate());
            if(today == null){
                today = formatter.parse(formatter.format(new Date()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }        
        ReadingDetails existingReadingDetails = readingDetailsRepository.findByUserIdAndDate(dto.getUserId(), today);
        ReadingDetails updatedReadings = updateDetailsIfNotNull(existingReadingDetails, dto);
        readingDetailsRepository.saveAndFlush(updatedReadings);
        return updatedReadings;
    }

    @Override
    public ReadingDetailsDto findTodaysReading(Integer userId) {
        User user =  userService.findByUserId(userId);
        ReadingDetails readingDetails = null;
        Date now = null;
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd-MM-yyyy");
        try {
            now = formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        readingDetails = readingDetailsRepository.findByUserIdAndDate(userId, now);
        ReadingDetailsDto readingDetailsDto = mapObjectToDto(readingDetails);

        return readingDetailsDto;
    }

    @Override
    public List<ReadingDetailsDto> findAllReadings(Integer userId) {
        User user =  userService.findByUserId(userId);
        List<ReadingDetails> readingDetailsList = readingDetailsRepository.findByUserOrderByDateDesc(user);
        List<ReadingDetailsDto> readingDetailsDtos = new ArrayList<>();
        for(ReadingDetails reading : readingDetailsList){
            ReadingDetailsDto readingDetailsDto = mapObjectToDto(reading);
            readingDetailsDtos.add(readingDetailsDto);
        }
        return readingDetailsDtos;
    }

    private ReadingDetails updateDetailsIfNotNull(ReadingDetails existingReadingDetails, ReadingDetailsDto dto) {

        //Night details updation
        Integer insulinBeforeBed = dto.getInsulinBeforeBed();
        if(insulinBeforeBed != null){
            existingReadingDetails.setInsulinBeforeBed(insulinBeforeBed);
        }

        String insulinBeforeBedTime = dto.getInsulinBeforeBedTime();
        if(insulinBeforeBedTime != null){
            existingReadingDetails.setInsulinBeforeBedTime(insulinBeforeBedTime);
        }

        Integer sugarAtFast = dto.getSugarAtFast();
        if(sugarAtFast != null){
            existingReadingDetails.setSugarAtFast(sugarAtFast);
        }

        String sugarAtFastTime = dto.getSugarAtFastTime();
        if(sugarAtFastTime != null){
            existingReadingDetails.setSugarAtFastTime(sugarAtFastTime);
        }


        //MorningDetails Updation
        Integer mrngInsulinBeforeFood = dto.getMrngInsulinBeforeFood();
        if(mrngInsulinBeforeFood != null){
            existingReadingDetails.setMrngInsulinBeforeFood(mrngInsulinBeforeFood);
        }

        String mrngInsulinBeforeFoodTime = dto.getMrngInsulinBeforeFoodTime();
        if(mrngInsulinBeforeFoodTime != null){
            existingReadingDetails.setMrngInsulinBeforeFoodTime(mrngInsulinBeforeFoodTime);
        }

        Integer mrngInsulinAfterFood = dto.getMrngInsulinAfterFood();
        if(mrngInsulinAfterFood != null){
            existingReadingDetails.setMrngInsulinAfterFood(mrngInsulinAfterFood);
        }

        String mrngInsulinAfterFoodTime = dto.getMrngInsulinAfterFoodTime();
        if(mrngInsulinAfterFoodTime != null){
            existingReadingDetails.setMrngInsulinAfterFoodTime(mrngInsulinAfterFoodTime);
        }

        String mrngPlace = dto.getMrngPlace();
        if(mrngPlace != null){
            existingReadingDetails.setMrngPlace(mrngPlace);
        }

        Integer mrngSugarBeforeFood = dto.getMrngSugarBeforeFood();
        if(mrngSugarBeforeFood != null){
            existingReadingDetails.setMrngSugarBeforeFood(mrngSugarBeforeFood);
        }

        String mrngSugarBeforeFoodTime = dto.getMrngSugarBeforeFoodTime();
        if(mrngSugarBeforeFoodTime != null){
            existingReadingDetails.setMrngSugarBeforeFoodTime(mrngSugarBeforeFoodTime);
        }

        Integer mrngSugarAfterFood = dto.getMrngSugarAfterFood();
        if(mrngSugarAfterFood != null){
            existingReadingDetails.setMrngSugarAfterFood(mrngSugarAfterFood);
        }

        String mrngSugarAfterFoodTime = dto.getMrngSugarAfterFoodTime();
        if(mrngSugarAfterFoodTime != null){
            existingReadingDetails.setMrngSugarAfterFoodTime(mrngSugarAfterFoodTime);
        }

        //noon details updation
        Integer noonInsulinBeforeFood = dto.getNoonInsulinBeforeFood();
        if(noonInsulinBeforeFood != null){
            existingReadingDetails.setNoonInsulinBeforeFood(noonInsulinBeforeFood);
        }

        String noonInsulinBeforeFoodTime = dto.getNoonInsulinBeforeFoodTime();
        if(noonInsulinBeforeFoodTime != null){
            existingReadingDetails.setNoonInsulinBeforeFoodTime(noonInsulinBeforeFoodTime);
        }

        Integer noonInsulinAfterFood = dto.getNoonInsulinAfterFood();
        if(noonInsulinAfterFood != null){
            existingReadingDetails.setNoonInsulinAfterFood(noonInsulinAfterFood);
        }

        String noonInsulinAfterFoodTime = dto.getNoonInsulinAfterFoodTime();
        if(noonInsulinAfterFoodTime != null){
            existingReadingDetails.setNoonInsulinAfterFoodTime(noonInsulinAfterFoodTime);
        }

        String noonPlace = dto.getNoonPlace();
        if(noonPlace != null){
            existingReadingDetails.setNoonPlace(noonPlace);
        }

        Integer noonSugarBeforeFood = dto.getNoonSugarBeforeFood();
        if(noonSugarBeforeFood != null){
            existingReadingDetails.setNoonSugarBeforeFood(noonSugarBeforeFood);
        }

        String noonSugarBeforeFoodTime = dto.getNoonSugarBeforeFoodTime();
        if(noonSugarBeforeFoodTime != null){
            existingReadingDetails.setNoonSugarBeforeFoodTime(noonSugarBeforeFoodTime);
        }

        Integer noonSugarAfterFood = dto.getNoonSugarAfterFood();
        if(noonSugarAfterFood != null){
            existingReadingDetails.setNoonSugarAfterFood(noonSugarAfterFood);
        }

        String noonSugarAfterFoodTime = dto.getNoonSugarAfterFoodTime();
        if(noonSugarAfterFoodTime != null){
            existingReadingDetails.setNoonSugarAfterFoodTime(noonSugarAfterFoodTime);
        }

        // evening details updation
        Integer evngInsulinBeforeFood = dto.getEvngInsulinBeforeFood();
        if(evngInsulinBeforeFood != null){
            existingReadingDetails.setEvngInsulinBeforeFood(evngInsulinBeforeFood);
        }

        String evngInsulinBeforeFoodTime = dto.getEvngInsulinBeforeFoodTime();
        if(evngInsulinBeforeFoodTime != null){
            existingReadingDetails.setEvngInsulinBeforeFoodTime(evngInsulinBeforeFoodTime);
        }

        Integer evngInsulinAfterFood = dto.getEvngInsulinAfterFood();
        if(evngInsulinAfterFood != null){
            existingReadingDetails.setEvngInsulinAfterFood(evngInsulinAfterFood);
        }

        String evngInsulinAfterFoodTime = dto.getEvngInsulinAfterFoodTime();
        if(evngInsulinAfterFoodTime != null){
            existingReadingDetails.setEvngInsulinAfterFoodTime(evngInsulinAfterFoodTime);
        }

        String evngPlace = dto.getEvngPlace();
        if(evngPlace != null){
            existingReadingDetails.setEvngPlace(evngPlace);
        }

        Integer evngSugarBeforeFood = dto.getEvngSugarBeforeFood();
        if(evngSugarBeforeFood != null){
            existingReadingDetails.setEvngSugarBeforeFood(evngSugarBeforeFood);
        }

        String evngSugarBeforeFoodTime = dto.getEvngSugarBeforeFoodTime();
        if(evngSugarBeforeFoodTime != null){
            existingReadingDetails.setEvngSugarBeforeFoodTime(evngSugarBeforeFoodTime);
        }

        Integer evngSugarAfterFood = dto.getEvngSugarAfterFood();
        if(evngSugarAfterFood != null){
            existingReadingDetails.setEvngSugarAfterFood(evngSugarAfterFood);
        }

        String evngSugarAfterFoodTime = dto.getEvngSugarAfterFoodTime();
        if(evngSugarAfterFoodTime != null){
            existingReadingDetails.setEvngSugarAfterFoodTime(evngSugarAfterFoodTime);
        }

        String comment = dto.getComment();
        if(comment != null){
            existingReadingDetails.setComment(comment);
        }

        return existingReadingDetails;
    }

    private ReadingDetails mapDtoToObject(ReadingDetailsDto readingDetailsDto) {
        ReadingDetails readingDetails = new ReadingDetails();
        readingDetails.setUser(userService.findByUserId(readingDetailsDto.getUserId()));
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd-MM-yyyy");
        String d= formatter.format(new Date());
        Date date= null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        readingDetails.setDate(date);
        readingDetails.setDay(readingDetailsDto.getDay());
        readingDetails.setInsulinBeforeBed(readingDetailsDto.getInsulinBeforeBed());
        readingDetails.setSugarAtFast(readingDetailsDto.getSugarAtFast());
        readingDetails.setMrngInsulinBeforeFood(readingDetailsDto.getMrngInsulinBeforeFood());
        readingDetails.setMrngInsulinBeforeFoodTime(readingDetailsDto.getMrngInsulinBeforeFoodTime());
        readingDetails.setMrngInsulinAfterFood(readingDetailsDto.getMrngInsulinAfterFood());
        readingDetails.setMrngInsulinAfterFoodTime(readingDetailsDto.getMrngInsulinAfterFoodTime());
        readingDetails.setMrngPlace(readingDetailsDto.getMrngPlace());
        readingDetails.setMrngSugarBeforeFood(readingDetailsDto.getMrngSugarBeforeFood());
        readingDetails.setMrngSugarBeforeFoodTime(readingDetailsDto.getMrngSugarBeforeFoodTime());
        readingDetails.setMrngSugarAfterFood(readingDetailsDto.getMrngSugarAfterFood());
        readingDetails.setMrngSugarAfterFoodTime(readingDetailsDto.getMrngSugarAfterFoodTime());
        readingDetails.setNoonInsulinBeforeFood(readingDetailsDto.getNoonInsulinBeforeFood());
        readingDetails.setNoonInsulinBeforeFoodTime(readingDetailsDto.getNoonInsulinBeforeFoodTime());
        readingDetails.setNoonInsulinAfterFood(readingDetailsDto.getNoonInsulinAfterFood());
        readingDetails.setNoonInsulinAfterFoodTime(readingDetailsDto.getNoonInsulinAfterFoodTime());
        readingDetails.setNoonPlace(readingDetailsDto.getNoonPlace());
        readingDetails.setNoonSugarBeforeFood(readingDetailsDto.getNoonSugarBeforeFood());
        readingDetails.setNoonSugarBeforeFoodTime(readingDetailsDto.getNoonSugarBeforeFoodTime());
        readingDetails.setNoonSugarAfterFood(readingDetailsDto.getNoonSugarAfterFood());
        readingDetails.setNoonSugarAfterFoodTime(readingDetailsDto.getNoonSugarAfterFoodTime());
        readingDetails.setEvngInsulinBeforeFood(readingDetailsDto.getEvngInsulinBeforeFood());
        readingDetails.setEvngInsulinBeforeFoodTime(readingDetailsDto.getEvngInsulinBeforeFoodTime());
        readingDetails.setEvngInsulinAfterFood(readingDetailsDto.getEvngInsulinAfterFood());
        readingDetails.setEvngInsulinAfterFoodTime(readingDetailsDto.getEvngInsulinAfterFoodTime());
        readingDetails.setEvngPlace(readingDetailsDto.getEvngPlace());
        readingDetails.setEvngSugarBeforeFood(readingDetailsDto.getEvngSugarBeforeFood());
        readingDetails.setEvngSugarBeforeFoodTime(readingDetailsDto.getEvngSugarBeforeFoodTime());
        readingDetails.setEvngSugarAfterFood(readingDetailsDto.getEvngSugarAfterFood());
        readingDetails.setEvngSugarAfterFoodTime(readingDetailsDto.getEvngSugarAfterFoodTime());
        readingDetails.setComment(readingDetailsDto.getComment());
        return readingDetails;
    }

    private ReadingDetailsDto mapObjectToDto(ReadingDetails readingDetails) {
        if(readingDetails!=null) {
            ReadingDetailsDto dto = new ReadingDetailsDto();
            Date date = readingDetails.getDate();
            DateFormat dateFormat = new SimpleDateFormat(
                    "dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            dto.setDate(strDate);
            dto.setDay(readingDetails.getDay());
            dto.setInsulinBeforeBed(readingDetails.getInsulinBeforeBed());
            dto.setSugarAtFast(readingDetails.getSugarAtFast());
            dto.setMrngInsulinBeforeFood(readingDetails.getMrngInsulinBeforeFood());
            dto.setMrngInsulinBeforeFoodTime(readingDetails.getMrngInsulinBeforeFoodTime());
            dto.setMrngInsulinAfterFood(readingDetails.getMrngInsulinAfterFood());
            dto.setMrngInsulinAfterFoodTime(readingDetails.getMrngInsulinAfterFoodTime());
            dto.setMrngPlace(readingDetails.getMrngPlace());
            dto.setMrngSugarBeforeFood(readingDetails.getMrngSugarBeforeFood());
            dto.setMrngSugarBeforeFoodTime(readingDetails.getMrngSugarBeforeFoodTime());
            dto.setMrngSugarAfterFood(readingDetails.getMrngSugarAfterFood());
            dto.setMrngSugarAfterFoodTime(readingDetails.getMrngSugarAfterFoodTime());
            dto.setNoonInsulinBeforeFood(readingDetails.getNoonInsulinBeforeFood());
            dto.setNoonInsulinBeforeFoodTime(readingDetails.getNoonInsulinBeforeFoodTime());
            dto.setNoonInsulinAfterFood(readingDetails.getNoonInsulinAfterFood());
            dto.setNoonInsulinAfterFoodTime(readingDetails.getNoonInsulinAfterFoodTime());
            dto.setNoonPlace(readingDetails.getNoonPlace());
            dto.setNoonSugarBeforeFood(readingDetails.getNoonSugarBeforeFood());
            dto.setNoonSugarBeforeFoodTime(readingDetails.getNoonSugarBeforeFoodTime());
            dto.setNoonSugarAfterFood(readingDetails.getNoonSugarAfterFood());
            dto.setNoonSugarAfterFoodTime(readingDetails.getNoonSugarAfterFoodTime());
            dto.setEvngInsulinBeforeFood(readingDetails.getEvngInsulinBeforeFood());
            dto.setEvngInsulinBeforeFoodTime(readingDetails.getEvngInsulinBeforeFoodTime());
            dto.setEvngInsulinAfterFood(readingDetails.getEvngInsulinAfterFood());
            dto.setEvngInsulinAfterFoodTime(readingDetails.getEvngInsulinAfterFoodTime());
            dto.setEvngPlace(readingDetails.getEvngPlace());
            dto.setEvngSugarBeforeFood(readingDetails.getEvngSugarBeforeFood());
            dto.setEvngSugarBeforeFoodTime(readingDetails.getEvngSugarBeforeFoodTime());
            dto.setEvngSugarAfterFood(readingDetails.getEvngSugarAfterFood());
            dto.setEvngSugarAfterFoodTime(readingDetails.getEvngSugarAfterFoodTime());
            dto.setComment(readingDetails.getComment());
            return dto;
        }else{
            return null;
        }
    }
}



