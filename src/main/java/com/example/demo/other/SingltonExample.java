package com.example.demo.other;

//1st way: Eager Initialization
//public class SingltonExample {
//    // object create ho jata hai class load hote hi
//    private static final SingltonExample INSTANCE = new SingltonExample();
//
//    // private constructor → bahar object nahi ban sakta
//    private SingltonExample() {}
//
//    public static SingltonExample getInstance() {
//        return INSTANCE;
//    }
//}

//2nd way: Lazy Initialization with Double-Checked Locking
public class SingltonExample {

    private static volatile SingltonExample instance;

    private SingltonExample() {}

    public static SingltonExample getInstance() {
        if (instance == null) {                    // 1. No lock
            synchronized (SingltonExample.class) {       // 2. Lock only first time
                if (instance == null) {            // 3. Double check
                    instance = new SingltonExample();
                }
            }
        }
        return instance;
    }
}
