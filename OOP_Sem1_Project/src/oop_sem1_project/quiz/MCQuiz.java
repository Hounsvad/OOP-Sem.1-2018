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
import oop_sem1_project.ClearShell;

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
                new Question(
                        "In case of fire, what do you do?",
                        2,
                        "Find the closest water tap and fill a bucket.",
                        "Find a fire extinguisher.",
                        "Blow as hard as you can and hope for the best.",
                        "Go the rally point and hope someone else is capable of putting out the fire."
                ),
                new Question(
                        "Who do you contact when an emergency occurs?",
                        4,
                        "65 50 88 88 then 112.",
                        "Only 65 50 88 88.",
                        "Only 112.",
                        "112 then 65 50 88 88.",
                        "Nobody."
                ),
                new Question("Which item should you look for if someone has been sprayed in the eyes with chemicals?",
                        3,
                        "A phone.",
                        "First aid kit.",
                        "Eyewash.",
                        "Fire-extinguisher.",
                        "Water fountain.",
                        "None of the above."
                ),
                new Question(
                        "A student is experiencing life-threatening cardiac dysrhythmias! What do you do?",
                        5,
                        "Run for your life. It is highly contagious!",
                        "Nothing. It is only a temporary affair.",
                        "Get the fire extinguisher.",
                        "Call 112 immediately.",
                        "Quickly retrieve the defibrillator while someone else performs CPR."
                ),
                new Question(
                        "Blood is pouring out of a students arm and requires immediate attention. What do you do?",
                        1,
                        "Get the first aid kit.",
                        "Pass out because blood is not your thing…",
                        "Look the other way and hope the student figures something out.",
                        "Clean up the blood. Someone could slip and fall."
                )
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
            ClearShell.clear();
            questionIndex++;
        } while (questionIndex < this.questions.size());

        System.out.println("You answered " + correctAnswers + " questions correctly out of " + this.questions.size() + " possible.");

        return correctAnswers;
    }
}
