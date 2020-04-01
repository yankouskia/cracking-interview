/*
  [INCORRECT] At first assumption, we need to find such number x (floors number), which we will drop the egg skipping those floors each time.
  If an egg breaks, we need to iterate over all x floors again (from previous try) to find right floor.
  So the function for that:
  f(x) = N / x + x + C;

  Let's find extremum:
  f'(x) = - N / x^2 + 1;
  N = x ^ 2;

  So for current problem, the optimal number of floors to skip each time is 10.
  Then attempts number is 19 in worst case.

*/

/*
  [CORRECT] The number of attempts should be the same for each floor an egg can possibly break:
  For first attempt (break on x floor) number of attempts is M; On each attempt the number of floors should decrease by one.

  x + (x - 1) + (x - 2) + (x - 3) + ... + 1 = 100;
  (1 + x) * x / 2 = 100;
  x = 13.xxx; Double
  x = 14; Integer

  Min number of attempts: 14
*/
