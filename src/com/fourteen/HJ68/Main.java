package com.fourteen.HJ68;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 16:45
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int lenght = Integer.parseInt(in.nextLine());
        int order = Integer.parseInt(in.nextLine());

        List<Temp> temps = new ArrayList<>();

        for (int i = 0; i < lenght; i++) {
            String text = in.nextLine();
            String[] split = text.split(" ");

            temps.add(new Temp(split[0], Integer.parseInt(split[1])));
        }

        temps.stream()
                .sorted((o1, o2) -> order == 1 ? o1.value - o2.value : o2.value - o1.value)
                .forEach(entry -> System.out.println(entry.getName() + " " + entry.getValue()));
    }

    static class Temp {
        String name;
        int value;

        public Temp(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

}
