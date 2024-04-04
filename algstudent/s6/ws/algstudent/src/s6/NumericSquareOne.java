package s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumericSquareOne {

    static boolean solutionFound = false;

    public static void main(String[] args) {
        try {
            List<String> board = readLines("src/s6/test00.txt");
            int size = Integer.parseInt(board.get(0))*2 + 1;
            String[][] grid = new String[size][size];
            for (int i = 0; i < size; i++) {
                String line = board.get(i + 1);
                grid[i] = line.split(" ");
            }
            solve(grid, size);
           
        } catch (IOException e) {
            System.out.println("The path to the file is wrong");
        }
    }

    public static void solve(String[][] board, int size) {
        backtrack(board, size, 0, 0);
        if (!solutionFound) {
            System.out.println("No solution found.");
        }
    }

    public static void backtrack(String[][] board, int size, int row, int col) {
        if (solutionFound) {
            return;
        }

        if (row == size) {
            if (isValidSolution(board, size)) {
                printSolution(board, size);
                solutionFound = true;
            }
            return;
        }

        if (col == size) {
            backtrack(board, size, row + 1, 0);
            return;
        }

        if (row < size && col < size) { 
            if (board[row][col].equals("?")) {
                for (int num = 0; num <= 9; num++) {
                    String aux = String.valueOf(num);
                    board[row][col] = aux;
                    backtrack(board, size, row, col + 1);
                    board[row][col] = "?";
                }
            } else {
                backtrack(board, size, row, col + 1);
            }
        }
    }

    public static boolean isValidSolution(String[][] board, int size) {
        for (int row = 0; row < size; row += 2) {
            StringBuilder equation = new StringBuilder();
            int result = 0;
            int expected = 0;

            for (int col = 0; col < size; col++) {
                equation.append(board[row][col]);
                if (col % 2 == 0) {
                    int num = Integer.parseInt(board[row][col]);
                    if (col == 0) {
                        result = num;
                    } else {
                        char operator = board[row][col - 1].charAt(0);
                        switch (operator) {
                            case '+':
                                result += num;
                                break;
                            case '-':
                                result -= num;
                                break;
                            case '*':
                                result *= num;
                                break;
                            case '/':
                                if (num != 0 && result % num == 0) {
                                    result /= num;
                                } else {
                                    return false;
                                }
                                break;
                        }
                    }
                }
            }
            
            try {
                expected = Integer.parseInt(board[row][size - 1]);
            } catch (NumberFormatException e) {
                return false;
            }

            if (result != expected) {
                return false;
            }
        }
        return true;
    }
    
    public static void printSolution(String[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}


