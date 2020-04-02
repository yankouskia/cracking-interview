/*
  [NOT OPTIMIZED]
  As noted in the beginning of the solution, it might be more optimal to run multiple tests at once.
  if we divide the bottles up into 10 groups (with bottles 0-99 going to strip 0, bottles 100-199 going to strip
  1, bottles 200 - 299 going to strip 2, and so on), then day 7 will reveal the first digit of the bottle number. A
  positive result on strip i at day 7 shows that the first digit (100's digit) of the bottle number is i.
  Dividing the bottles in a different way can reveal the second or third digit. We just need to run these tests
  on different days so that we don't confuse the results
*/

/*
  [OPTIMIZED]
  Optimal Approach (7 days)
  We can actually optimize this slightly more, to return a result in just seven days. This is of course the
  minimum number of days possible. Let's imagine that our strips are bits in 10bits mask. 2^10 > 1000, then we
  will mark on each strip the drop from bottle in case its number has a 1 in the same bit.
  In 7 days we could just transform the bits from strips to actual number in 10 numeric system.
*/
