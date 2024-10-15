import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QuizApplication {

    static class Question {
        private String questionText;
        private String[] options;
        private String answer;

        public Question(String questionText, String[] options, String answer) {
            this.questionText = questionText;
            this.options = options;
            this.answer = answer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(String answer) {
            return Objects.equals(this.answer, answer);
        }
    }

    static class Quiz {
        private List<Question> questions;

        public Quiz() {
            questions = new ArrayList<>();
        }

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public List<Question> getQuestions() {
            return questions;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("What is the capital of France?",
                new String[]{"A) Paris", "B) London", "C) Berlin", "D) Madrid"}, "A"));
        quiz.addQuestion(new Question("What is 2 + 2?",
                new String[]{"A) 3", "B) 4", "C) 5", "D) 6"}, "B"));

        int score = 0;

        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + question.getOptions()[0]);
            }
            System.out.println();
        }

        System.out.println("Your score: " + score + "/" + quiz.getQuestions().size());
        scanner.close();
    }
}
