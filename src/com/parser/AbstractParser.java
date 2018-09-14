package com.parser;

public abstract class AbstractParser implements Parser {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // You can do some common tasks for all your factories in this class
    public String getRegularExpression(String regExFor){
        System.out.println(Thread.currentThread().getId() + " : You can implement a Factory here to get Regular Expressions : " + regExFor);
        return regExFor;
    }

}
