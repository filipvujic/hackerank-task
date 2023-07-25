import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Task1 {

    public static ArrayList<int[]> calculateOverlappingIntervals(int[][] intervals) {

        ArrayList<int[]> resultArrays = new ArrayList<>();
        int currentIndex = 0;

        // Go through interval pairs
        for (int[] pair: intervals) {
            // Start comparing to the rest of interval pairs
            for (int i = currentIndex + 1; i < intervals.length; i++) {
                // Get the next pair from intervals to compare to
                int[] pairToCheck = intervals[i];
                // Go through the values of the main pair
                for (int j = pair[0]; j <= pair[1]; j++) {
                    // Check if any value from the initial pair is between values from the pair used for comparison
                    if (pairToCheck[0] <= j && j <= pairToCheck[1]) {
                        // Join all array values to find min/max
                        int[] joinedArrays = {pair[0], pair[1], pairToCheck[0], pairToCheck[1]};
                        int[] result = {Arrays.stream(joinedArrays).sorted().min().getAsInt(),
                                Arrays.stream(joinedArrays).sorted().max().getAsInt()};
                        resultArrays.add(result);
                        // Print when intervals overlap
                        System.out.println("Overlapping: " + "{" + pair[0] + "," + pair[1] + "} and " +
                                "{" + pairToCheck[0] + ", " + pairToCheck[1] + "}" +
                                " Merged: " + "{" + result[0] + ", " + result[1] + "}");
                    }
                }
            }
            currentIndex++;
        }
        resultArrays.sort(Comparator.comparingInt(arr -> arr[0]));

        resultArrays.forEach(ints -> System.out.println("{" + ints[0] + ", " + ints[1] + "}"));
        return resultArrays;
    }
}
