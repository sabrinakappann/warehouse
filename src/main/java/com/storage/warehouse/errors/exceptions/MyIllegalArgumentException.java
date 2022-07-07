package com.storage.warehouse.errors.exceptions;

public class MyIllegalArgumentException extends IllegalArgumentException{

    private String wrongArgument;

    public MyIllegalArgumentException(String wrongArgument, String message) {
        super(message);
        this.wrongArgument = wrongArgument;
    }


    public String getWrongArgument() {
        return wrongArgument;
    }

    public void setWrongArgument(String wrongArgument) {
        this.wrongArgument = wrongArgument;
    }
}
