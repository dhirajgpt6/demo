package com.example.demo.stream.selfcode.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelfPracticeString {
    public static void main(String[] args) {
//================================================================================================================
        System.out.println("1. Count occurrence of each character in a string");
        String s1 = "India is my country"; // OUTPUT: {I=1, n=2, d=1, i=2, a=1, ...}
        //        -----------------------------------------------------------------------------
        //1st Way
        Map<String, Long> s1Result = Arrays.stream(s1.split(""))
                .filter(e-> !e.isBlank()) // remove blank space
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(s1Result);
        //        -----------------------------------------------------------------------------
        //2nd Way
        Map<Character, Long> charCountMapWithoutSpace = s1.chars()
                .mapToObj(c-> (char)c)
                .filter(c -> !Character.isWhitespace(c))  // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMapWithoutSpace);
//================================================================================================================
        System.out.println("2. Reverse a string without using built-in functions");
        String s2 = "Hello World"; // OUTPUT: "dlroW olleH"
//        -----------------------------------------------------------------------------
        //1st Way
        StringBuilder sb = new StringBuilder();
        for (int i=s2.length(); i>=1; i--){
            sb.append(s2.charAt(i-1));
        }
        System.out.println(sb);
//        -----------------------------------------------------------------------------
        //2nd Way
        char[] arr = s2.toCharArray();   // Step 1: Convert string to char array

        int left = 0;                    // Step 2: Two pointers
        int right = arr.length - 1;

        while (left < right) {           // Step 3: Loop until pointers meet
            // Step 4: Swap arr[left] and arr[right]
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;                       // Step 5: Move pointers inward
            right--;
        }

// Step 6: Convert array back to string
        String reversed = new String(arr);

        System.out.println(reversed);     // Output: dlroW olleH

//================================================================================================================

        System.out.println("3. Check if two strings are anagrams");
        String s3a = "listen";
        String s3b = "silent"; // OUTPUT: true


        if(s3a.length() != s3b.length()){
            System.out.println(false);
        }
        char[] s3aChar = s3a.toCharArray();
        char[] s3bChar = s3b.toCharArray();

        Arrays.sort(s3aChar);
        Arrays.sort(s3bChar);
        boolean isAnagram = Arrays.equals(s3aChar, s3bChar);
        System.out.println(isAnagram);
//       ================================================================================================================
        System.out.println("4. Find the first non-repeated character in a string");
        String s4 = "swiss"; // OUTPUT: 'w'

        Character firstNonRepeatingChar = s4.chars().mapToObj(e-> (char)e).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
        System.out.println(firstNonRepeatingChar);

//        ================================================================================================================

        System.out.println("5. Find the first repeated character in a string");
        String s5 = "abca"; // OUTPUT: 'a'
        Character firstRepeatingChar = s5.chars().mapToObj(e-> (char)e).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(e->e.getValue()>1).map(e->e.getKey()).findFirst().get();
        System.out.println(firstRepeatingChar);

//        ================================================================================================================

        System.out.println("6. Check if a string is a palindrome");
        String s6 = "racecar"; // OUTPUT: true
        char[] s6CharArray =s6.toCharArray();
        left = 0; right = s6CharArray.length - 1;
        boolean isPalindrome = true;
        while (left<right){
           if(s6CharArray[left]!=s6CharArray[right]){
               isPalindrome = false;
           }
           left++;
           right--;
       }
        System.out.println(isPalindrome);
//        ================================================================================================================

        System.out.println("7. Remove duplicate characters from a string");
        String s7 = "programming"; // OUTPUT: "progamin"
        String s7Result = s7.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(s7Result); // progamin
//        ================================================================================================================
        System.out.println("8. Count vowels and consonants in a string");
        String s8 = "Hello World"; // OUTPUT: vowels=3, consonants=7

        long vowels = s8.chars()
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();

        long consonants = s8.chars()
                .filter(ch -> ch >= 'a' && ch <= 'z' && "aeiou".indexOf(ch) == -1)
                .count();

        System.out.println("vowels=" + vowels + ", consonants=" + consonants);
//        ================================================================================================================
        System.out.println("9. Check if two strings are rotations of each other");
        String s9a = "ABCD";
        String s9b = "CDAB"; // OUTPUT: true
        if (s9a.length() != s9b.length()) {
            System.out.println(false);
        } else {
            // Step-2: s9b must exist in s9a + s9a
            boolean isRotation = (s9a + s9a).contains(s9b);
            System.out.println(isRotation); // true
        }
//        ================================================================================================================
        System.out.println("10. Find the maximum occurring character in a string");
        String s10 = "banana"; // OUTPUT: 'a'

        char maxChar = s10.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println(maxChar);
//        ================================================================================================================
        System.out.println("11. Reverse each word in a sentence");
        String s11 = "Java is fun"; // OUTPUT: "avaJ si nuf"
        String s11Result = Arrays.stream(s11.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(s11Result);
//        ================================================================================================================
        System.out.println("12. Reverse the order of words in a sentence");
        String s12 = "I love India"; // OUTPUT: "India love I"
        List<String> list = new ArrayList<>(Arrays.asList(s12.split(" ")));
        Collections.reverse(list);

        String s12Result = String.join(" ", list);
        System.out.println(s12Result);
//----------------------------------------------------------
        String s12Result2 = Arrays.stream(s12.split(" "))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        lst -> {
                            Collections.reverse(lst);
                            return String.join(" ", lst);
                        }
                ));

        System.out.println(s12Result2);
//        ================================================================================================================
        System.out.println("13. Longest substring without repeating characters");
        String s13 = "abcabcbb"; // OUTPUT: "abc"


        int left13 = 0;
        int right13 = 0;
        int maxLen13 = 0;
        int startIndex13 = 0;

        Set<Character> set = new HashSet<>();

        while (right13 < s13.length()) {

            char ch = s13.charAt(right13);

            // If duplicate found → shrink window
            while (set.contains(ch)) {
                set.remove(s13.charAt(left13));
                left13++;
            }

            set.add(ch);

            // Update longest window
            if (right13 - left13 + 1 > maxLen13) {
                maxLen13 = right - left13 + 1;
                startIndex13 = left13;
            }

            right13++;
        }

        String longest = s13.substring(startIndex13, startIndex13 + maxLen13);
        System.out.println(longest);   // OUTPUT: abc
//        ================================================================================================================
        System.out.println("14. Count number of words in a string");
        String s14 = "India is my country"; // OUTPUT: 4
        long count14 = Arrays.stream(s14.trim().split(" ")).count();

        System.out.println(count14);
//        ================================================================================================================
        System.out.println("15. Check if one string is a subsequence of another");
        String a15 = "abc";
        String b15 = "axbyc"; // OUTPUT: true
        //Two pointer apporach best
        int i = 0, j = 0;

        while (i < a15.length() && j < b15.length()) {
            if (a15.charAt(i) == b15.charAt(j)) {
                i++;
            }
            j++;
        }

        boolean result = (i == a15.length());
        System.out.println(result); // true
//        ================================================================================================================
        System.out.println("16. Find all permutations of a string");
        String s16 = "abc"; // OUTPUT: abc, acb, bac, bca, cab, cba
        permute("", s16);
//        ================================================================================================================
        System.out.println("17. Implement custom atoi() -> convert string to integer");
        String s17 = "1234"; // OUTPUT: 1234
//        ================================================================================================================
        System.out.println("18. Remove all whitespaces from a string");
        String s18 = "a b  c d"; // OUTPUT: "abcd"
        String result18 = s18.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(result18);  // abcd

//        ================================================================================================================
//        System.out.println("19. Find longest palindromic substring");
//        String s19 = "babad"; // OUTPUT: "bab" OR "aba"
//        ================================================================================================================
        System.out.println("20. Check if a string contains only digits");
        String s20 = "123456"; // OUTPUT: true
        boolean isDigitOnly = s20.chars().allMatch(Character::isDigit);
        System.out.println(isDigitOnly);
//        ================================================================================================================
        System.out.println("21. Capitalize the first letter of each word");
        String s21 = "welcome to india"; // OUTPUT: "Welcome To India"

        String result21 = Arrays.stream(s21.split(" "))
                .map(w -> Character.toUpperCase(w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(result21);

//        ================================================================================================================
        System.out.println("22. Find duplicate words in a sentence");
        String s22 = "big black bug bit a big black dog"; // OUTPUT: big, black

        List<String> duplicates22 = Arrays.stream(s22.split("\\s+"))
                .map(String::toLowerCase)               // optional: ignore case
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)          // keep only duplicates
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicates22);
//        ================================================================================================================
        System.out.println("23. Check if a string contains any special characters");
        String s23 = "Hello@123"; // OUTPUT: true
        boolean hasSpecialChar = s23.chars()
                .anyMatch(ch -> !Character.isLetterOrDigit(ch));

        System.out.println(hasSpecialChar);
//        ================================================================================================================
        System.out.println("24. Count frequency of each word in a sentence");
        String s24 = "cat dog cat rat dog"; // OUTPUT: {cat=2, dog=2, rat=1}
        Map<String, Long> freq =
                Arrays.stream(s24.split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(freq);

//        ================================================================================================================
        System.out.println("25. Replace all occurrences of a character without using replace()");
        String s25 = "banana"; // replace 'a'->'x' OUTPUT: "bxnxnx"

        char target = 'a';
        char replacement = 'x';

        String result25 = s25.chars()
                .mapToObj(c -> c == target ? String.valueOf(replacement) : String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(result25);
//        ================================================================================================================
        System.out.println("26. Check if two strings are equal without using equals()");
        String s26a = "hello";
        String s26b = "hello"; // OUTPUT: true
        boolean result26 = (s26a.compareTo(s26b) == 0);
        System.out.println(result26);
//        ================================================================================================================
        System.out.println("27. Sort characters of a string in ascending/descending order");
        String s27 = "dcba"; // OUTPUT ASC: "abcd", DESC: "dcba"

        char[] arr27 = s27.toCharArray();
        Arrays.sort(arr27);

        String asc27 = new String(arr27);
        System.out.println(asc27);


        char[] arr272 = s27.toCharArray();
        Arrays.sort(arr272);

        // reverse after sorting
        String desc27 = new StringBuilder(new String(arr272)).reverse().toString();
        System.out.println(desc27);  // dcba

//        ================================================================================================================
        System.out.println("28. Find the second most frequent character");
        String s28 = "success"; // OUTPUT: 'c'
        Character secondMostFreq = s28.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet()
                .stream()
                .sorted((e1,e2)-> Long.compare(e2.getValue(), e1.getValue()))
                .skip(1)
                .map(e->e.getKey())
                .findFirst().orElse(null);
        System.out.println(secondMostFreq);
//        ================================================================================================================
        System.out.println("29. Remove adjacent duplicate characters (aaabb → ab)");
        String s29 = "aaabbccaaa"; // OUTPUT: "abca"

        String s29rest = s29.chars().mapToObj(e->(char)e).distinct().map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(s29rest); //wrong (its remove duplicates)

        StringBuilder sb29 = new StringBuilder();
        char prev = 0;
        for (char c: s29.toCharArray()){
            if (c != prev){
                sb29.append(c);
                prev = c;
            }
        }
        System.out.println(sb29);
//        ================================================================================================================
        System.out.println("30. Check if a string is a valid palindrome (ignore case + spaces)");
        String s30 = "A man a plan a canal Panama"; // OUTPUT: true
        String clean = s30.replace(" ","").toLowerCase();
        StringBuilder cleanReverse = new StringBuilder(clean).reverse();
        System.out.println(clean);
        System.out.println(cleanReverse);
        System.out.println(clean.equals(cleanReverse.toString()));
//        ================================================================================================================
        System.out.println("31. Longest common prefix among a list of strings");
        String[] s31 = {"flower", "flow", "flight"}; // OUTPUT: "fl"
//        ================================================================================================================
        System.out.println("32. Count uppercase, lowercase, digits, and special characters");
        String s32 = "Abc123@#"; // OUTPUT: upper=1, lower=2, digits=3, special=2
//        ================================================================================================================
        System.out.println("33. Check if string is valid email format");
        String s33 = "test@example.com"; // OUTPUT: true
//        ================================================================================================================
        System.out.println("34. Implement a custom split() method");
        String s34 = "a,b,c,d"; // Split by ',' OUTPUT: [a, b, c, d]
//        ================================================================================================================
        System.out.println("35. Find lexicographically smallest & largest substring");
        String s35 = "welcometojava"; // k=3 smallest="ava", largest="wel"

//        ================================================================================================================
        //        // COMMON STRINGS
//        String s1 = "Programming123@2025";
//        String s2 = "Java is easy and Java is powerful";
//        String s3 = "aaabbccddeeeffgghh";
//        String s4 = "racecarannakayakleveltest";
//        String s5 = "listen", s6 = "silent";
//        String s7 = "abcdef", s8 = "defabc";
//        String[] prefixArr = {"flower", "flow", "flight"};
//
//        // 1
//        System.out.println("1. Count occurrence of each character");
//        String input1 = "Programming";
//        // OUTPUT: {r=2, g=2, m=2, P=1, o=1, a=1, i=1, n=1}
//
//        // 2
//        System.out.println("2. Reverse a string");
//        String input2 = "hello";
//        // OUTPUT: "olleh"
//
//        // 3
//        System.out.println("3. Check if two strings are anagrams");
//        String a1 = "listen", a2 = "silent";
//        // OUTPUT: true
//
//        // 4
//        System.out.println("4. First non-repeated character");
//        String input4 = "swiss";
//        // OUTPUT: 'w'
//
//        // 5
//        System.out.println("5. First repeated character");
//        String input5 = "abca";
//        // OUTPUT: 'a'
//
//        // 6
//        System.out.println("6. Check if string is palindrome");
//        String input6 = "racecar";
//        // OUTPUT: true
//
//        // 7
//        System.out.println("7. Remove duplicate characters");
//        String input7 = "programming";
//        // OUTPUT: "progamin"
//
//        // 8
//        System.out.println("8. Count vowels and consonants");
//        String input8 = "hello";
//        // OUTPUT: vowels=2, consonants=3
//
//        // 9
//        System.out.println("9. Check string rotation");
//        // s7 = "abcdef", s8 = "defabc"
//        // OUTPUT: true
//
//        // 10
//        System.out.println("10. Max occurring character");
//        String input10 = "aaabbccccdd";
//        // OUTPUT: 'c'
//
//        // 11
//        System.out.println("11. Reverse each word");
//        String input11 = "Java Is Fun";
//        // OUTPUT: "avaJ sI nuF"
//
//        // 12
//        System.out.println("12. Reverse word order");
//        String input12 = "Java is awesome";
//        // OUTPUT: "awesome is Java"
//
//        // 13
//        System.out.println("13. Longest substring without repeating characters");
//        String input13 = "abcabcbb";
//        // OUTPUT: "abc"
//
//        // 14
//        System.out.println("14. Count words in sentence");
//        String input14 = s2;  // "Java is easy and Java is powerful"
//        // OUTPUT: 7 words
//
//        // 15
//        System.out.println("15. Check if string is subsequence");
//        String big = "abcdefg", small = "ace";
//        // OUTPUT: true
//
//        // 16
//        System.out.println("16. Print all permutations of string");
//        String input16 = "ABC";
//        // OUTPUT: ABC, ACB, BAC, BCA, CAB, CBA
//
//        // 17
//        System.out.println("17. Convert string to integer (atoi)");
//        String input17 = "12345";
//        // OUTPUT: 12345
//
//        // 18
//        System.out.println("18. Remove all whitespaces");
//        String input18 = "  Java   Code  ";
//        // OUTPUT: "JavaCode"
//
//        // 19
//        System.out.println("19. Longest palindromic substring");
//        String input19 = "babad";
//        // OUTPUT: "bab" or "aba"
//
//        // 20
//        System.out.println("20. Check if string contains only digits");
//        String input20 = "12345";
//        // OUTPUT: true
//
//        // 21
//        System.out.println("21. Capitalize first letter of each word");
//        String input21 = "java is easy";
//        // OUTPUT: "Java Is Easy"
//
//        // 22
//        System.out.println("22. Find duplicate words");
//        String input22 = s2;  // "Java is easy and Java is powerful"
//        // OUTPUT: "Java"
//
//        // 23
//        System.out.println("23. Check if string contains special characters");
//        String input23 = "Hello@2025";
//        // OUTPUT: true
//
//        // 24
//        System.out.println("24. Frequency of each word");
//        String input24 = s2;
//        // OUTPUT: {Java=2, is=2, easy=1, and=1, powerful=1}
//
//        // 25
//        System.out.println("25. Replace all occurrences of a character");
//        String input25 = "banana";
//        // OUTPUT: "ban*na" (replace 'a' → '*')
//
//        // 26
//        System.out.println("26. Remove adjacent duplicates");
//        String input26 = "aabbccdd";
//        // OUTPUT: "abcd"
//
//        // 27
//        System.out.println("27. Check valid email format");
//        String input27 = "test@example.com";
//        // OUTPUT: true
//
//        // 28
//        System.out.println("28. Sort characters in a string");
//        String input28 = "program";
//        // OUTPUT: "agmorpr"
//
//        // 29
//        System.out.println("29. Count uppercase, lowercase, digits, special chars");
//        String input29 = s1;  // "Programming123@2025"
//        // OUTPUT: upper=1, lower=10, digits=7, special=1
//
//        // 30
//        System.out.println("30. Find lexicographically smallest & largest substring (size k=3)");
//        String input30 = "welcometojava";
//        // OUTPUT: smallest="ava", largest="wel"
//
//        // 31
//        System.out.println("31. Compare two strings without equals()");
//        String str31a = "hello", str31b = "hello";
//        // OUTPUT: true
//
//        // 32
//        System.out.println("32. Check if two strings have same set of characters");
//        String str32a = "abc", str32b = "bca";
//        // OUTPUT: true
//
//        // 33
//        System.out.println("33. Find longest word in a sentence");
//        String input33 = s2;
//        // OUTPUT: "powerful"
//
//        // 34
//        System.out.println("34. Find missing character from alphabet");
//        String input34 = "thequickbrownfxjmpsvlazydg";
//        // OUTPUT: 'o' missing
//
//        // 35
//        System.out.println("35. Find common characters between two strings");
//        String c1 = "programming", c2 = "gaming";
//        // OUTPUT: g, a, m, i, n
//##############################################################################################
    }
    public static void permute(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);

            String newPrefix = prefix + ch;

            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            permute(newPrefix, newRemaining);
        }
    }
}
