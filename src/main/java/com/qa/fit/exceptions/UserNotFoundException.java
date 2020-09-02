package com.qa.fit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The User with this ID could not be found")

public class UserNotFoundException  extends EntityNotFoundException {
}
