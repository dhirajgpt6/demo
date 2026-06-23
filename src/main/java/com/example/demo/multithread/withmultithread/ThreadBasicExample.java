package com.example.demo.multithread.withmultithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ThreadBasicExample {
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
    }
}
