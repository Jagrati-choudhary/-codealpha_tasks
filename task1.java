import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        // Input student grades
        System.out.println("Enter student grades (Enter -1 to stop):");
        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();

            if (grade == -1) {
                break;  // Stop input when -1 is entered
            }

            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Please enter a value between 0 and 100.");
            } else {
                grades.add(grade);
            }
        }

        // Check if grades are entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculate highest, lowest, and average
            int highest = Collections.max(grades);
            int lowest = Collections.min(grades);
            double average = calculateAverage(grades);

            // Display results
            System.out.println("\n--- Grade Summary ---");
            System.out.println("Total Students: " + grades.size());
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
            System.out.printf("Average Grade: %.2f%n", average);
        }

        scanner.close();
    }

    // Method to calculate average
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}