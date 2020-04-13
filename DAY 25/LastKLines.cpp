#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
  ifstream file("lines.txt");

  int k = 5;
  string lines[k];
  int current = 0;

  while(file.peek() != EOF) {
    getline(file, lines[current % k]);
    current++;
  }

  int all = min(current, k);

  // an input file using C++.
  for (int i = 0; i < all; i++) {
    cout << lines[(current + i) % k] << " ";
  }

  cout << endl;
}
