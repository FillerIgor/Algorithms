package com.nocompany;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by igorfiller on 09.07.17.
 */
public class Philosoph implements Runnable {

    private String name;
    private String leftStick;
    private String rightStick;
    private double saturationLevel;
    private Lock leftLock;
    private Lock rightLock;

    public Philosoph(String name, String leftStick, String rightStick, Lock leftLock, Lock rightLock) {
        this.name = name;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
        this.leftLock = leftLock;
        this.rightLock = rightLock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeftStick() {
        return leftStick;
    }

    public void setLeftStick(String leftStick) {
        this.leftStick = leftStick;
    }

    public String getRightStick() {
        return rightStick;
    }

    public void setRightStick(String rightStick) {
        this.rightStick = rightStick;
    }

    public double getSaturationLevel() {
        return saturationLevel;
    }

    public void setSaturationLevel(double saturationLevel) {
        this.saturationLevel = saturationLevel;
    }

    @Override
    public void run() {
        while (saturationLevel <= 100.0) {
            leftLock.lock();
            rightLock.lock();
            System.out.println(this + "Grab sticks" + " Left stick: " + leftStick + " Right strick: " + rightStick);
            Utils.pause(100);
            System.out.println(this + " Start eating...");
            long startTime = System.nanoTime(); //fetch starting time
            while ((System.nanoTime() - startTime) < 7000) {
                saturationLevel += 0.5;
            }
            System.out.println(this + "Stopped eating");
            rightLock.unlock();
            leftLock.unlock();
            System.out.println(this + "thinking ...");
            Utils.pause(1000);

        }
    }

    @Override
    public String toString() {
        return "Philosoph " + name + " saturation level " + saturationLevel + " ";
    }
}
