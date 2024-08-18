package com.example.exceptionhandler;

public class ErrorMessage {
    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    private String errormessage;

    public ErrorMessage() {
    }

    public ErrorMessage(String errormessage) {
        this.errormessage=errormessage;
    }
}
