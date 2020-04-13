## DAY 25. C and C++

List of tasks:

- [Last K Lines](https://github.com/yankouskia/cracking-interview/tree/master/DAY%2025/LastKLines.cpp)  
  *Write a method to print the last K lines of an input file using C++.*  

### Shell to compile

```sh
cvb () {
  /usr/bin/clang++ -std=c++17 -stdlib=libc++ -g $1 -o "$1.test"
  $1.test
  rm -rf $1.test
  rm -rf $1.test.dSYM
}

cvb ./LastKLines.cpp
```
