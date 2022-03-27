package com.fazlutdinov.spring;

import com.fazlutdinov.spring.events.MyEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Random;

public class Main {

    static Random random = new Random();
    public static int num = random.nextInt(10);
    public static Locale lang;

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);

        lang = Util.setLang();

        publisher.publishEvent("welcome");
        publisher.publishEvent("startGame");

        boolean gameGuess = true;

        while (gameGuess) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            if (Util.checkNum(str)) {
                publisher.publishEvent(str);
                if (Integer.parseInt(str) == num) {
                    gameGuess = false;
                }
            }
        }
    }
}
