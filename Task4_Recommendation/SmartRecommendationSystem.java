import java.util.*;

public class SmartRecommendationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SMART RECOMMENDATION SYSTEM =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your main skill (java/python/web/ml): ");
        String skill = sc.nextLine().toLowerCase();

        System.out.print("Enter your interest (backend/frontend/ai): ");
        String interest = sc.nextLine().toLowerCase();

        System.out.println("\nHello " + name + "! Based on your inputs:");

        System.out.println("\n===== RECOMMENDATIONS =====");

        if (skill.equals("java") && interest.equals("backend")) {

            System.out.println("Career Path: Java Backend Developer");
            System.out.println("Suggested Tech: Spring Boot, REST APIs, MySQL");
            System.out.println("Mini Project: Online Banking System");

        } else if (skill.equals("web") && interest.equals("frontend")) {

            System.out.println("Career Path: Frontend Developer");
            System.out.println("Suggested Tech: HTML, CSS, JavaScript, React");
            System.out.println("Mini Project: Portfolio Website");

        } else if (skill.equals("python") && interest.equals("ai")) {

            System.out.println("Career Path: AI / ML Engineer");
            System.out.println("Suggested Tech: Python, Pandas, ML Models");
            System.out.println("Mini Project: Disease Prediction System");

        } else {

            System.out.println("Career Path: Full Stack Developer");
            System.out.println("Suggested Tech: Java + Web + Databases");
            System.out.println("Mini Project: Student Management System");
        }

        System.out.println("\n===== TASK 4 COMPLETED =====");

        sc.close();
    }
}
