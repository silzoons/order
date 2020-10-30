package com.sil.eurder.exceptiona;

public class NotACustomerException extends RuntimeException {

    public NotACustomerException(String message) {
        super(message);
    }
}


