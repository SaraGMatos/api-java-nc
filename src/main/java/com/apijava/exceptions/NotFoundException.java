package com.apijava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
  public NotFoundException(String errorMessage) {
    super(HttpStatus.NOT_FOUND, errorMessage);
  }
}
