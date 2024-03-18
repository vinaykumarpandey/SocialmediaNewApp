package com.SocialMediaAppNew.SocialMediaAppNew.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    private String message;
    private String description;
    private LocalDateTime localDateTime;

    public ErrorDetails(String message, String description, LocalDateTime localDateTime) {
        this.message = message;
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
