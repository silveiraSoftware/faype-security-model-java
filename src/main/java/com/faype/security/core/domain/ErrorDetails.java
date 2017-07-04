package com.faype.security.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wmfsystem
 */
public class ErrorDetails {

    private String title;

    private Long status;

    private Long timestamp;

    private String developerMessage;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resolutions;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<?> fields;

    public ErrorDetails() {
    }

    public ErrorDetails(String title, Long status, Long timestamp, String developerMessage) {
        this.title = title;
        this.status = status;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public List<String> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<String> resolutions) {
        this.resolutions = resolutions;
    }

    public List<?> getFields() {
        return fields;
    }

    public void setFields(List<?> fields) {
        this.fields = fields;
    }

}
