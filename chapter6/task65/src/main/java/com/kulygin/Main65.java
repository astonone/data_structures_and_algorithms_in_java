package com.kulygin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main65 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter group size (n): ");
        int n = Integer.parseInt(reader.readLine());
        System.out.print("Enter team size (k): ");
        int k = Integer.parseInt(reader.readLine());

        showTeams(n, k, "");
    }

    public static void showTeams(int n, int k, String sequence) {
        if (k == 0) {
            System.out.println(new StringBuilder(sequence).reverse().toString());
            return;
        }
        if (n < k) {
            return;
        }
        showTeams(n - 1, k - 1, sequence + getTeamNameByNumber(n));
        showTeams(n - 1, k, sequence);
    }

    public static String getTeamNameByNumber(int teamNumber) {
        return String.valueOf((char) (teamNumber + 64));
    }
}
