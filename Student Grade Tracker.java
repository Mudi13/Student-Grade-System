import java.util.ArrayList;
import java.util.Scanner;

class Grade {
    String subject;
    double score;

    Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }
}

class StudentGrades {
    private ArrayList<Grade> grades;

    public StudentGrades() {
        grades = new ArrayList<>();
    }

    public void addGrade(String subject, double score) {
        grades.add(new Grade(subject, score));
        System.out.println("Grade added successfully.");
    }

    public void editGrade(String subject, double newScore) {
        for (Grade grade : grades) {
            if (grade.subject.equals(subject)) {
                grade.score = newScore;
                System.out.println("Grade updated successfully.");
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    public void deleteGrade(String subject) {
        for (Grade grade : grades) {
            if (grade.subject.equals(subject)) {
                grades.remove(grade);
                System.out.println("Grade deleted successfully.");
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            System.out.println("No grades available to calculate the average.");
            return 0;
        }
        double total = 0;
        for (Grade grade : grades) {
            total += grade.score;
        }
        return total / grades.size();
    }

    public String getLetterGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public double calculateGPA(double average) {
        if (average >= 90) return 4.0;
        if (average >= 80) return 3.0;
        if (average >= 70) return 2.0;
        if (average >= 60) return 1.0;
        return 0.0;
    }

    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades to display.");
            return;
        }
        System.out.println("Grades:");
        for (Grade grade : grades) {
            System.out.println("Subject: " + grade.subject + ", Score: " + grade.score);
        }
        double average = calculateAverage();
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f\n", calculateGPA(average));
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGrades studentGrades = new StudentGrades();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Grade Tracker Menu ---");
            System.out.println("1. Add Grade");
            System.out.println("2. Edit Grade");
            System.out.println("3. Delete Grade");
            System.out.println("4. Display Grades");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter score: ");
                    double score = scanner.nextDouble();
                    studentGrades.addGrade(subject, score);
                    break;
                case 2:
                    System.out.print("Enter subject to edit: ");
                    subject = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    score = scanner.nextDouble();
                    studentGrades.editGrade(subject, score);
                    break;
                case 3:
                    System.out.print("Enter subject to delete: ");
                    subject = scanner.nextLine();
                    studentGrades.deleteGrade(subject);
                    break;
                case 4:
                    studentGrades.displayGrades();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting Grade Tracker. Goodbye!");
    }
}
