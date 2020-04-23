package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DiabetesDataDto;
import dto.ReadingDto;
import enumtype.DayTime;
import enumtype.NightChecking;
import enumtype.ReadingType;
import enumtype.TimeOfRecording;
import service.ReadingService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@ViewScoped
public class ReadingView implements Serializable {

    private String date;
    private String day;

    private String time;
    private Integer reading;
    private String place;
    private String readingType;
    private String dayTime;
    private String timeOfRecording;
    private String nightChecking;

    private Map<String,String> readingTypes;
    private Map<String,String> dayTimes;
    private Map<String, String> timesOfRecording;
    private Map<String, String> nightChecks;

    private List<ReadingDto> readingDtoList = new ArrayList<>();

    @ManagedProperty(value="#{readingService}")
    private ReadingService service;

    public void setService(ReadingService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        time = null;
        reading = null;
        place = null;

        readingTypes = new HashMap<String, String>();
        readingTypes.put("Insulin", ReadingType.INSULIN.toString());
        readingTypes.put("Sugar", ReadingType.SUGAR.toString());

        dayTimes = new HashMap<String, String>();
        dayTimes.put("Morning", DayTime.MORNING.toString());
        dayTimes.put("Noon", DayTime.NOON.toString());
        dayTimes.put("Evening", DayTime.EVENING.toString());
        dayTimes.put("Night", DayTime.NIGHT.toString());

        timesOfRecording = new HashMap<String, String>();
        timesOfRecording.put("Before food", TimeOfRecording.BEFORE_FOOD.toString());
        timesOfRecording.put("After food", TimeOfRecording.AFTER_FOOD.toString());

        nightChecks = new HashMap<String, String>();
        nightChecks.put("Before bed", NightChecking.BEFORE_BED.toString());
        nightChecks.put("Sugar at fast", NightChecking.SUGAR_AT_FAST.toString());

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getTimeOfRecording() {
        return timeOfRecording;
    }

    public void setTimeOfRecording(String timeOfRecording) {
        this.timeOfRecording = timeOfRecording;
    }

    public String getNightChecking() {
        return nightChecking;
    }

    public void setNightChecking(String nightChecking) {
        this.nightChecking = nightChecking;
    }

    public Map<String, String> getReadingTypes() {
        return readingTypes;
    }

    public void setReadingTypes(Map<String, String> readingTypes) {
        this.readingTypes = readingTypes;
    }

    public Map<String, String> getDayTimes() {
        return dayTimes;
    }

    public void setDayTimes(Map<String, String> dayTimes) {
        this.dayTimes = dayTimes;
    }

    public Map<String, String> getTimesOfRecording() {
        return timesOfRecording;
    }

    public void setTimesOfRecording(Map<String, String> timesOfRecording) {
        this.timesOfRecording = timesOfRecording;
    }

    public Map<String, String> getNightChecks() {
        return nightChecks;
    }

    public void setNightChecks(Map<String, String> nightChecks) {
        this.nightChecks = nightChecks;
    }

    public List<ReadingDto> getReadingDtoList() {
        return readingDtoList;
    }

    public void setReadingDtoList(List<ReadingDto> readingDtoList) {
        this.readingDtoList = readingDtoList;
    }

    public void addReading() {
        ReadingDto readingDto = new ReadingDto();
        readingDto.setTime(this.getTime());
        readingDto.setPlace(this.getPlace());
        readingDto.setReadingType(ReadingType.INSULIN);
        readingDto.setDayTime(DayTime.EVENING);
        readingDto.setTimeOfRecording(TimeOfRecording.AFTER_FOOD);
        readingDto.setNightChecking(NightChecking.BEFORE_BED);
        readingDto.setReading(this.reading);
        service.getReadingDtoList().add(readingDto);
    }

    public void saveReading(){
        DiabetesDataDto diabetesDataDto = new DiabetesDataDto();
        diabetesDataDto.setDate(new Date());
        diabetesDataDto.setDay(this.day);
        diabetesDataDto.setUserId(1);
        diabetesDataDto.setReadings(service.getReadingDtoList());
        Client client = ClientBuilder.newClient();
        WebTarget clientTraget = client.target("http://localhost:8080").path("readings/");
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(diabetesDataDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Response response =  clientTraget.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonString));
    }

}
