package view;

import dto.DataListDto;
import service.DataListService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataDisplayView implements Serializable {

    private List<DataListDto> dataListDtos;

    @ManagedProperty(value="#{dataListService}")
    private DataListService dataListService;

    @PostConstruct
    public void init() {
        dataListDtos = dataListService.getWeekReadings();
    }

    public void setDataListService(DataListService dataListService) {
        this.dataListService = dataListService;
    }

    public List<DataListDto> getDataListDtos() {
        return dataListDtos;
    }

    public void setDataListDtos(List<DataListDto> dataListDtos) {
        this.dataListDtos = dataListDtos;
    }
}
