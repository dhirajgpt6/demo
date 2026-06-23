//package com.example.demo.solid.o;
//// This is Stratagy design pattern
////The Open/Closed Principle (O).
//// Maan lijiye aapne InvoiceCalculator
//// class banayi hai. Usme ek method hai calculateDiscount(String customerType).
//// Abhi aapke paas do types hain: STUDENT (10% discount) aur SENIOR (20% discount).
//// Aapne code mein if-else ya switch case likha hai. "Agar kal ko mujhe ek naya type 'VIP' (30% discount) add karna hai,
//// toh main bina 'if-else' ko touch kiye ya bina existing class ko modify kiye ye kaise achieve kar sakta hoon? Isme Open/Closed Principle kaise apply hoga?"
//class InvoiceCalculator {
//    public double calculateDiscount(String customerType, double amount) {
//        if (customerType.equals("STUDENT")) {
//            return amount * 0.10;
//        } else if (customerType.equals("SENIOR")) {
//            return amount * 0.20;
//        }
//        return 0;
//    }
//}
//
//public class Main {
//    public static void main(String arg[]){
//        InvoiceCalculator invoiceCalculator = new InvoiceCalculator();
//        DiscountStratagy seniorDiscount = new SeniorDiscount();
//        invoiceCalculator.calculateDiscount(seniorDiscount, 100);
//    }
//}
//
//interface DiscountStratagy {
//    double applyDiscount(double amount);
//}
//
//class StudentDiscount implements DiscountStratagy{
//    @Override
//    public double applyDiscount(double amount){
//        return amount * .10;
//    }
//}
//
//class SeniorDiscount implements DiscountStratagy{
//    @Override
//    public double applyDiscount(double amount){
//        return amount * .20;
//    }
//}
//
//class VipDiscount implements DiscountStratagy{
//    @Override
//    public double applyDiscount(double amount){
//        return amount * .30;
//    }
//}
//
//class InvoiceCalculator {
//    public double calculateDiscount (DiscountStratagy discountStratagy, double amount){
//        return discountStratagy.applyDiscount(amount);
//    }
//}