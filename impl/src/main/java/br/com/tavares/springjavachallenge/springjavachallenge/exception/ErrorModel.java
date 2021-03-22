package br.com.tavares.springjavachallenge.springjavachallenge.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Map;

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

    @Override
    public String toString() {
        return "ErrorModel{" +
                "message='" + message + '\'' +
                ", error='" + error + '\'' +
                ", status=" + status +
                ", formErrors=" + formErrors +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getFormErrors() {
        return formErrors;
    }

    public void setFormErrors(Map<String, String> formErrors) {
        this.formErrors = formErrors;
    }
}
