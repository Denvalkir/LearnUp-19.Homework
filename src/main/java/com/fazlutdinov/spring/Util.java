package com.fazlutdinov.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Util {

    public static boolean checkNum(String str) {
        boolean rsl = false;
        
        for (int i = 0; i < str.length(); i++) {
            rsl = str.charAt(i) >= 48 && str.charAt(i) <= 57 && str.length() != 0;
        }
        return rsl;
    }

    public static Locale setLang() throws IOException {
        while (true) {
            System.out.println("Выберите язык пожалуйста:\n 1) - русский\n 2) - english");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            if (str.equals("1")) {
                return Locale.getDefault();
            } else if (str.equals("2")) {
                return Locale.US;
            } else {
                System.out.println("Введите цифру 1 или 2 на консоли");
            }
        }
    }
}
