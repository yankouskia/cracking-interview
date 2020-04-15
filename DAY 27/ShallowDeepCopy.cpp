#include <iostream>

using namespace std;

int K = 5;

int* shallowCopy(int* origin) {
  int* shallow = new int[K];
  shallow = origin;

  return shallow;
}

int* deepCopy(int* origin) {
  int size = K;
  int* deep = new int[size];

  for (int i = 0; i < size; i++) {
    deep[i] = origin[i];
  }

  return deep;
}

int main() {
  int k = 5;
  int* origin = new int[5];

  for (int i = 0; i < k; i++) {
    origin[i] = i + 1;
  }

  int* shallow = shallowCopy(origin);
  int* deep = deepCopy(origin);

  for (int i = 0; i < K; i++) {
    cout << shallow[i] << " ";
  }

  cout << endl;

  for (int i = 0; i < K; i++) {
    cout << deep[i] << " ";
  }

  cout << endl;

  return 0;
}
