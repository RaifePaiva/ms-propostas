package br.com.zup.mspropostas.models.out;

public class ErrorHandler {

    private int status_code;

    private String field;

    private String exception_class;

    private String message;


    @Deprecated
    public ErrorHandler(){

    }

    public ErrorHandler(int status_code, String field, String class_error, String message) {
        this.status_code = status_code;
        this.field = field;
        this.exception_class = class_error;
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public String getField() {
        return field;
    }

    public String getClass_error() {
        return exception_class;
    }

    public String getMessage() {
        return message;
    }
}
