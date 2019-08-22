/**
 *  Find missing number at int array
 *  F.e. {1,2,4,5} has a hole in between positions 1 and 2.
 *
 *  Binary search used here O(log N)
 *
 *  Aug 2019 EvgenyT
 */

public class MissingNumber {

    // Check for hole existence at int array
    static boolean checkSubArray(int[] intArray, int startIdx, int endIdx) {
        return intArray[endIdx] - intArray[startIdx] == endIdx - startIdx;
    }

    // Run point
    public static void main(String[] args) {
        final int[] intArray = {1, 2, 3, 5};
        // While array has a hole, divide it by halves and check
        // in what half that hole is
        int startIdx = 0;
        int endIdx = intArray.length - 1;
        while (!checkSubArray(intArray, startIdx, endIdx)) {
            System.out.println("Range " + startIdx + " - " + endIdx + " has a hole");
            if (endIdx - startIdx == 1) {
                // We find exact location of hole
                System.out.println("Hole between " + startIdx + " and " + endIdx);
                return;
            }
            int midIx  = (endIdx - startIdx + 1) / 2;
            if (checkSubArray(intArray, startIdx, midIx))
                startIdx = midIx; // hole to the right half
            else
                endIdx = midIx; // hole in the left half
        }
        System.out.println("No holes");
    }
}
