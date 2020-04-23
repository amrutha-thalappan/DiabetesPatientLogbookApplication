package view;

import dto.DataListDto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataDisplayView implements Serializable {

    private List<DataListDto> dataListDtos;

    @PostConstruct
    public void init() {

    }

    public List<DataListDto> getDataListDtos() {
        return dataListDtos;
    }

    public void setDataListDtos(List<DataListDto> dataListDtos) {
        this.dataListDtos = dataListDtos;
    }
}
