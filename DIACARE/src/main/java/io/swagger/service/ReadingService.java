package io.swagger.service;

import io.swagger.model.DiabetesData;
import io.swagger.model.DiabetesDataDto;
import org.springframework.stereotype.Service;

@Service
public interface ReadingService {

    public DiabetesData saveReading(DiabetesDataDto diabetesDataDto);

}
