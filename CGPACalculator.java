import java.util.Scanner;

public class CGPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of courses
        System.out.print("Enter the number of courses: ");
        int numberOfCourses = scanner.nextInt();

        // Initialize arrays
        String[] courseCodes = new String[numberOfCourses];
        int[] scores = new int[numberOfCourses];
        int[] weightUnits = new int[numberOfCourses];
        double[] gradePoints = new double[numberOfCourses];

        // Input details for each course
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter details for course " + (i + 1) + ":");
            
            System.out.print("Course code (e.g., MTH101): ");
            courseCodes[i] = scanner.next();

            System.out.print("Score (0-100): ");
            scores[i] = validateInput(scanner, 0, 100);

            System.out.print("Weight unit (1-10): ");
            weightUnits[i] = validateInput(scanner, 1, 10);

            // Calculate grade point based on the score
            gradePoints[i] = calculateGradePoint(scores[i]);
        }

        // Calculate CGPA
        double totalWeightedGradePoints = 0;
        int totalWeightUnits = 0;

        for (int i = 0; i < numberOfCourses; i++) {
            totalWeightedGradePoints += gradePoints[i] * weightUnits[i];
            totalWeightUnits += weightUnits[i];
        }

        double cgpa = totalWeightedGradePoints / totalWeightUnits;

        // Display results in a tabular format
        System.out.println("\nCourse Code | Score | Grade | Weight Unit | Grade Point");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.printf("%-12s | %-5d | %-5s | %-11d | %.1f\n", 
                courseCodes[i], scores[i], getGrade(scores[i]), weightUnits[i], gradePoints[i]);
        }
        System.out.printf("\nTotal Weight Units: %d\n", totalWeightUnits);
        System.out.printf("CGPA: %.2f\n", cgpa);

        scanner.close();
    }

    // Method to calculate grade point based on score
    private static double calculateGradePoint(int score) {
        if (score >= 70) return 5.0;
        if (score >= 60) return 4.0;
        if (score >= 50) return 3.0;
        if (score >= 45) return 2.0;
        if (score >= 40) return 1.0;
        return 0.0;
    }

    // Method to get grade based on score
    private static String getGrade(int score) {
        if (score >= 70) return "A";
        if (score >= 60) return "B";
        if (score >= 50) return "C";
        if (score >= 45) return "D";
        if (score >= 40) return "E";
        return "F";
    }

    // Method to validate user input within a range
    private static int validateInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            }
            System.out.printf("Invalid input! Enter a value between %d and %d: ", min, max);
        }
        return input;
    }
}