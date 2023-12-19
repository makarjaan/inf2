package ru.itis.inf304;

public class RecurringElementException extends Exception{
    RecurringElementException(){
        super("этот элемент уже имеется в Set");
    }
}
