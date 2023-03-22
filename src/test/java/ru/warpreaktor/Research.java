package ru.warpreaktor;

import java.util.Scanner;

class Research {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        while (console.hasNextInt()) {
            int tmp = console.nextInt();
            if (tmp < min) {
                secondMin = min;
                min = tmp;
            } else if (tmp > min && tmp != secondMin) {
                secondMin = tmp;
            }
        }

        System.out.println(secondMin);
    }
}