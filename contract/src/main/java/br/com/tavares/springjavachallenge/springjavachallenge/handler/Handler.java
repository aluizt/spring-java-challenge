package br.com.tavares.springjavachallenge.springjavachallenge.handler;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.ApiException;
import br.com.tavares.springjavachallenge.springjavachallenge.exception.ErrorModel;
import br.com.tavares.springjavachallenge.springjavachallenge.exception.ErrorModelBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Handler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            errors.put("HttpStatus", HttpStatus.BAD_REQUEST.toString());
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiException.class)
    public ErrorModel apiExceptionValidator(ApiException e) {
        return ErrorModelBuilder.anErrorModel()
                .withMessage(e.getMessage())
                .withError(e.getClass().getName())
                .withStatus(e.getStatus())
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ErrorModel handleDateTimeParseException(DateTimeParseException e) {
        return ErrorModelBuilder.anErrorModel()
                .withMessage("Formato incorreto, verifique a valor informado")
                .withError(e.getClass().getName())
                .withStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorModel handHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ErrorModelBuilder.anErrorModel()
                .withMessage("Formato incorreto, verifique os dados informados")
                .withError(e.getClass().getName())
                .withStatus(HttpStatus.BAD_REQUEST)
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorModel handleException(Exception e) {
        return ErrorModelBuilder.anErrorModel()
                .withMessage("Ocorreu um erro inesperado")
                .withError(e.getClass().getName())
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}

