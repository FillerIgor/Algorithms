package com.nocompany;

/**
 * Created by igorfiller on 09.07.17.
 */
public class Utils {

    public static void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
