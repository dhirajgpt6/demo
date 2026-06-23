package com.example.demo.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonPractice {

    public static void main(String[] args) {
        // shift all 1 left to right
        // INPUT: int[] leftToRight = {1, 2, 3, 4, 5, 1, 1, 3, 1, 2, 5}; OUTPUT: {2, 3, 4, 5, 3, 2, 5, 1, 1, 1, 1}
        Question1();
        //Same Question using stream
        Question1_2();

        // shift all 1 right to left
        // INPUT: int[] leftToRight = {1, 2, 3, 4, 5, 1, 1, 3, 1, 2, 5}; OUTPUT: {2, 3, 4, 5, 3, 2, 5, 1, 1, 1, 1}
        Question2();

        // You have a Map, in Key have string and in Value have Integer. You have to sort the map based on value.
        Question3();

        // 2 Thread create kro by Executor service. and 1 thread odd number print krega and 2nd Thread even number print krega. one by one
//        Question4();

        // Merge two Arrays, INPUT: arr1 = {1,2,4}, arr2 = {5,6,7}, OUTPUT: {1,2,4,5,6,7}
        Question5();

        // find word start with a from the given sentance.
        Question6();

        //Print all prime number between 1 to 100
        System.out.println("PRIME number");
        Question7();

        //ArmstrongNumber ka program
        ArmstrongNumber();

        // 2 string given have to check s2 is substring of s1 or not
        Question8();

        //Write a program to search an integer from a list of 10 integers.
        Question9();


        Integer num = 10;
        changeValue(num);
        System.out.println("number is : " + num);
        int a = 128;
        int b = 128;
        System.out.println(a == b);
        printPrimeNumber();
//        Integer a = 128;
//        Integer b = 128;
//        System.out.println(a == b);
    }

    private static void Question9() {
        List<Integer> list = Arrays.asList(10, 25, 3, 8, 50, 18, 7, 99, 42, 6);
        int target  = 50;
        list.stream().filter(x -> x == target).findFirst().ifPresentOrElse(x-> System.out.println("found"), ()-> System.out.println("Not found"));

    }
    

    private static void Question8() {
        String s1 = "flower";
        String s2 = "ow";
        System.out.println("Question8");
        System.out.println(s1.indexOf(s2));
        System.out.println(s1.contains(s2));
        System.out.println(s1.indexOf(s2) != -1 ? "true": "false");
    }

    private static void changeValue(Integer num) {
        num = 20;
    }

    private static void Question7() {
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static void Question6() {
        String input = "banana apple ask trip laptop appear";
        String collect = Arrays.stream(input.split(" ")).filter(e -> e.startsWith("a")).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    private static void Question5() {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {5, 7, 8, 9, 10};
        Integer[] concat = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(Integer[]::new);
        System.out.println(Arrays.toString(concat));
    }

    private static void Question4() {
        AtomicInteger start = new AtomicInteger(0); // class level p variable se bhi ho skta hai...
        final int end = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable odd = () -> {
            while (start.get() <= end) {
                synchronized (CommonPractice.class) {
                    if (start.get() % 2 != 0) {
                        System.out.println("Odd Thread: " + Thread.currentThread().getName() + " : " + start);
                        start.incrementAndGet();
                        CommonPractice.class.notify();
                    } else {
                        try {
                            CommonPractice.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        };
        Runnable even = () -> {
            while (start.get() <= end) {
                synchronized (CommonPractice.class) {
                    if (start.get() % 2 == 0) {
                        System.out.println("Even Thread: " + Thread.currentThread().getName() + " : " + start);
                        start.incrementAndGet();
                        CommonPractice.class.notify();
                    } else {
                        try {
                            CommonPractice.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        executorService.submit(odd);
        executorService.submit(even);

        executorService.shutdown();
    }

    private static void Question3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 12);
        map.put("zef", 1);
        map.put("ghi", 24);
        map.put("jkl", 5);
        map.put("mno", 16);
        map.put("mno", 67);
        map.put("stu", 48);

        Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // this is merge function. for duplicate key handle. to avoid runtime exception
                        LinkedHashMap::new)); // Linkedhashmap used for maintain the insertion order.
        System.out.println(collect);

    }

    private static void Question2() {
        List<Integer> inputData = Arrays.asList(1, 2, 3, 4, 5, 1, 1, 3, 1, 2, 5);
        int st = inputData.size() - 1;
        for (int i = st; i >= 0; i--) {
            if (inputData.get(i) != 1) {
                inputData.set(st--, inputData.get(i));
            }
        }
        while (st >= 0) {
            inputData.set(st--, 1);
        }
        System.out.println(inputData);
    }

    private static void Question1_2() {
        List<Integer> leftToRight = Arrays.asList(1, 2, 3, 4, 5, 1, 1, 3, 1, 2, 5);
        List<Integer> result = Stream.concat(leftToRight.stream().filter(e -> e != 1), leftToRight.stream().filter(e -> e == 1)).collect(Collectors.toList());
        System.out.println(result);
    }

    private static void Question1() {
        int[] leftToRight = {1, 2, 3, 4, 5, 1, 1, 3, 1, 2, 5};
        int index = 0;
        for (int i = 0; i < leftToRight.length; i++) {
            if (leftToRight[i] != 1) {
                leftToRight[index] = leftToRight[i];
                index++;
            }
        }
        while (index < leftToRight.length) {
            leftToRight[index] = 1;
            index++;
        }
        System.out.println("Shift 1 left to right: " + Arrays.toString(leftToRight));
    }

    private static void printPrimeNumber() {
        for (int i = 2; i <= 101; i++) {
            boolean primeHai = true;
            for (int j=2; j<i; j++) {
                if(i%j==0) {
                    primeHai = false;
                    break;
                }
            }
            if(primeHai){
                System.out.println(i);
            }
        }
    }


    public static void ArmstrongNumber() {

        int num = 153;
        int original = num;

        int count = 0;
        int temp = num;

        // count digits
        while(temp > 0){
            count++;
            temp = temp / 10;
        }

        int sum = 0;
        temp = num;

        // calculate sum of powers
        while(temp > 0){
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp = temp / 10;
        }

        // check Armstrong
        if(sum == original){
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not Armstrong");
        }
    }



    public static void factorial() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int res = 1;
        for(int i = input; i > 1; i--){
            res = res * i;
        }
        System.out.println(res);
    }













    private static void createEmployeeList(List<Employee> empList){
        empList.add(new Employee(111, "Ram", 32, "No", "HR", 2000, 9000));
        empList.add(new Employee(112, "Laxman", 20, "Yes", "Java", 2001, 9000));
        empList.add(new Employee(113, "Bharat", 18, "No", "Java", 2001, 22000));
        empList.add(new Employee(114, "Strudhan", 20, "No", "Java", 2001, 25000));
        empList.add(new Employee(115, "Rahim", 22, "Yes", "Python", 2002, 60000));
        empList.add(new Employee(116, "Krishna", 30, "Yes", "HR", 2000, 43000));
        empList.add(new Employee(117, "Hanuman", 30, "No", "HR", 2000, 54000));
        empList.add(new Employee(118, "Shiv", 31, "No", "Python", 2002, 23000));
        empList.add(new Employee(119, "Vishnu", 33, "Yes", "Finance", 2002, 65000));
        empList.add(new Employee(120, "ShaniDev", 40, "Yes", "Finance", 2000, 83000));
    }
}

