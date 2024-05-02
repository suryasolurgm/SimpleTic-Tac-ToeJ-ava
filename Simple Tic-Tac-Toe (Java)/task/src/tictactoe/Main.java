package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int BOARD_SIZE = 3;
    static char checkWin(char[][] charArray, char player) {
        int targetSum = player == 'X' ? 264 : 237;
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((charArray[i][0] + charArray[i][1] + charArray[i][2] == targetSum) ||
                    (charArray[0][i] + charArray[1][i] + charArray[2][i] == targetSum)) {
                return player;
            }
        }
        // Check diagonals
        if ((charArray[0][0] + charArray[1][1] + charArray[2][2] == targetSum) ||
                (charArray[0][2] + charArray[1][1] + charArray[2][0] == targetSum)) {
            return player;
        }
        return 'N';
    }

    static void printBoard(char[][] charArray) {
        System.out.println("---------");
        for (char[] row : charArray) {
            System.out.printf("| %c %c %c |\n", row[0], row[1], row[2]);
        }
        System.out.println("---------");
    }
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.next();
        char[][] charArray = new char[BOARD_SIZE][BOARD_SIZE];

        for(char[] ch:charArray){
            Arrays.fill(ch,' ');
        }

        printBoard(charArray);
        int countMoves=0;
        char user ='X';

        while (true){
            int row=0;
            int col=0;
            try {
                 row = scanner.nextInt()-1;
                 col = scanner.nextInt()-1;
            }catch (Exception e){
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }
            if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (charArray[row][col] != ' ') {
                System.out.println("This cell is occupied!");
                continue;
            }
            charArray[row][col] = user;
            char winner = checkWin(charArray, user);
            if (winner != 'N') {
                printBoard(charArray);
                System.out.println(winner + " wins");
                break;
            } else if (++countMoves  == BOARD_SIZE * BOARD_SIZE) {
                printBoard(charArray);
                System.out.println("Draw");
                break;
            }
            printBoard(charArray);
            user = (user == 'X') ? 'O' : 'X';

        }

    }
}
