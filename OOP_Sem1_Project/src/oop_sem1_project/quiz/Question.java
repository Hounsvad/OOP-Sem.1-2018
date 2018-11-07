/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.quiz;

import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
class Question {

    /**
     * The main question.
     */
    private final String question;

    /**
     * The position/index of the correct answer.
     */
    private final int correctAnswer;

    /**
     * A variable amount of possible answers.
     */
    private final String[] answers;

    /**
     * Construct a new question object. Construction may throw an exception if
     * the answer index is not within the range of the correctAnswer index.
     *
     * @param question The question.
     * @param answers An array of possible answers to the question.
     * @param correctAnswer The index of the correct answer.
     */
    Question(String question, int correctAnswer, String... answers) {
        if (correctAnswer < 1 || correctAnswer > answers.length) {
            throw new IndexOutOfBoundsException("The correct answer is not within the range of the question amount");
        }
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    /**
     * Prints the question neatly to the console/terminal.
     */
    void printQuestion() {
        System.out.println(this.question);
        System.out.println("--------------------------------------");
        for (int i = 0; i < this.answers.length; i++) {
            System.out.println((i + 1) + ". " + this.answers[i]);
        }
    }

    /**
     * Requests the user to input the answer they think is the correct one.
     *
     * @param scanner The scanner to read from.
     * @return True if the answer was correct. False if it wasn't.
     */
    boolean requestAnswer(Scanner scanner) {
        int input = 0;

        while (input < 1 || input > this.answers.length) {
            System.out.print("Please input an answer between 1 and " + this.answers.length + ": ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        return input == correctAnswer;
    }
}
