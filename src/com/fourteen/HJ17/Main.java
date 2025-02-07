package com.fourteen.HJ17;

import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 13:33
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] steps = in.next().split(";");
        int x = 0, y = 0;
        String regix = "^[WASD][1-9][0-9]?$";
        for (String step : steps) {

            if (step.matches(regix)) {
                char direction = step.charAt(0);
                int distance = Integer.parseInt(step.substring(1));
                switch (direction) {
                    case 'A':
                        x -= distance;
                        break;
                    case 'D':
                        x += distance;
                        break;
                    case 'W':
                        y += distance;
                        break;
                    case 'S':
                        y -= distance;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }

}
