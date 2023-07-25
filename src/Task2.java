import java.util.Arrays;
import java.util.Comparator;

public class Task2 {
    public static int highestOverallAbility(int[] experience, int[] abilities) {

        Employee[] employees = new Employee[experience.length];

        // Create an array of Employee objects with experience and abilities
            for (int i = 0; i < experience.length; i++) {
            employees[i] = new Employee(experience[i], abilities[i]);
        }

        // Sort the employees based on their experience ascending order
        Arrays.sort(employees, Comparator.comparingInt(a -> a.experience));
        // Use dynamic programming to find the highest overall abilitySums
        int[] abilitySums = new int[experience.length];
        // Iterate over all employees
        for (int i = 0; i < experience.length; i++) {
            // Set the current employees ability as max
            abilitySums[i] = employees[i].ability;
            // Compare to all previous employees
            for (int j = 0; j < i; j++) {
                // Check if the current employee's ability is higher than previous ones
                if (employees[i].ability >= employees[j].ability) {
                    // Update the array with a new max value
                    abilitySums[i] = Math.max(abilitySums[i], abilitySums[j] + employees[i].ability);
                }
            }
        }
        // Find the maximum value in abilitySums array
        int maxAbility = 0;
        maxAbility = Arrays.stream(abilitySums).max().getAsInt();
        System.out.println("Highest overall ability sum of P44 team: " + maxAbility);
        return maxAbility;
    }
}

class Employee {

    int experience;
    int ability;

    public Employee(int experience, int ability) {
        this.experience = experience;
        this.ability = ability;
    }
}