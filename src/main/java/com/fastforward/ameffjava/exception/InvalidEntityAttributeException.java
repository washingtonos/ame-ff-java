package com.fastforward.ameffjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidEntityAttributeException extends RuntimeException{

  public InvalidEntityAttributeException(String message){
    super();
  }
}
