package com.guvi.gitproject;

import java.util.Scanner;

public class CheckEven {

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number");
        num = sc.nextInt();
        if (num % 2 == 0)
            System.out.println("It is an Even number");
        else
            System.out.println("It is an Odd number");
            sc.close();
    }
}
