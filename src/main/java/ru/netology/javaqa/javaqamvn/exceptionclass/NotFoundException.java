package ru.netology.javaqa.javaqamvn.exceptionclass;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
