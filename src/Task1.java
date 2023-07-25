import java.util.*;

public class Task1 {

    public static List<List<Integer>> calculateOverlappingIntervals(List<List<Integer>> intervals) {

        List<List<Integer>> resultArrays = new ArrayList<>();
        int currentIndex = 0;

        // Go through interval pairs
        for (List<Integer> pair: intervals) {
            // Start comparing to the rest of interval pairs
            for (int i = currentIndex + 1; i < intervals.size(); i++) {
                // Get the next pair from intervals to compare to
                List<Integer> pairToCheck = intervals.get(i);
                // Go through the values of the main pair
                for (int j = pair.get(0); j <= pair.get(1); j++) {
                    // Check if any value from the initial pair is between values from the pair used for comparison
                    if (pairToCheck.get(0) <= j && j <= pairToCheck.get(1)) {
                        // Join all array values to find min/max
                        int[] joinedArrays = {pair.get(0), pair.get(1), pairToCheck.get(0), pairToCheck.get(1)};
                        int[] result = {Arrays.stream(joinedArrays).min().getAsInt(),
                                Arrays.stream(joinedArrays).max().getAsInt()};
                        resultArrays.add(Arrays.asList(result[0], result[1]));
                        // Print when intervals overlap
                        System.out.println("Overlapping: " + "{" + pair.get(0) + "," + pair.get(1) + "} and " +
                                "{" + pairToCheck.get(0) + ", " + pairToCheck.get(1) + "}" +
                                " Merged: " + "{" + result[0] + ", " + result[1] + "}");
                    }
                }
            }
            currentIndex++;
        }
        resultArrays.sort(Comparator.comparingInt(arr -> arr.get(0)));

        resultArrays.forEach(ints -> System.out.println("{" + ints.get(0) + ", " + ints.get(1) + "}"));
        return resultArrays;
    }
}
