import java.util.Scanner;
class Message{

    void display(){
        System.out.println("Welcome to Team6 Parking Lot!");
        System.out.println("If you are new user enter 1");
        System.out.println("If you are old user enter your uid");
    
 }

 void display2(){
     System.out.println("enter 1 if you are handicapped");
     System.out.println("else enter 2");
 }
 public void paymentQ1() {
     System.out.println("choose the payment method : ");
     System.out.println("1 - digital ");
     System.out.println("2 - cash ");
 }
 public void currency(){
     System.out.println("Select currency : ");
     System.out.println("1 -  INR ");
     System.out.println("2 -  Canadian Dollar (CAD) (5% EXTRA For conversion) ");
     System.out.println("3 -  U.S. Dollar (USD)(5% EXTRA For conversion) ");
     System.out.println("4 -  Swiss Franc (CHF) (5% EXTRA For conversion)");
     System.out.println("5 -  European Euro (EUR) (5% EXTRA For conversion)");
     System.out.println("6 -  Cayman Islands Dollar (KYD) (5% EXTRA For conversion)");
     System.out.println("7 -  British Pound Sterling (GBP) (5% EXTRA For conversion)");
     System.out.println("8 -  Jordanian Dinar (JOD) (5% EXTRA For conversion)");
     System.out.println("9 -  Omani Rial (OMR) (5% EXTRA For conversion)");
     System.out.println("10 -  Bahraini Dinar (BHD)(5% EXTRA For conversion)");
 }
 // if condition in the main (points > 280)
 public void paymentQ2(){
     System.out.println("do u want to redeem points : ");
     System.out.println("1 - Yes ");
     System.out.println("2 - No ");
 }
 public void prepaymentinfo(){
     System.out.println("estd. amount : ");
 }
 public void postpaymentinfo1(){
     System.out.println("final amount : ");
 }
 public void postpaymentinfo2(){
     System.out.println("please collect your cash  : ");
 }
 public void paymentQ3(){
     System.out.println("input your amount  : ");
 }
 void display3(){
     
     System.out.println("Enter UID : ");
     
     
 }

 void display4(){
    System.out.println("Enter the Hours you stayed : ");
    
 }

 void display5( ){
    System.out.println("Enter 1 -> to add a car ");
    System.out.println("Enter 2 -> to exit a car ");
    System.out.println("Enter -1 -> shutdown ");
 }
 
}

