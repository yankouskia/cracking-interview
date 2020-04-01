/*
  Let's take a look at probability for each case:
  G - 50%
  BG - 25%
  BBG - 12.5%
  BBBG - 6.25%
  ...

  Let's take a look at probability for each gender-specific person separately:
  G - 1/2; B - 0;
  G - 1/4; B - 1/4;
  G - 1/8; B - 2/8;
  G - 1/16; B - 3/16;

  So, for girls we have: (1/2 + 1/4 + 1/8 + ....). For boys: (0 + 1/4 + 2/8 + 3/16 + 4/32 + ...).
  After we subtract second from first one we will see, that it's the same.
  So the number of girls and boys will be the same if people will abide by this policy
*/

