
public class max_Subarray_Sum {
    // Brute force O(N^3)
    public static void maxSubarraySum(int numbers[]) {
        int currSum = 0;
        int count = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    // print subarray sum
                    currSum += numbers[k];
                    count++;
                }
                System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
        System.out.println("number of time loop run is = " + count);
    }

    //prefix array - jaha par hai vaha se piche tak ka sum.
    //Prefix sum =  means the sum from stating element till the position of the respective element
    // O(N^2)
    public static void maxSubarraySum_usingPrefixArray(int numbers[]) {
        int currSum = 0;
        int count = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // calculate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
// FORMULA TO REMEMBER - prefix[end] - prefix[start - 1] (WITH THE HELP OF THIS FORMULA WE CAN AVOID ONE LOOP)
                currSum = (start == 0 ? prefix[end] : prefix[end] - prefix[start - 1]);
                count++;

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
        System.out.println("number of time loop run is = " + count);
    }

    public static void main(String args[]) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        maxSubarraySum(numbers);
        maxSubarraySum_usingPrefixArray(numbers);
    }
}
