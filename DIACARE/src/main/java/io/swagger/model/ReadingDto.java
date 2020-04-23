package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.enumtype.DayTime;
import io.swagger.enumtype.NightChecking;
import io.swagger.enumtype.ReadingType;
import io.swagger.enumtype.TimeOfRecording;

import javax.persistence.Column;

public class ReadingDto {

    private String time;
    private Integer reading;
    private String place;
    private ReadingType readingType;
    private DayTime dayTime;
    private TimeOfRecording timeOfRecording;
    private NightChecking nightChecking;

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

    public ReadingType getReadingType() {
        return readingType;
    }

    public void setReadingType(ReadingType readingType) {
        this.readingType = readingType;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public TimeOfRecording getTimeOfRecording() {
        return timeOfRecording;
    }

    public void setTimeOfRecording(TimeOfRecording timeOfRecording) {
        this.timeOfRecording = timeOfRecording;
    }

    public NightChecking getNightChecking() {
        return nightChecking;
    }

    public void setNightChecking(NightChecking nightChecking) {
        this.nightChecking = nightChecking;
    }
}
