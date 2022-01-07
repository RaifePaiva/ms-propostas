package br.com.zup.mspropostas.controllers.exceptions;

import br.com.zup.mspropostas.models.out.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class SpringHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorHandler>> catchValidationError(MethodArgumentNotValidException exception){
        List<ErrorHandler> formHandlerErros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();

        fieldErrors.forEach(error -> {
            ErrorHandler errorHandler = new ErrorHandler(HttpStatus.BAD_REQUEST.value(), error.getField(), exception.getClass().toString(), error.getDefaultMessage());
            formHandlerErros.add(errorHandler);
        });

        return ResponseEntity.badRequest().body(formHandlerErros);
    }

}
