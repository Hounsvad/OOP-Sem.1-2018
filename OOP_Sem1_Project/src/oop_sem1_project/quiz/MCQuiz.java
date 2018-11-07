/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class MCQuiz {

    /**
     * A List containing all questions.
     */
    private final List<Question> questions = new ArrayList<>();

    /**
     * No-args constructor populating the above List with pre-defined questions.
     */
    public MCQuiz() {
        questions.addAll(Arrays.asList(
                new Question("Test (1)", 1, "Den", "Ikke den", "Ikke den", "Ikke Den", "Ikke den næ"),
                new Question("Test (3)", 3, "Nææ", "Ikke den", "den", "Ikke Den"),
                new Question("Test (4)", 4, "Ikke den", "Ikke den", "Ikke den", "Den", "ikke den", "heller ikke den"),
                new Question("Test (1)", 1, "Den", "Ikke den", "Ikke den", "Ikke Den", "Ikke den næ", "Næ!"),
                new Question("Test (2)", 2, "ikke Den", "den", "Ikke den")
        ));
    }

    /**
     * Starts the quiz and prompts the user to answer all questions.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int questionIndex, correctAnswers;
        questionIndex = correctAnswers = 0;

        do {
            Question question = this.questions.get(questionIndex);
            question.printQuestion();
            if (question.requestAnswer(scanner)) {
                correctAnswers++;
            }
            questionIndex++;
        } while (questionIndex < this.questions.size());

        System.out.println("You answered " + correctAnswers + " questions correctly out of " + this.questions.size() + " possible.");
    }
}
