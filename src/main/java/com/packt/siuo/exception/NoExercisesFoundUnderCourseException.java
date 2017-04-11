package com.packt.siuo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Brak zadania w danym kursie")

public class NoExercisesFoundUnderCourseException extends RuntimeException{
private static final long SerialVersionUID=3935230281455340039L;
}
