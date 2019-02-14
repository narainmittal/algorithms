public class Main {

    class Matrix {
        private Slot[][] matrix;
        private int rows;
        private int cols;

        private Player player1;
        private Player player2;


        public Matrix(int rows, int cols, Player player1, Player player2) {
            matrix = new Slot[rows][cols];
            this.rows = rows;
            this.cols = cols;
            this.player1 = player1;
            this.player2 = player2;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Slot.EMPTY;
                }
            }
        }

        public Boolean isFull(int y) {
            // validate if column is full

            if (matrix[0][y] == Slot.EMPTY) {
                return false;
            } else {
                return true;
            }

        }

        public Boolean play(Player player, int y) {

            // find the row number it drops to
            int x = -1;
            for (int i = rows - 1; i > 0; i++) {
                if (matrix[i][y] == Slot.EMPTY) {
                    matrix[i][y] = player.getColor();
                    x = i;
                    break;
                }
            }


            // check if the player wins

            // horizontal

            int matchCount = 1;

            // right

            for (int j = 1; j <= 3; j++) {
                if (y + j >= cols) {
                    break;
                }
                if (matrix[x][y + j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }


            // left
            for (int j = 1; j <= 3; j++) {
                if (y - j < 0) {
                    break;
                }
                if (matrix[x][y - j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }

            matchCount = 1;

            // vertical
            // down
            for (int j = 1; j <= 3; j++) {
                if (x + j >= rows) {
                    break;
                }
                if (matrix[x + j][y] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }

            // up

            for (int j = 1; j <= 3; j++) {
                if (x - j < 0) {
                    break;
                }
                if (matrix[x - j][y] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }
            // diagonal

            matchCount = 1;

            // upper right
            for (int j = 1; j <= 3; j++) {
                if (x - j < 0 || y + j >= cols) {
                    break;
                }
                if (matrix[x - j][y + j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }

            // lower left

            for (int j = 1; j <= 3; j++) {
                if (x + j >= rows || y - j < 0) {
                    break;
                }
                if (matrix[x + j][y - j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }

            matchCount = 1;
            // upper left

            for (int j = 1; j <= 3; j++) {
                if (x - j < 0 || y - j < 0) {
                    break;
                }
                if (matrix[x - j][y - j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }

            // lower right

            for (int j = 1; j <= 3; j++) {
                if (x + j >= rows || y + j >= cols) {
                    break;
                }
                if (matrix[x + j][y + j] == player.getColor()) {
                    matchCount++;
                    if (matchCount >= 4) {
                        return Boolean.TRUE;
                    }
                }
            }



            return null;
        }


    }

    class Player {
        private Slot color;

        public Player(Slot color) {
            if (color == Slot.BLUE || color == Slot.RED) {
                this.color = color;
            }
        }

        public Slot getColor() {
            return color;
        }
    }

    enum Slot {
        RED, BLUE, EMPTY;
    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");
    }
}
