//euclid_gcd.cpp: Rishabh Dev
//Description: This program calculates GCD using Euclidean Algorithm.

#include <iostream>

using namespace std;

//A Non-recursive version of Euclid's Algorithm
int gcd(int number1, int number2){
    int temp;
    while(number2 != 0){
        temp = number1 % number2;
        number1 = number2;
        number2= temp;
    }

    return number1;
}

int main(){
    int num1;
    int num2;

    cout << "PLease enter 2 integers: ";
    if(!(cin >> num1 >> num2)){
        cin.clear();
        cin.ignore(10000, '\n');
        cout << "Plaese only enter integers." << endl;
    }else{
        cout << "The GCD of (" << num1 << ", " << num2 << ") is " << gcd(num1, num2) << endl;
    }

}