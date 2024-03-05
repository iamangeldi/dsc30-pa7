/**
 * PA7 Part 1 worksheet (style not required)
 */
public class Worksheet {

    /**
     * method that stores the result of Q1 in PA7 worksheet
     * @return heap's array representation after insertions
     */
    public static int[] insertionResult(){
        int[] output =  new int[]{104, 95, 79, 51, 90, 25, 36, 22, 50, 45, 87, 5};
        return output;
    }

    /**
     * method that stores the result of Q2 in PA7 worksheet
     * @return heap's array representations for each iteration of element removal, 5 iterations in total
     */
    public static int[][] removalResult(){
        int[][] output = new int[5][12];
        // First removal
        output[0] = new int[]{37, 56, 42, 59, 62, 90, 50, 67, 70, 75, 64, 0};

        // Second removal
        output[1] = new int[]{42, 56, 50, 59, 62, 90, 64, 67, 70, 75, 0, 0};

        // Third removal
        output[2] = new int[]{50, 56, 64, 59, 62, 90, 75, 67, 70, 0, 0, 0};

        // Fourth removal
        output[3] = new int[]{56, 59, 64, 67, 62, 90, 75, 70, 0, 0, 0, 0};

        // Fifth removal
        output[4] = new int[]{59, 62, 64, 67, 70, 90, 75, 0, 0, 0, 0, 0};

        return output;
    }

    /**
     * method that stores the result of Q3 in PA7 worksheet
     * @return heap's array representations for d-ary heaps, where d = 3,4
     */
    public static int[][] dResult(){
        /*
        TODO: store 3-ary heap's array representation output[0] and store 4-ary representation in output[1]
         */
        int[][] output = new int[2][11];

        // 3-ary heap array
        output[0] = new int[]{92, 61, 85, 43, 47, 53, 56, 55, 79, 31, 20};

        // 4-ary heap array
        output[1] = new int[]{92, 85, 55, 43, 47, 53, 56, 61, 79, 31, 20};

        return output;
    }

    /**
     * method that stores the result of Q4 in PA7 worksheet
     * @return array representations
     */
    public static int[][] heapOperations(){
        int[][] output = new int[5][12];

        // Removing the top twice
        output[0] = new int[]{71, 65, 70, 59, 55, 36, 37, 26, 35};

        // After inserting 15 and 100
        output[1] = new int[]{100, 71, 70, 59, 65, 36, 37, 26, 35, 15, 55};

        // Removing the top once
        output[2] = new int[]{71, 65, 70, 59, 55, 36, 37, 26, 35, 15};

        // After inserting 72 and 88
        output[3] = new int[]{88, 71, 72, 59, 65, 70, 37, 26, 35, 15, 55, 36};

        // After removing the top 5 times
        output[4] = new int[]{59, 55, 37, 35, 26, 36, 15};

        return output;
    }
}