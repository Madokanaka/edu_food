package org.attractor.edu_food.exceptions;

import java.util.NoSuchElementException;

public class ResourceNotFoundException extends NoSuchElementException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
