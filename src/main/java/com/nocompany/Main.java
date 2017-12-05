package com.nocompany;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static int numberOfGuests = 5;
    static List<String> sticks = new LinkedList();

    public static void main(String[] args) throws InterruptedException {

        List<Philosoph> guests = new ArrayList<>(numberOfGuests);
        List<Lock> sticksList = new ArrayList<>(numberOfGuests);
        for (int i = 1; i <= numberOfGuests; i++) {
            sticks.add(String.valueOf(i));
            sticksList.add(new ReentrantLock());
        }
        for (int i = 0; i < numberOfGuests; i++) {
            guests.add(new Philosoph(String.valueOf(i + 1), sticks.get(i % numberOfGuests), sticks.get((i + 1) % numberOfGuests),
                    sticksList.get(i % numberOfGuests), sticksList.get((i + 1) % numberOfGuests)));
        }

        for (Philosoph currentGuest : guests) {
            Thread thread = new Thread(currentGuest);
            thread.start();
        }

        boolean allAreFull = false;
        while (!allAreFull) {
            Thread.sleep(3000);
            for (Philosoph currentGuest : guests) {
                if (currentGuest.getSaturationLevel() != 0.0) {
                    System.out.println("Check is " + currentGuest + " full?");
                }
                allAreFull = currentGuest.getSaturationLevel() >= 100.0;
            }
        }
    }
}
