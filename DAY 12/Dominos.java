/*
  For each row we place, we'll always have one domino that needs to poke into the next row. No matter how
  many times and ways we try to solve this issue, we won't be able to successfully lay down all the dominoes.

  There's a cleaner, more solid proof for why it won't work. The chessboard initially has 32 black and 32 white
  squares. By removing opposite corners (which must be the same color), we're left with 30 of one color and
  32 of the other color. Let's say, for the sake of argument, that we have 30 black and 32 white squares.

  Each domino we set on the board will always take up one white and one black square.Therefore, 31 dominos
  will take up 31 white squares and 31 black squares exactly. On this board, however, we must have 30 black
  squares and 32 white squares. Hence, it is impossible.
*/
