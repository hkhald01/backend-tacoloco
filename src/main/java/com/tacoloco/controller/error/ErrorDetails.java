package com.tacoloco.controller.error;

import java.time.LocalDateTime;
/**
 *
 * @author Heikel Khaldi
 */

// implementing a custom error message handler
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private int status;

    public ErrorDetails(LocalDateTime timestamp, String message, int status) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
