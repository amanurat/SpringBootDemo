package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Assanai Manurat on 12/7/2016 AD.
 */
@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleGlobalException() {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(e.getMessage());
        messageInfo.setStatus(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity(messageInfo, HttpStatus.NOT_FOUND);
    }

}

class MessageInfo {
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
