import java.util.Scanner;

class MarksCalculator {
    Scanner scanner = new Scanner(System.in);
    String name;
    int rollno;
    int numSubjects;
    int[] marks;
    String[] subjects;

    public MarksCalculator() {
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter your roll no: ");
        rollno = scanner.nextInt();
        System.out.print("Enter the number of subjects: ");
        numSubjects = scanner.nextInt();

        marks = new int[numSubjects];
        subjects = new String[numSubjects];

        scanner.nextLine(); 

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); 
        }
    }

    public String calculate() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        int percentage = total / numSubjects;
        String grade;
        if (percentage > 86) {
            grade = "A+";
        } else if (percentage > 78) {
            grade = "B+";
        } else if (percentage > 45) {
            grade = "C+";
        } else {
            grade = "Fail";
        }
        return String.format("%d,%d,%s", total, percentage, grade);
    }

    public void displayMarks() {
        System.out.println("\n------------------ Marks Obtained ------------------");
        System.out.printf(" %-20s | %-6s \n", "Subject", "Marks");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf(" %-20s | %-6d \n", subjects[i], marks[i]);
        }
        System.out.println("----------------------------------------------------");
    }
}

public class MarksGenerator {
    public static void main(String[] args) {
        MarksCalculator marksCalculator = new MarksCalculator();
        
        String[] results = marksCalculator.calculate().split(",");
        int total = Integer.parseInt(results[0]);
        int percentage = Integer.parseInt(results[1]);
        String grade = results[2];

        marksCalculator.displayMarks();

        System.out.println("\n----------------- Final Report -----------------");
        System.out.printf(" Roll No: %-10d Name: %s \n", marksCalculator.rollno, marksCalculator.name);
        System.out.println("-----------------------------------------------");
        System.out.printf(" Total Marks: %-10d Percentage: %d%% \n", total, percentage);
        System.out.printf(" Grade: %s \n", grade);
        System.out.println("-----------------------------------------------");
    }
}
