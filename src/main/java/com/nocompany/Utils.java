package com.nocompany;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by igorfiller on 09.07.17.
 */
public class Utils {

    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;

        Objects.equals(zero, one);

        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add("aba");

        System.out.println(set);
    }

    public static void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
