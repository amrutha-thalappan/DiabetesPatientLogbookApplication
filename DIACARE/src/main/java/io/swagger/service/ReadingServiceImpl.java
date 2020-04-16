package io.swagger.service;

import io.swagger.model.DiabetesData;
import io.swagger.model.DiabetesDataDto;
import io.swagger.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    UserService userService;

    @Override
    public DiabetesData saveReading(DiabetesDataDto diabetesDataDto) {
        DiabetesData diabetesData = new DiabetesData();
        diabetesData.setUserId(userService.findByUserId(1));
        diabetesData.setDate(diabetesDataDto.getDate());
        diabetesData.setDay(diabetesDataDto.getDay());
        return readingRepository.save(diabetesData);
    }
}
