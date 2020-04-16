package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.enumtype.ReadingType;
import io.swagger.enumtype.TimeOfRecording;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Reading")
public class Reading {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diabetesDataId", nullable = false)
    private DiabetesData diabetesData = null;

    @JsonProperty("time")
    @Column(name = "time")
    private String time = null;

    @JsonProperty("reading")
    @Column(name = "reading")
    private Integer reading = null;

    @JsonProperty("place")
    @Column(name = "place")
    private String place = null;

    @JsonProperty("readingType")
    @Column(name = "readingType")
    private ReadingType readingType;

    @JsonProperty("timeOfRecording")
    @Column(name = "timeOfRecording")
    private TimeOfRecording timeOfRecording;

    @JsonProperty("isBeforeBed")
    @Column(name = "isBeforeBed")
    private Boolean isBeforeBed = Boolean.FALSE;

    @JsonProperty("isSugarAtFast")
    @Column(name = "isSugarAtFast")
    private Boolean isSugarAtFast = Boolean.FALSE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiabetesData getDiabetesData() {
        return diabetesData;
    }

    public void setDiabetesData(DiabetesData diabetesData) {
        this.diabetesData = diabetesData;
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

    public ReadingType getReadingType() {
        return readingType;
    }

    public void setReadingType(ReadingType readingType) {
        this.readingType = readingType;
    }

    public TimeOfRecording getTimeOfRecording() {
        return timeOfRecording;
    }

    public void setTimeOfRecording(TimeOfRecording timeOfRecording) {
        this.timeOfRecording = timeOfRecording;
    }

    public Boolean getBeforeBed() {
        return isBeforeBed;
    }

    public void setBeforeBed(Boolean beforeBed) {
        isBeforeBed = beforeBed;
    }

    public Boolean getSugarAtFast() {
        return isSugarAtFast;
    }

    public void setSugarAtFast(Boolean sugarAtFast) {
        isSugarAtFast = sugarAtFast;
    }
}
