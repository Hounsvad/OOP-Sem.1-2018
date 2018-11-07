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
        // Missing questions and answers.
        questions.addAll(Arrays.asList(
                new Question("Question 1", 1, "True", "False", "False", "False", "False"),
                new Question("Question 2", 3, "False", "False", "True", "False"),
                new Question("Question 3", 4, "False", "False", "False", "True", "False", "False", "False", "False"),
                new Question("Question 4", 1, "True", "False", "False", "False", "False"),
                new Question("Question 5", 2, "False", "True", "False")
        ));
    }

    /**
     * Starts the quiz and prompts the user to answer all questions.
     *
     * @return the number of correct answers.
     */
    public int start() {
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

        return correctAnswers;
    }
}
