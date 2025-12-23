package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelfPracticeNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 3, 5, 3, -2, 0, 15, 22, 10, 7, -5, 18, 4, 22, 31, 1, 12, -1, 5, 40);

//      How do you find all even numbers from a List<Integer> using streams?
        System.out.println("1. Find Even Numbers");
        List<Integer> evenNumber = list.stream().filter(e->e%2==0).collect(Collectors.toList());
        System.out.println("Even Number: " + evenNumber);

//      How do you find all odd numbers using streams?
        System.out.println("2. Find Odd Numbers");
        List<Integer> oddNumber = list.stream().filter(e->e%2!=0).collect(Collectors.toList());
        System.out.println("Odd Number: " +oddNumber);

//        How do you find the maximum number in a List<Integer> using streams?
        System.out.println("3. Find Maximum number");
        Integer max = list.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(null);
        System.out.println(max);
        Integer max2 = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max2);
        Integer max3 = list.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println(max3);
        Integer max5 =list.stream().collect(Collectors.maxBy(Integer::compareTo)).get();
        System.out.println(max5);


//      How do you find the minimum number in a List<Integer>?
        System.out.println("4. Find Minimum Number");
        Integer min = list.stream().sorted(Comparator.naturalOrder()).findFirst().orElse(null);
        Integer min2 = list.stream().min(Integer::compareTo).get();
        Integer min3 = list.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println(min);
        System.out.println(min2);
        System.out.println(min3);

//        Find 2nd largest number
        System.out.println("5. Find 2nd Largest Number");
        Integer secondlargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println(secondlargest);

//      How do you find the sum of all integers using Stream API?
        System.out.println("6. Find Sum of List");
        Integer sum = list.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum);
        Integer sum2 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum2);
        Integer a = list.stream().mapToInt(i->i).sum();
        System.out.println(a);

//        How do you calculate the average of numbers using streams?
        System.out.println("6. Find Average of List");
        Double avg = list.stream().mapToInt(i->i).average().getAsDouble();
        System.out.println(avg);
        Double avg2 = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avg2);

//      How do you remove duplicate numbers from a list using streams?
        System.out.println("7. Remove Duplicate");
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
        Set<Integer> distinct2 = list.stream().collect(Collectors.toSet());
        System.out.println(distinct2);

//      How do you find duplicate numbers from a List<Integer> using streams?
        System.out.println("8. Find Duplicates Element");
        //1st Way
        List<Integer> duplicate= list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting())).entrySet()
                .stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
        System.out.println(duplicate);
        //2nd way
        Set<Integer> duplicates = list.stream().filter(n -> Collections.frequency(list, n) > 1).collect(Collectors.toSet());
        System.out.println("Duplicates: " + duplicates);
        //3rd Way
        HashSet set = new HashSet<>();
        list.stream().filter(e-> !set.add(e)).collect(Collectors.toList());

//        print non-repeated numbers.
        System.out.println("9. Find Non-repeated numbers:");
        //1st way
        list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting())).entrySet().stream()
                .filter(e->e.getValue()==1)
                .forEach(e-> System.out.println(e.getKey()));

        //2nd way
        Set<Integer> unique = list.stream().filter(n -> Collections.frequency(list, n) == 1).collect(Collectors.toSet());
        System.out.println("Unique: " + unique);

//        Find first non-repeated number from the list
        System.out.println("10. Find First Non-repeated numbers:");
        list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1).findFirst().map(Map.Entry::getKey).ifPresent(e-> System.out.println("First non-repeated number: " + e));

//      How do you sort a list in ascending order using Stream API?
        System.out.println("11. Sort list in ascending");
        List<Integer> sortedlist = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sortedlist);

//      How do you sort a list in descending order using Stream API?
        System.out.println("12. Sort list in Descending");
        List<Integer> sortedDes = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedDes);

//      How do you convert a list of integers into a comma-separated string using streams?
        System.out.println("13. Convert a list of integers into a comma-separated string ");
        String res1 = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(res1);

//      How do you count numbers greater than a specific value (e.g., > 10) using streams?
        System.out.println("14. ");
        Long counting = list.stream().filter(e->e>10).collect(Collectors.counting());
        System.out.println(counting);

//      How do you find the first non-repeated number from a list using streams?
        System.out.println("15. ");
        Integer firstNonRepeating = list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet()
                .stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().orElse(null);
        System.out.println(firstNonRepeating);

//      How do you find the first repeated number from a list using streams?
        System.out.println("16. ");
        Integer firstRepeating = list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet()
                .stream().filter(e->e.getValue()>1).map(e->e.getKey()).findFirst().orElse(null);
        System.out.println(firstRepeating);

//      How do you square each number in a list using Stream API?
        System.out.println("17. ");
        List<Integer> square = list.stream().map(e->e*e).collect(Collectors.toList());
        System.out.println(square);

//        How do you filter numbers starting with digit '1' using streams?
//        (Example: 10, 12, 19)
        System.out.println("18. ");
        List<Integer> asfsf = list.stream().map(String::valueOf).filter(e->e.startsWith("1")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(asfsf);

//        How do you find the second highest number in a list using Stream API?
        System.out.println("19. ");
        Integer secondHighest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println(secondHighest);

//      How do you find the second-lowest number in a list using Stream API?
        System.out.println("20. ");
        Integer secondLowest = list.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().orElse(null);
        System.out.println(secondLowest);

//      How do you check if any number in the list is greater than 50 using streams?
        System.out.println("21. ");
        Long countinggreater = list.stream().filter(e->e>50).collect(Collectors.counting());
        System.out.println(countinggreater>0? true: false);
        boolean re =list.stream().anyMatch(e->e>50);
        System.out.println(re);

//      How do you check if all numbers in the list are positive using streams?
        System.out.println("22. ");
        boolean allPositive = list.stream().allMatch(e-> e > 0);
        System.out.println(allPositive);

//        Find sum from number 1 to 100
        System.out.println("23. ");
        int sum1 = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).sum();
        System.out.println(sum1);  // 2550

//        reverse the array
        System.out.println("24. Reverse the array");
         int[] reverseit = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseit));
        int left = 0;
        int right = reverseit.length - 1;
        while (left<right){
            int temp = reverseit[left];
            reverseit[left] = reverseit[right];
            reverseit[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(reverseit));
//
        System.out.println("25. reverse the number");
        int x= 1234;
        int reversenum = 0;

        while (x > 0){
            int rem = x%10;
            reversenum = reversenum * 10 + rem;
            x= x/10;
        }
        System.out.println(reversenum);
        //Print the pattern 0 1 1 2 3 5 Fibonacci Series
        System.out.println("26. Fibonacci");

        int x26First = 0;
        int x26Second = 1;
        System.out.print(x26First + " " + x26Second + " ");

        for (int i=2; i<=5; i++){
            int c = x26First + x26Second;
            System.out.print(c + " ");
            x26First = x26Second;
            x26Second = c;
        }

        // {-9, 0, 2, 1, 1, 3, 5, 6} find least missing positive number


    }
}
