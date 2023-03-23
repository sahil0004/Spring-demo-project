package com.example.subject.bean;

import java.util.Scanner;

public class Regex {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String pattern = "^(4(?!04)[0-9][0-9])$";

        if (input.matches(pattern)) {
            System.out.println("The input is between 400 and 500 but not 404");
        } else {
            System.out.println("The input is not between 400 and 500 or it is 404");
        }
//        String pattern = "^5[0-9]{2}$";
//
//        if (input.matches(pattern)) {
//            System.out.println("The input starts between 500 to 599 and is followed by other digits");
//        } else {
//            System.out.println("The input does not start with 500 to 599");
//        }

    }
}
