package tictactoe;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static int shiftCounterX = 1;
    static int shiftCounterO = 1;

    public static char[][] boardData(char[][] board) {
        //int i = 0;
        for (char[] rowChars : board) {
            Arrays.fill(rowChars, ' ');
        }
        return board;
    }

    public static void displayBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char col : row) {
                System.out.printf("%c ", col);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean threeAcross(char[][] board, char playerTicker) {
        for (char[] rowChars : board) {
            if (Character.valueOf(rowChars[0]).equals(playerTicker)
                    && Character.valueOf(rowChars[1]).equals(playerTicker)
                    && Character.valueOf(rowChars[2]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeDown(char[][] board, char playerTicker) {
        for (int i = 0; i < board.length; i++) {
            if (Character.valueOf(board[0][i]).equals(playerTicker)
                    && Character.valueOf(board[1][i]).equals(playerTicker)
                    && Character.valueOf(board[2][i]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeDiagonal(char[][] board, char playerTicker) {
        for (int i = 0; i < board.length; i++) {
            if (Character.valueOf(board[0][0]).equals(playerTicker)
                    && Character.valueOf(board[1][1]).equals(playerTicker)
                    && Character.valueOf(board[2][2]).equals(playerTicker)
                    || Character.valueOf(board[0][2]).equals(playerTicker)
                    && Character.valueOf(board[1][1]).equals(playerTicker)
                    && Character.valueOf(board[2][0]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasWon(char[][] board, char playerTicker) {
        if (threeAcross(board, playerTicker)) {
            return true;
        } else if (threeDown(board, playerTicker)) {
            return true;
        } else {
            return threeDiagonal(board, playerTicker);
        }
    }

    public static boolean checkOpenSpaces(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                if (Character.valueOf(col).equals('_') || Character.valueOf(col).equals(' ')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkNumOfTickerDiff(char[][] board, char x, char o) {
        int countX = 0;
        int countO = 0;

        for (char[] row : board) {
            for (char col : row) {
                if (Character.valueOf(col).equals(x)) {
                    countX++;
                }
                if (Character.valueOf(col).equals(o)) {
                    countO++;
                }
            }
        }
        return countX > countO + 1 || countO > countX + 1;
    }

    public static String checkGameStatus(char[][] board) {
        char x = 'X';
        char o = 'O';
        String gameStatus = "";

        if (hasWon(board, x) && hasWon(board, o) || checkNumOfTickerDiff(board, x, o)) {
            //System.out.println("Impossible");
            gameStatus = "Impossible";
        } else if (hasWon(board, x) && !hasWon(board, o)) {
            //System.out.println("X wins");
            gameStatus = "X wins";
        } else if (hasWon(board, o) && !hasWon(board, x)) {
            //System.out.println("O wins");
            gameStatus = "O wins";
        } else if (!hasWon(board, x) && !hasWon(board, o)) {
            if (checkOpenSpaces(board)) {
                //System.out.println("Game not finished");
                gameStatus = "Game not finished";
            } else {
                gameStatus = "Draw";
               // System.out.println("Draw");
            }
        }

        return gameStatus;
    }

    public static String checkCellAvailability(int coordX, int coordY, char[][] board) {
        return Character.valueOf(board[coordX - 1][coordY -1]).equals('X') ||
                Character.valueOf(board[coordX - 1][coordY -1]).equals('O') ? "Occupied" : "Available";
    }

    public static char[][] newBoardDataX(int coordX, int coordY, char[][] board) {
        board[coordX -1 ][coordY -1]  = 'X';
        return board;
    }

    public static char[][] newBoardDataO(int coordX, int coordY, char[][] board) {
        board[coordX -1 ][coordY -1]  = 'O';
        return board;
    }


    public static void main(String[] args) {
        displayBoard(boardData(board));
        //System.out.println(Arrays.toString(boardData()[1]));
        //checkGameStatus(boardData(input));

        while (true) {
            System.out.print("Enter the coordinates: ");
            String inputX = scanner.next();
            String inputY = scanner.next();
            int coordX;
            int coordY;



            try{
                coordX = Integer.parseInt(inputX);
                coordY = Integer.parseInt(inputY);

                if (coordX < 1 || coordX > 3 || coordY < 1 || coordY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (checkCellAvailability(coordX, coordY, board).equals("Occupied")) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (shiftCounterX <= shiftCounterO && shiftCounterX <= 5) {
                            displayBoard(newBoardDataX(coordX, coordY, board));
                            //checkGameStatus(board);

                            if (checkGameStatus(board).equals("Impossible")) {
                                System.out.println("Impossible");
                                break;
                            } else if (checkGameStatus(board).equals("X wins")) {
                                System.out.println("X wins");
                                break;
                            } else if (checkGameStatus(board).equals("O wins")) {
                                System.out.println("O wins");
                                break;
                            } else if (checkGameStatus(board).equals("Draw")) {
                                System.out.println("Draw");
                                break;
                            }
                            shiftCounterX++;
                            //System.out.println("contador x: " + shiftCounterX);

                        } else {
                            displayBoard(newBoardDataO(coordX, coordY, board));
                            //checkGameStatus(board);


                            if (checkGameStatus(board).equals("Impossible")) {
                                System.out.println("Impossible");
                                break;
                            } else if (checkGameStatus(board).equals("X wins")) {
                                System.out.println("X wins");
                                break;
                            } else if (checkGameStatus(board).equals("O wins")) {
                                System.out.println("O wins");
                                break;
                            } else if (checkGameStatus(board).equals("Draw")) {
                                System.out.println("Draw");
                                break;
                            }

                            shiftCounterO++;
                            //System.out.println("contador o: " + shiftCounterO);
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                System.out.println("You should enter numbers!");
            }

        }

    }
}


/*public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static char[][] boardData(String input) {
        char[][] board = new char[3][3];
        int i = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = input.charAt(i++);
            }
        }
        return board;
    }

    public static void displayBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char col : row) {
                System.out.printf("%c ", col);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean threeAcross(char[][] board, char playerTicker) {
        for (int i = 0; i < board.length; i++) {
            if (Character.valueOf(board[i][0]).equals(playerTicker)
                    && Character.valueOf(board[i][1]).equals(playerTicker)
                    && Character.valueOf(board[i][2]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeDown(char[][] board, char playerTicker) {
        for (int i = 0; i < board.length; i++) {
            if (Character.valueOf(board[0][i]).equals(playerTicker)
                    && Character.valueOf(board[1][i]).equals(playerTicker)
                    && Character.valueOf(board[2][i]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeDiagonal(char[][] board, char playerTicker) {
        for (int i = 0; i < board.length; i++) {
            if (Character.valueOf(board[0][0]).equals(playerTicker)
                    && Character.valueOf(board[1][1]).equals(playerTicker)
                    && Character.valueOf(board[2][2]).equals(playerTicker)
                    || Character.valueOf(board[0][2]).equals(playerTicker)
                    && Character.valueOf(board[1][1]).equals(playerTicker)
                    && Character.valueOf(board[2][0]).equals(playerTicker)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasWon(char[][] board, char playerTicker) {
        if (threeAcross(board, playerTicker)) {
            return true;
        } else if (threeDown(board, playerTicker)) {
            return true;
        } else {
            return threeDiagonal(board, playerTicker);
        }
    }

    public static boolean checkOpenSpaces(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                if (Character.valueOf(col).equals('_') || Character.valueOf(col).equals(' ')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkNumOfTickerDiff(char[][] board, char x, char o) {
        int countX = 0;
        int countO = 0;

        for (char[] row : board) {
            for (char col : row) {
                if (Character.valueOf(col).equals(x)) {
                    countX++;
                }
                if (Character.valueOf(col).equals(o)) {
                    countO++;
                }
            }
        }
        return countX > countO + 1 || countO > countX + 1;
    }

    public static void checkGameStatus(char[][] board) {
        char x = 'X';
        char o = 'O';

        if (hasWon(board, x) && hasWon(board, o) || checkNumOfTickerDiff(board, x, o)) {
            System.out.print("Impossible");
        } else if (hasWon(board, x) && !hasWon(board, o)) {
            System.out.print("X wins");
        } else if (hasWon(board, o) && !hasWon(board, x)) {
            System.out.print("O wins");
        } else if (!hasWon(board, x) && !hasWon(board, o)) {
            if (checkOpenSpaces(board)) {
                System.out.print("Game not finished");
            } else {
                System.out.print("Draw");
            }
        }
    }

    public static String checkCellAvailability(Integer coordX, Integer coordY, char[][] board) {
        return Character.valueOf(board[coordX - 1][coordY -1]).equals('X') ||
                Character.valueOf(board[coordX - 1][coordY -1]).equals('O') ? "Occupied" : "Available";
    }

    public static char[][] newBoardData(Integer coordX, Integer coordY, char[][] board) {
        board[coordX -1 ][coordY -1]  = 'X';
        return board;
    }


    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String input = scanner.nextLine().toUpperCase();
        displayBoard(boardData(input));
        //checkGameStatus(boardData(input));

        while (true) {
            System.out.print("Enter the coordinates: ");
            String inputX = scanner.next();
            String inputY = scanner.next();
            Integer coordX;
            Integer coordY;

            try{
                coordX = Integer.parseInt(inputX);
                coordY = Integer.parseInt(inputY);

                if (coordX < 1 || coordX > 3 || coordY < 1 || coordY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (checkCellAvailability(coordX, coordY, boardData(input)) == "Occupied") {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        displayBoard(newBoardData(coordX, coordY, boardData(input)));
                        break;
                    }
                }

            } catch (NumberFormatException ex) {
                System.out.println("You should enter numbers!");
            }

        }

    }
}*/
