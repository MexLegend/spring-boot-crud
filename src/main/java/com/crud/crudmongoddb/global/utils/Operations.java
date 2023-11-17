package com.crud.crudmongoddb.global.utils;

public class Operations {
    public static String StrimBrackets(String message){
        return message.replaceAll("[\\[\\]]", "");
    }
}
