package com.fourteen.Q794;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/9 9:31
 */
public class Solution {

    public static void main(String[] args) {
        String[] b = {"XXX", "OXX", "XOO"};
        System.out.println(new Solution().validTicTacToe(b));
    }

    public char[] success(String[] board) {
        char[] c = new char[2];

        int i = 0, j = 0;
        while (i < 3) {
            char c1 = board[i].charAt(j);
            if (c1 != ' ' && c1 == board[i].charAt(j + 1) && c1 == board[i].charAt(j + 2)) {
                if (c1 == 'X') {
                    c[0] = 'X';
                } else if (c1 == 'O') {
                    c[1] = 'O';
                }
            }
            i++;
        }

        i = 0;
        while (j < 3) {
            char c1 = board[i].charAt(j);
            if (c1 != ' ' && c1 == board[i + 1].charAt(j) && c1 == board[i + 2].charAt(j)) {
                if (c1 == 'X') {
                    c[0] = 'X';
                } else if (c1 == 'O') {
                    c[1] = 'O';
                }
            }
            j++;
        }
        i = 0;
        j = 0;
        char c1 = board[i].charAt(j);
        if (board[i].charAt(j) == board[i + 1].charAt(j + 1) && board[i].charAt(j) == board[i + 2].charAt(j + 2)) {
            if (c1 == 'X') {
                c[0] = 'X';
            } else if (c1 == 'O') {
                c[1] = 'O';
            }
        }

        i = 0;
        j = 2;
        c1 = board[i].charAt(j);
        if (c1 == board[i + 1].charAt(j - 1) && c1 == board[i + 2].charAt(j - 2)) {
            if (c1 == 'X') {
                c[0] = 'X';
            } else if (c1 == 'O') {
                c[1] = 'O';
            }
        }
        return c;
    }

    public boolean validTicTacToe(String[] board) {
        boolean res = false;

        int xNum = 0, oNum = 0;

        for (String s : board) {
            for (int i = 0; i < 3; i++) {
                Character c = s.charAt(i);
                if (c == 'X') {
                    xNum++;
                } else if (c == 'O') {
                    oNum++;
                }
            }
        }

        char[] success = success(board);

        if (success[0] == 'X' && success[1] == 'O') {
            res = false;
        } else if (success[0] == 'X' && success[1] != 'O') {
            res = xNum == oNum + 1 ? true : false;
        } else if (success[0] != 'X' && success[1] == 'O') {
            res = xNum == oNum ? true : false;
        } else if (success[0] != 'X' && success[1] != 'O') {
            res = xNum == oNum || xNum == oNum + 1;
        }


        return res;
    }
}
