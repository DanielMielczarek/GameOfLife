package GameOfLife.model;


public class Board {

    private int sizeX = 50;
    private int sizeY = 50;
    public Dot[][] board = new Dot[sizeX][sizeY];
    private Dot[][] tempBoard;


//    public void setDotsOnBoard() {
//        board[6][1] = new Dot(6, 1, true);
//        board[6][2] = new Dot(6, 2, true);
//        board[6][3] = new Dot(6, 3, true);
//        board[5][3] = new Dot(5, 3, true);
//        board[4][2] = new Dot(4, 2, true);
//    }

    private int neighborsDot(int xPosition, int yPosition) {
        int neighbors = 0;
        int counter;
        try {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (board[xPosition + i][yPosition + j].isALive() && board[xPosition + i][yPosition + j] != board[xPosition][yPosition]) {
                        neighbors += 1;
//                    } else {
//                        System.out.println("nie ma sąsiadów");
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignore){}

        counter = neighbors;
        return counter;
    }

    public void nextGen() {

        setTempBoard();
//
//        System.out.println("INBOARD");
//        for (int i = 0; i < this.board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < this.board[i].length; j++) {
//                System.out.print(this.board[i][j].isALive() + " ");
//            }
//        }

        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++) {
                if (neighborsDot(i, j) == 3 && !this.board[i][j].isALive()) {
                    this.tempBoard[i][j].setALive(true);
                }
                if (this.board[i][j].isALive() && (neighborsDot(i, j) == 2 || neighborsDot(i, j) == 3)) {
                    this.tempBoard[i][j].setALive(true);
//                    this.tempBoard[i][j].changeColor();

                }
            }
//        System.out.println("TEMPBOARD AFTER");
//        for (int i = 0; i < tempBoard.length; i++) {
//            System.out.println();
//            for (int j = 0; j < tempBoard[i].length; j++) {
//                System.out.print(tempBoard[i][j].isALive() + " ");
//            }
//        }
        this.board = tempBoard;
        tempBoard = null;

//
//        System.out.println("BOARD = TEMPBOARD");
//        for (int i = 0; i < board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j].isALive() + " ");
//            }
//        }
    }

    private void setTempBoard() {
        tempBoard = new Dot[sizeX][sizeY];
        for (int i = 0; i < this.tempBoard.length; i++) {
            for (int j = 0; j < this.tempBoard[i].length; j++) {
                this.tempBoard[i][j] = new Dot(i, j, false);
            }
        }
    }

    public void setBoard(Dot[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Dot(i, j, false);

//                board[4][5] = new Dot(4,5,true);
//                board[4][6] = new Dot(4,6,true);
            }
        }
        board[4][4].setALive(true);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
