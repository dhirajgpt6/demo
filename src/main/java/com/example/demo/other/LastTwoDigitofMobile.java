package com.example.demo.other;

// Show last 2 digit of mobile number and rest with #
// eg. 0123456789 to ########89
public class LastTwoDigitofMobile {
    public static void main(String[] args) {
        String phone = "0123456789";
        String value = phone.replaceAll(".(?=.{2})", "#");
        System.out.println(value);
    }
}
