package com.nocompany.general;

import java.util.Arrays;

public class ATMMachine {
    static int[] atm;
    static int[] currencies;

    public ATMMachine() {
        atm = new int[5];
        currencies = new int[]{20, 50, 100, 200, 500};
    }

    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        //deposit(new int[]{0, 0, 1, 2, 1});
        //int[] withdraw = withdraw(600);
        //deposit(new int[]{0, 1, 0, 1, 1});
        //int[] withdraw1 = withdraw(600);
        //int[] withdraw2 = withdraw(550);

        deposit(new int[]{0, 10, 0, 3, 0});
        int[] withdraw = withdraw(500);

        System.out.println("Result atm:\n" + Arrays.toString(atm));
        System.out.println("Result withdraw:\n" + Arrays.toString(withdraw));
    }

    public static void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            int amount = banknotesCount[i];
            atm[i] = atm[i] + amount;
        }
    }

    public static int[] withdraw(int amount) {
        int[] result = new int[currencies.length];
        int index = currencies.length - 1;
        while (amount > 0 && index >= 0) {
            int takethismany = Math.min(amount / currencies[index], atm[index]);
            result[index] = takethismany;
            amount -= takethismany * currencies[index];
            index--;
        }

        if (amount != 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < 5; i++) {
                atm[i] -= result[i];
            }
            return result;
        }
    }

    public static int[] withdrawOwn(int amount) {
        int[] result = new int[currencies.length];
        for (int i = currencies.length - 1; i >= 0; i--) {
            while (amount >= currencies[i]) {
                if (atm[i] - 1 >= 0) {
                    amount = amount - currencies[i];
                    result[i] = result[i] + 1;
                    atm[i] = atm[i] - 1;
                } else {
                    break;
                }
            }
        }
        for (int res : result) {
            if (res != 0 && amount != 0) {
                deposit(result);
                break;
            }
        }
        return amount == 0 ? result : new int[]{-1};
    }
}
