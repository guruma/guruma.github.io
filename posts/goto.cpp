#include <iostream>
#include <list>
#include <vector>

using namespace std;

int main() 
{
  int i = 0;
  i++;
  std::list<int> lst1 ( { 1, 2, 3, 4, 5, 6, 7 });
  {
    L1:
    if (lst1.empty()) return 0;
    int a = lst1.front();
    lst1.pop_front();

    std::list<int> lst2 ( { 1, 2, 3, 4, 5, 6, 7 });
    {
      L2:
      if (lst2.empty()) goto L1;
      int b = lst2.front();
      lst2.pop_front();
      cout << a << " " << b << endl;
      goto L2;
    }
    
  }
  goto L1;

  return 0;
}
