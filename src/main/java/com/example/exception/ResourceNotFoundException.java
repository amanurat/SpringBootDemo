package com.example.exception;

/**
 * Created by Assanai Manurat on 12/7/2016 AD.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
