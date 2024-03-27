package com.guvi.gitproject;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int m = 9, n = 5, temp;
        System.out.println("First Number before Swapping: " + m);
        System.out.println("Second Number before Swapping: " + n);
        temp = m;
        m = n;
        n = temp;
        System.out.println();
        System.out.println("First Number after Swapping: " + m);
        System.out.println("Second Number after Swapping: " + n);

    }
}
