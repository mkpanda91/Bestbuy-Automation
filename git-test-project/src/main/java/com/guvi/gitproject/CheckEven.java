package com.guvi.gitproject;

import java.util.Scanner;

public class CheckEven {

    public static void main(String[] args) {
        //Declaring the variable to store the number entered by user
        int int_num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number");
        int_num = sc.nextInt();
        if (int_num % 2 == 0)
            System.out.println("It is an Even number");
        else
            System.out.println("It is an Odd number");
            sc.close();
    }
}
