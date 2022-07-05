package com.storage.warehouse.errors.validation;

import com.storage.warehouse.errors.auxiliary.FieldMessage;
import com.storage.warehouse.errors.auxiliary.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;
    private List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrorOnField(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }
}