package matrix;

public class MaxSizeSubMatrix {

    private final int[][] matrix;

    private MaxSizeSubMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {

        int matrix[][] = {{0, 1, 1, 0, 1},
                          {1, 1, 0, 1, 0},
                          {0, 1, 1, 1, 0},
                          {1, 1, 1, 1, 0},
                          {1, 1, 1, 1, 1},
                          {0, 0, 0, 0, 0}};

        MaxSizeSubMatrix maxSizeSubMatrix = new MaxSizeSubMatrix(matrix);

        int maxSize = maxSizeSubMatrix.getMaxSizeSubmatrix();
        maxSizeSubMatrix.print(maxSize);
    }

    private void print(int maxSize) {
        System.out.println(maxSize);
    }

    private int getMaxSizeSubmatrix() {

        int rowsLength = matrix.length;
        int columnsLength = matrix[0].length;
        int[][] maxSizeMatrix = new int[rowsLength][columnsLength];


        for (int i = 0; i < rowsLength; i++) {
            maxSizeMatrix[i][0] = matrix[i][0];
        }
        System.arraycopy(matrix[0], 0, maxSizeMatrix[0], 0, columnsLength);

        for (int i = 1; i < rowsLength; i++) {
            for (int j = 1; j < columnsLength; j++) {
                if (matrix[i][j] == 1)
                    maxSizeMatrix[i][j] = Math.min(Math.min(maxSizeMatrix[i - 1][j], maxSizeMatrix[i][j - 1]), maxSizeMatrix[i - 1][j - 1]) + 1;
                else
                    maxSizeMatrix[i][j] = 0;
            }
        }

        int maxSize = 0;
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                if (maxSizeMatrix[i][j] > maxSize)
                    maxSize = maxSizeMatrix[i][j];
            }
        }
        return maxSize;
//        IntStream.range(0, rowsLength*columnsLength).forEach(i-> {
//
//            int elementValue = maxSizeMatrix[i/columnsLength][i%columnsLength];
//            if(elementValue > maxSize)
//                maxSize = elementValue;
//        });

    }
}
