#include <iostream>
#include <string>
#include <fstream>

using namespace std;

void reverse(char* str)
{
  char* end = str;

  while (*end)
  {
    end++;
  }

  end--;

  while (str < end) {
    char temp = *str;

    *str = *end;
    *end = temp;

    end--;
    str++;
  }
}

int main()
{
  string str = "some string" ;
  char* cstr = &str[0];

  reverse(cstr);

  cout << str << endl;

}
