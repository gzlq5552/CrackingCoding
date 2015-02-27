/*
 * Question 1.2: Implement a function void reverse(char* str) in C or C++
 * which reverses a null-terminated string.
 */
#include <iostream>
using namespace std;
void reverseString (char*);

int main()
{
   char str[] = "abcdefg"; // the char* str = "..." declaration is obsolete, causing segmentation core dump error
   reverseString(str);
   cout << str << endl;
   return 0;
}

void reverseString (char *str) {
    char *end = str;

    if (str) {
        while (*end) {
            ++end;
        }
        --end;

        while (str < end) {
            char temp = *str;
            *str++ = *end;
            *end-- = temp;
        }
    }
}
