#include<iostream>
//Arrays
/* An array is a collection of items of similar type stored in continuous memory locations*/
using namespace std;

int main(){
    int marks[4] = {23, 45, 56, 89};
    int Mathmarks[4];
    Mathmarks[0] = 2278;
    Mathmarks[1] = 738;
    Mathmarks[2] = 378;
    Mathmarks[3] = 578;
    
    cout << "These are math marks" <<endl;

    cout << Mathmarks[0] << endl;
    cout << Mathmarks[1] << endl;
    cout << Mathmarks[2] << endl;
    cout << Mathmarks[3] << endl;

// marks[2] = 455;  --> in this way we can change the value of an array
   cout << "These are marks" <<endl;

    // cout << marks[0] << endl;
    // cout << marks[1] << endl;
    // cout << marks[2] << endl;
    // cout << marks[3] << endl; 


//using for loops
    // for( int i =0; i<4; i++){
    //     cout << "The value of marks "<< i << " is " << marks[i] << endl;
    // }



//using While loops
    // int i = 0;
    // while(i<4){
    //   cout << "The value of marks "<< i << " is " << marks[i] << endl;
    // i++;
    // }


//using do- while loops
int i = 0;
    do{
        cout << "The value of marks "<< i << " is " << marks[i] << endl;
    i++;
    }
    while(i < 4);

    return 0;
}