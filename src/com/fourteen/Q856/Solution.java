package com.fourteen.Q856;

import java.util.Stack;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/10/9 13:10
 */
public class Solution {
    public static void main(String[] args) {

//        {
//                "20221231": "20221231",
//                "20230101": "20230101",
//                "20230102": "20230102",
//                "20230121": "20230121",
//                "20230122": "20230122",
//                "20230123": "20230123",
//                "20230124": "20230124",
//                "20230125": "20230125",
//                "20230126": "20230126",
//                "20230127": "20230127",
//                "20230405": "20230405",
//                "20230501": "20230501",
//                "20230502": "20230502",
//                "20230503": "20230503",
//                "20230504": "20230504",
//                "20230505": "20230505",
//                "20230622": "20230622",
//                "20230623": "20230623",
//                "20230624": "20230624",
//                "20230929": "20230929",
//                "20230930": "20230930",
//                "20231001": "20231001",
//                "20231002": "20231002",
//                "20231003": "20231003",
//                "20231004": "20231004",
//                "20231005": "20231005",
//                "20231006": "20231006"
//        }
        String s = "(()(()))";
        System.out.println(new Solution().scoreOfParentheses(s));
    }

    public int scoreOfParentheses(String s) {
        int result = 0;
        Stack<String> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar) {
                stack.push(String.valueOf(aChar));
            } else {
                if (!stack.empty()) {
                    if ("(".equals(stack.peek())) {
                        stack.pop();
                        stack.push("1");
                    } else {
                        String pop = stack.pop();
                        if (!stack.empty() && "(".equals(stack.peek())) {
                            stack.pop();
                            stack.push(String.valueOf(Integer.valueOf(pop) * 2));
                        } else if (!stack.empty() && !"(".equals(stack.peek())) {
                            String pop1 = stack.pop();
                            stack.push(String.valueOf(Integer.valueOf(pop) + Integer.valueOf(pop1)));
                        }else{
                            stack.push(pop);
                        }
                    }
                }

                if (!stack.empty() && !"(".equals(stack.peek())) {
                    String pop = stack.pop();
                    if (!stack.empty() && !"(".equals(stack.peek())) {
                        String pop1 = stack.pop();
                        stack.push(String.valueOf(Integer.valueOf(pop) + Integer.valueOf(pop1)));
                    } else {
                        stack.push(pop);
                    }
                }
            }
        }

        if (stack.size() == 1) {
            result = Integer.valueOf(stack.peek());
        } else {

        }
        return result;
    }
}
