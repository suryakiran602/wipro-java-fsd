package com.wipro.task;

import java.util.Arrays;

public class DailyTasks {

    // String Concatenation
    public String doStringConcat(String s1, String s2) {
        return s1 + " " + s2;
    }

    // Sort Array
    public int[] sortValues(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // Check Presence
    public boolean checkPresence(String str, String word) {
        return str.contains(word);
    }
}
