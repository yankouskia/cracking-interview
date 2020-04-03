import java.util.Random;

public class Minesweeper {
  public static void main(String[] args) {
    Game game = new Game();

    game.check(0, 0);
    System.out.println(game.getStatus());

    game.check(1, 5);
    System.out.println(game.getStatus());
  }
}

enum Status {
  IN_PROGRESS,
  WIN,
  LOOSE;
}

class Game {
  private Status status = Status.IN_PROGRESS;
  private Board board = new Board();

  public Game() {
    this.board.print();
  }

  public Status getStatus() {
    return this.status;
  }

  public Status check(int row, int column) {
    Cell cell = this.board.check(row, column);

    if (cell.isBomb()) {
      this.status = Status.LOOSE;
    }

    if (this.board.getRemainingCells() == 0) {
      this.status = Status.WIN;
    }

    return this.status;
  }
}

enum Level {
  EASY,
  MEDIUM,
  HARD,
  UNREAL;
}

class Board {
  private static int SIDE_COUNT = 8;

  private Level level;
  private int allBombs;
  private int remainingCells;
  private Cell[][] board = new Cell[SIDE_COUNT][SIDE_COUNT];
  private boolean isBlocked = false;

  public Board() {
    this(Level.EASY);
  }

  public Board(Level level) {
    this.level = level;
    this.allBombs = this.getBombsNumber(level);
    this.remainingCells = SIDE_COUNT * SIDE_COUNT - this.allBombs;

    this.fillOutBombs();
  }

  public int getRemainingCells() {
    return this.remainingCells;
  }

  private int getBombsNumber(Level level) {
    if (level == Level.EASY) return SIDE_COUNT * SIDE_COUNT / 10;
    if (level == Level.MEDIUM) return SIDE_COUNT * SIDE_COUNT / 5;
    if (level == Level.HARD) return SIDE_COUNT * SIDE_COUNT / 3;
    return SIDE_COUNT * SIDE_COUNT / 2;
  }

  private void fillOutBombs() {
    int[][] preBoard = new int[SIDE_COUNT][SIDE_COUNT];

    int filledBombs = 0;
    Random random = new Random();

    while (filledBombs < this.allBombs) {
      int row = random.nextInt(SIDE_COUNT);
      int column = random.nextInt(SIDE_COUNT);

      if (preBoard[row][column] == 0) {
        preBoard[row][column] = -1;
        filledBombs++;
      }
    }

    for (int row = 0; row < SIDE_COUNT; row++) {
      for (int column = 0; column < SIDE_COUNT; column++) {
        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            if (i != 0 || j != 0) {
              if (row + i >= 0 && row + i < SIDE_COUNT) {
                if (column + j >= 0 && column + j < SIDE_COUNT) {
                  int preBoardNeighborValue = preBoard[row + i][column + j];
                  int preBoardCurrentValue = preBoard[row][column];

                  if (preBoardNeighborValue == -1 && preBoardCurrentValue >= 0) {
                    preBoard[row][column]++;
                  }
                }
              }
            }
          }
        }

        boolean isBomb = preBoard[row][column] == -1;
        int neighborBombs = preBoard[row][column] == -1 ? -1 : preBoard[row][column];
        this.board[row][column] = new Cell(isBomb, neighborBombs);
      }
    }
  }

  public void print() {
    for (int row = 0; row < SIDE_COUNT; row++) {
      for (int column = 0; column < SIDE_COUNT; column++) {
        System.out.print(this.board[row][column].toString() + "\t");
      }
      System.out.println();
    }
  }

  private void exposeNeighbors(int row, int column) {
    if (this.board[row][column].isExposed()) {
      return;
    }

    this.board[row][column].expose();
    this.remainingCells--;

    if (this.board[row][column].getNeighborBombs() == 0) {
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i != 0 || j != 0) {
            if (row + i >= 0 && row + i < SIDE_COUNT) {
              if (column + j >= 0 && column + j < SIDE_COUNT) {
                this.exposeNeighbors(row + i, column + j);
              }
            }
          }
        }
      }
    }
  }

  public Cell check(int row, int column) {
    if (this.isBlocked) {
      throw new Error("Bomb is exposed. You cannot continue to check");
    }

    Cell cell = this.board[row][column];

    if (cell.isBomb()) {
      cell.expose();
      this.isBlocked = true;
      return cell;
    }

    this.exposeNeighbors(row, column);
    return cell;
  }
}

class Cell {
  private boolean isBomb;
  private boolean isExposed;
  private Integer neighborBombs;

  public Cell(boolean isBomb, int neighborBombs) {
    this.isBomb = isBomb;
    this.neighborBombs = neighborBombs;

    this.isExposed = false;
  }

  public void expose() {
    this.isExposed = true;
  }

  public boolean isBomb() {
    return this.isBomb;
  }

  public boolean isExposed() {
    return this.isExposed;
  }

  public Integer getNeighborBombs() {
    return this.neighborBombs;
  }

  @Override
  public String toString() {
    if (!this.isExposed) return "#";
    if (this.isBomb) return "X";
    return this.neighborBombs.toString();
  }
}
