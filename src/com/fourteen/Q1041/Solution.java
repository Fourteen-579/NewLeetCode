package com.fourteen.Q1041;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/11 15:23
 */
public class Solution {
    public static void main(String[] args) {
        String text = "GL";
        System.out.println(new Solution().isRobotBounded(text));
    }

    public boolean isRobotBounded(String instructions) {

        int[] position = new int[]{0, 0, 0};

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                switch (c) {
                    case 'G':
                        switch (position[2]) {
                            case 0:
                                position[1]++;
                                break;
                            case 1:
                                position[0]++;
                                break;
                            case 2:
                                position[1]--;
                                break;
                            case 3:
                                position[0]--;
                                break;
                        }
                        break;
                    case 'L':
                        position[2] = position[2] == 0 ? 3 : position[2] - 1;
                        break;
                    case 'R':
                        position[2] = position[2] == 3 ? 0 : position[2] + 1;
                        break;
                }
            }
        }

        return position[0] == 0 && position[1] == 0 && position[2] == 0;
    }
}
