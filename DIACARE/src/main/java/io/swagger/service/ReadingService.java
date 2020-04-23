package io.swagger.service;

import io.swagger.model.DataListDto;
import io.swagger.model.DiabetesData;
import io.swagger.model.DiabetesDataDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadingService {

    public DiabetesData saveReading(DiabetesDataDto diabetesDataDto);

    List<DataListDto> findReadingsOflastWeek(Integer userId);
}
