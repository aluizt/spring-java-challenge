package br.com.tavares.springjavachallenge.springjavachallenge.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends ApiException {

    private static final long serialVersionUID = 3703179933479504025L;

    private Integer code;
    private String message;
    private String detail;
    private String field;
    private HttpStatus httpCode;

    public GenericException(String message, HttpStatus httpCode) {
        super(message, httpCode);
        this.message = message;
        this.httpCode = httpCode;
    }

    public GenericException(String message, String detail, HttpStatus httpCode) {
        super(message, httpCode);
        this.message = message;
        this.detail = detail;
        this.httpCode = httpCode;
    }

    public GenericException(Integer code, String message, String detail, String field, HttpStatus httpCode) {
        super(message, httpCode);
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.field = field;
        this.httpCode = httpCode;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

    public String detail() {
        return detail;
    }

    public String field() {
        return field;
    }

    public HttpStatus httpCode() {
        return httpCode;
    }
}
