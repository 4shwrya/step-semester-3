import java.util.*;

abstract class Question {
    protected String text;
    protected int points;

    Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public abstract boolean evaluate(String answer);

    public int getPoints() {
        return points;
    }

    public String getText() {
        return text;
    }
}

class MCQ extends Question {
    private String correctAnswer;

    MCQ(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private String correctAnswer;

    TrueFalseQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Attempt {
    private Student student;
    private String examName;
    private List<Question> questions;
    private Map<Question, String> answers = new LinkedHashMap<>();
    private boolean submitted = false;

    Attempt(Student student, String examName, List<Question> questions) {
        this.student = student;
        this.examName = examName;
        this.questions = questions;
        System.out.println(examName + " started by " + student.name);
    }

    public void answer(Question q, String answer) {
        if (submitted) {
            System.out.println(
                    "Cannot change answers for a submitted examination.");
            return;
        }

        if (!questions.contains(q)) {
            System.out.println("Question does not belong to this exam.");
            return;
        }

        answers.put(q, answer);
        System.out.println("Answer recorded for " + q.getText());
    }

    public void submit() {
        if (submitted) {
            System.out.println("Exam already submitted.");
            return;
        }

        submitted = true;
        int score = 0;
        int total = 0;

        System.out.println(examName + " submitted by " + student.name);

        for (Question q : questions) {
            total += q.getPoints();
            boolean correct = q.evaluate(answers.getOrDefault(q, ""));

            if (correct) {
                score += q.getPoints();
            }

            System.out.println(q.getText() + ": "
                    + (correct ? "Correct" : "Incorrect")
                    + " (" + (correct ? q.getPoints() : 0)
                    + " points)");
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class OnlineExamMain {
    public static void main(String[] args) {
        Student student = new Student("Student 1");

        Question q1 = new MCQ("Question 1", 5, "C");
        Question q2 = new TrueFalseQuestion("Question 2", 5, "False");

        List<Question> questions = Arrays.asList(q1, q2);
        Attempt attempt = new Attempt(student, "Exam A", questions);

        attempt.answer(q1, "C");
        attempt.answer(q2, "True");
        attempt.submit();
        attempt.answer(q1, "A");
    }
}