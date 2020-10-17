package com.guo.practice.codepractice.problems.other;

/*Lucky number calculater(just calculates the sum of digits of the given date*/

import java.io.*;

class Digitsum {

    public static void main(String arg[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the date(ddmmyy):");
        int number = Integer.parseInt(br.readLine());


        int sum = 0;
        int currentNumber = number;

        sum = sumOfDigit(currentNumber, sum);


        System.out.println("Your lucky number is:" + sum);
// System.out.println(sum);

    }//main

    public static int sumOfDigit(int currentNumber, int sum) {

        int newNumber = (int) Math.floor(currentNumber / 10);
        int lastDigit = currentNumber / 10;

        sum = sum + lastDigit;

        if (newNumber >= 10) {
            return sumOfDigit(newNumber, sum);
        } else {
            if (sum >= 10) {
                return sumOfDigit(sum, 0);
            } else {
                return sum;
            }
        }
    }

    ;


}






