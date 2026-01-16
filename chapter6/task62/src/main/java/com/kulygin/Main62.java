package com.kulygin;

public class Main62 {
    static int width;
    static int height;
    static char[][] buffer;

    public static void main(String[] args) {
        width = 16;
        height = log2(width) + 1;
        buffer = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                buffer[i][j] = '-';
            }
        }
        makeBranches(0, width - 1, 0);
        display();
    }

    public static void makeBranches(int left, int right, int row) {
        if (row == buffer.length) {
            return;
        }
        int center = (left + right) / 2;
        buffer[row][center] = 'X';
        makeBranches(left, center, row + 1);
        makeBranches(center + 1, right, row + 1);
    }

    public static void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(buffer[i][j]);
            }
            System.out.println();
        }
    }

    public static int log2(int N) {
        return (int)(Math.log(N) / Math.log(2));
    }
}
