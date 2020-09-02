package com.qa.fit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The Fit with this ID could not be found")

public class FitNotFoundException extends EntityNotFoundException {
}
