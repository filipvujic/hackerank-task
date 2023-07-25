public class Main {

    public static void main(String[] args) {

        // Task1
        System.out.println("Task 1 (case a):");
        int[][] intervals1 = {{7, 7}, {2, 3}, {6, 11}, {1, 2}};
        Task1.calculateOverlappingIntervals(intervals1);

        System.out.println("Task 1 (case b):");
        int[][] intervals2 = {{3, 6}, {3, 3}, {1, 2}, {2, 2}};
        Task1.calculateOverlappingIntervals(intervals2);

        System.out.println();

        // Task2
        System.out.println("Task 2 (case a):");
        int[] experience1 = { 2, 4, 1, 3, 5 };
        int[] abilities1 = { 3, 5, 2, 4, 6 };
        Task2.highestOverallAbility(experience1, abilities1);

        System.out.println("Task 2 (case b):");
        int[] experience2 = { 2, 2, 2, 4, 5 };
        int[] abilities2 = { 5, 6, 7, 3, 2 };
        Task2.highestOverallAbility(experience2, abilities2);
    }
}