package com.nocompany;

/**
 * Created by igorfiller on 16.07.17.
 */
public class NPECheck {
    private static void sayHi(){
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        NPECheck clazz = null;
        clazz.sayHi();
    }
}
