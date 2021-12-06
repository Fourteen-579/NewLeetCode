package com.fourteen.Q1816;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/6 9:22
 */
public class Solution {
    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(new Solution().truncateSentence(s,k));
    }

    public String truncateSentence(String s, int k) {
        StringBuffer res = new StringBuffer();
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c ==' '){
                nums++;
            }
            if(nums==k){
                break;
            }
            res.append(c);
        }
        return res.toString();
    }

}
