import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- INPUT PHASE ---
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int numSubjects = Integer.parseInt(sc.nextLine());

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                int m = Integer.parseInt(sc.nextLine());

                if (m < 0 || m > 100) {
                    System.out.println("  Invalid! Marks must be between 0 and 100. Try again.");
                } else {
                    marks[i] = m;
                    totalMarks += m;
                    break;
                }
            }
        }

        // --- PROCESS PHASE ---
        double average = (double) totalMarks / numSubjects;

        // Grade based on average
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // --- OUTPUT PHASE ---
        System.out.println("\n========================================");
        System.out.println("         STUDENT RESULT REPORT          ");
        System.out.println("========================================");
        System.out.println("Student Name   : " + name);
        System.out.println("Total Subjects : " + numSubjects);
        System.out.println("----------------------------------------");
        System.out.println("Subject        Marks     Status");
        System.out.println("----------------------------------------");

        int passCount = 0;
        int failCount = 0;

        for (int i = 0; i < numSubjects; i++) {
            String subjectStatus;
            if (marks[i] >= 40) {
                subjectStatus = "Pass";
                passCount++;
            } else {
                subjectStatus = "Fail";
                failCount++;
            }
            System.out.printf("Subject %-4d   %3d/100    %s%n", (i + 1), marks[i], subjectStatus);
        }

        // Overall status — if even 1 subject failed = Fail
        String overallStatus;
        if (failCount == 0) {
            overallStatus = "Pass";
        } else {
            overallStatus = "Fail";
        }

        System.out.println("----------------------------------------");
        System.out.println("Subjects Passed : " + passCount + " / " + numSubjects);
        System.out.println("Subjects Failed : " + failCount + " / " + numSubjects);
        System.out.println("----------------------------------------");
        System.out.println("Total Marks    : " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf( "Average        : %.2f%%%n", average);
        System.out.println("Grade          : " + grade);
        System.out.println("Overall Status : " + overallStatus);
        System.out.println("========================================");

        sc.close();
    }
}