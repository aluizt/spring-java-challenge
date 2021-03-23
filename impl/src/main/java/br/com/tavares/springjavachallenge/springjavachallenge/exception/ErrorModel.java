package br.com.tavares.springjavachallenge.springjavachallenge.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorModel {

    private String message;
    private String error;
    private HttpStatus status;
    private Map<String, String> formErrors;

    public ErrorModel(String message, String error, HttpStatus status, Map<String, String> formErrors) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.formErrors = formErrors;
    }
}
