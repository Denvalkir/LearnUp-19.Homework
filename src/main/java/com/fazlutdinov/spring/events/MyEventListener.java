package com.fazlutdinov.spring.events;

import com.fazlutdinov.spring.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import static com.fazlutdinov.spring.Main.num;
import static com.fazlutdinov.spring.Main.lang;

@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent>, ApplicationContextAware {
    ApplicationContext context;

    @Override
    public void onApplicationEvent(MyEvent event) {
        if (!Util.checkNum(event.getData())) {
            System.out.println(context.getMessage(event.getData(), null, lang));
        } else if (num > Integer.parseInt(event.getData())) {
            System.out.println(context.getMessage("MyNumIsBig", null, lang));
        } else if (num < Integer.parseInt(event.getData())) {
            System.out.println(context.getMessage("myNumIsLess", null, lang));
        } else {
            System.out.println(context.getMessage("youWon", new Object[]{event.getData()}, lang));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
