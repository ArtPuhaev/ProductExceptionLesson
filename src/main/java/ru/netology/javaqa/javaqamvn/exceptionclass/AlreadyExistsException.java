package ru.netology.javaqa.javaqamvn.exceptionclass;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String s) {
        super(s);
    }
}
