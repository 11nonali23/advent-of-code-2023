package main;

import questions.Question1;
import questions.Question2;

public class Main {
    public static void main(String[] args) {
        // ### QUESTION 1
        // * part 1
        int part1Result = Question1.getCalibrationValuesSum();
        System.out.println("Q1 - p1 " + part1Result);

        // ### QUESTION 2
        // * part 1
        long question2Result = Question2.getValidGamesCount();
        System.out.println("Q2 - p1 " + question2Result);
    }

}