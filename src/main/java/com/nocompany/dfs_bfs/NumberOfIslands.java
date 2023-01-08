package com.nocompany.dfs_bfs;

import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] input = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = numIslandsBfsApproach(input);

        System.out.println("Result: " + result);

    }

    public static int numIslandsDfsApproach(char[][] grid) {
        int numberOfIslands = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == '1') {
                    ++numberOfIslands;
                    dfs(grid, rowIndex, columnIndex);
                }
            }
        }

        return numberOfIslands;
    }

    public static void dfs(char[][] grid, int rowIndex, int columnIndex) {

        if (rowIndex < 0 || columnIndex < 0 ||
                rowIndex >= grid.length || columnIndex >= grid[0].length ||
                grid[rowIndex][columnIndex] == '0') {
            return;
        }

        grid[rowIndex][columnIndex] = '0';

        dfs(grid, rowIndex - 1, columnIndex);
        dfs(grid, rowIndex, columnIndex - 1);
        dfs(grid, rowIndex, columnIndex + 1);
        dfs(grid, rowIndex + 1, columnIndex);
    }

    public static int numIslandsBfsCustomApproach(char[][] grid) {
        int numsOfIslands = 0;
        if (grid == null) {
            return 0;
        }
        int rLength = grid.length;
        int cLength = grid[0].length;

        if (rLength <= 0 || cLength <= 0) {
            return 0;
        }

        for (int row = 0; row < rLength; row++) {
            for (int column = 0; column < cLength; column++) {
                if (grid[row][column] == '1') {
                    ++numsOfIslands;
                    grid[row][column] = '0';

                    Queue<Integer> neighbors = new PriorityQueue<>();
                    neighbors.add(row * cLength + column);
                    while (!neighbors.isEmpty()) {
                        Integer index = neighbors.remove();
                        int currentRow = index / cLength;
                        int currentCol = index % cLength;
                        if (currentRow - 1 >= 0 && grid[currentRow - 1][currentCol] == '1') {
                            grid[currentRow - 1][currentCol] = '0';
                            neighbors.add((currentRow - 1) * cLength + currentCol);
                        }
                        if (currentRow + 1 < rLength && grid[currentRow + 1][currentCol] == '1') {
                            grid[currentRow + 1][currentCol] = '0';
                            neighbors.add((currentRow + 1) * cLength + currentCol);
                        }
                        if (currentCol - 1 >= 0 && grid[currentRow][currentCol - 1] == '1') {
                            grid[currentRow][currentCol - 1] = '0';
                            neighbors.add(currentRow * cLength + currentCol - 1);
                        }
                        if (currentCol + 1 < cLength && grid[currentRow][currentCol + 1] == '1') {
                            grid[currentRow][currentCol + 1] = '0';
                            neighbors.add(currentRow * cLength + currentCol + 1);
                        }
                    }
                }
            }
        }
        return numsOfIslands;
    }

    public static int numIslandsBfsApproach(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new PriorityQueue<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }


}
