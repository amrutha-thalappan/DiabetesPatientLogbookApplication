package view;

import dto.DataListDto;
import dto.ReadingDetailsDto;
import service.DataListService;
import util.Utilities;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataDisplayView implements Serializable {

    private String username;

    private List<ReadingDetailsDto> readingDetailsDtos;

    @ManagedProperty(value="#{dataListService}")
    private DataListService dataListService;

    @PostConstruct
    public void init() {
        username = "Hello "+Utilities.getUsername();
        Integer userId = Utilities.getUserId();
        if(userId == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Login!"));
            String  page = "http://localhost:8082/CLIENT_war_exploded/index.xhtml";
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(page);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        readingDetailsDtos = dataListService.getWeekReadings(userId);
    }

    public void setDataListService(DataListService dataListService) {
        this.dataListService = dataListService;
    }

    public List<ReadingDetailsDto> getReadingDetailsDtos() {
        return readingDetailsDtos;
    }

    public void setReadingDetailsDtos(List<ReadingDetailsDto> readingDetailsDtos) {
        this.readingDetailsDtos = readingDetailsDtos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
