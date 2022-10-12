#include<iostream>
//C++ pointers and arrays
/* marks --> address of first block 
&marks --> WRONG!   

p = marks;
p++;
*(p) = 32;
*(p+1) = 99;
*(p+2) = 38;
*(p+3) = 51;

pointer arithmetic:
address new = address current + i*sizeof(datatype)
example -> (p+i) = p + 1*4    // i = 1 h cz 1 se increment kra h
*/
using namespace std;

int main(){
int marks[4] = {23, 45, 56, 89};
 for( int i =0; i<4; i++){
    cout << "The value of marks "<< i << " is " << marks[i] << endl;
    }
    
    // Pointers and Arrays
    int *p = marks;
    cout << "The value of marks[0] is " << *p << endl;
    cout << "The value of marks[1] is " << *(p+1) << endl;
    cout << "The value of marks[2] is " << *(p+2) << endl;
    cout << "The value of marks[3] is " << *(p+3) << endl;

// cout << *(p++) << endl ;  --> isme p i.e. 23 phle print hogi i.e. 1st value afterthat p increment hogi
// cout << *p << endl;   --> isme 45 aa a ga cz p increment ho chuka h i.e. agle wale value pr aa chuka h
// bt agr hmne cout << *p skip kr diya nd directly ye kiya-->
// cout <<*(++p) << endl;  --> ye phle increment kr jaa a ga
    return 0;
}