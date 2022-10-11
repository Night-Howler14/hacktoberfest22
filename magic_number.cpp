// magic_number.cpp: Rishabh Dev
// Description: Take an input number and return the magic number.

#include <iostream>
using namespace std;

// The following function reverses numbers.
int Reverse(int number){
    int rev = 0, rem = 0;
    //cout << number%10;
    while(number != 0){
        rem = number % 10;
        rev = (rev * 10) + rem;
        number /= 10;
    }
    return rev;
}

// The following function is the main function.
int main(){
    int input_number, temp, magic_number;

    // Taking a 3 digit numerical input.
    cout << "Enter a 3 digit number whose first digit more than the last digit: "; 
    
    if(!(cin >> input_number)){
        cin.clear();
        cin.ignore(10000, '\n');
        cout << "Please only enter numbers." << endl;
    }else
    {
    
        temp = Reverse(input_number);
        if(to_string(input_number).length() == 3 && input_number > temp){
        cout << endl << "Reverse of " << input_number << ": " << temp;
        
        cout << endl << "Subtract: " << input_number << " - " << temp << " = ";
        temp = input_number - temp;
        cout << temp;
    
        magic_number = temp;
        cout << endl << "Reverse of " << temp << ": ";
        temp = Reverse(temp);
        cout << temp;
    
        cout << endl << "Add: " << temp << " + " << magic_number << " = ";
        magic_number += temp;
        cout << magic_number << endl;
    
        cout << endl << "The magic number = " << magic_number; 
    
        } else{
            cout << "Please enter the number in the correct format." << endl;
        }
    }
    return 0;
}