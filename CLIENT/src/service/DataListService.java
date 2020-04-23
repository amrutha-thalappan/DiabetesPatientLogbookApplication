package service;

import dto.DataListDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class DataListService {

    public List<DataListDto> getWeekReadings(){
        List<DataListDto> dataListDtos = new ArrayList<>();
        

        return  dataListDtos;
    }

}
