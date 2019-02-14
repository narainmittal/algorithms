package com.nmittal.problems;

/**
 * MaxPathGrid Description.
 * <p>
 * Given a matrix of positive integers/points.
 * We have to start from lower left corner and reach the upper right corner.
 * Our path should be such that we fetch maximum points.
 * Only two movements are allowed- up and right, i.e. from a cell (R, C), you can either go to (R, C+1) or (R-1, C)
 */
public final class MaxPathGrid {

    static int findMaxPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] calculate = new int[rows][cols];

        // start (rows-1, 0), end (0,cols-1)
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int value = grid[i][j];
                // lower bottom corner
                if (i == rows - 1 && j == 0) {
                    calculate[i][j] = value;
                }
                // bottom row
                else if (i == rows - 1) {
                    calculate[i][j] = calculate[i][j - 1] + value;
                }
                // first column
                else if (j == 0) {
                    calculate[i][j] = calculate[i + 1][j] + value;
                }
                // max of either possible paths
                else {
                    calculate[i][j] = Math.max(calculate[i + 1][j], calculate[i][j - 1]) + value;
                }
            }
        }

        // generate path

        int i=0;
        int j=cols-1;
        while(i!=rows-1 || j!=0){
            System.out.println(String.format("(%s, %s)", i, j));
            if(j == 0){
                i = i+1;
            }else if(i== rows-1){
                j = j-1;
            }else if(calculate[i+1][j] > calculate[i][j-1]){
                i = i+1;
            }else{
                j= j-1;
            }
        }


        return calculate[0][cols-1];
    }

    public static void main(String[] args) {
        int mat[][] = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };

        System.out.println(findMaxPath(mat));
    }
}
