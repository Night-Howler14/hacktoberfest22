// decode_date.cpp: Rishabh Dev
// Description: A program to determine the date encoded by manufacturers.

#include <iostream>
using namespace std;

// The follwing function takes the input as encoded month and
// returns the real month.
string GetMonth(string month){

    const string kMonthsCode = "ABCDEFGHIJKL";      // The code letters of months, each represting a month.

    const string kMonthsList[12] = {"Jan", "Feb", "Mar", "Apr", "May", "June",      // List of Actual
                                    "July", "Aug", "Sep", "Oct", "Nov", "Dec"};     // months.

    string temp;    // Temporary variable for checking the months.

    // The following for-loop traverses through kMonthsCode and
    // returns the real month from kMonthsList, if found.
    for(int traverse_month = 0; traverse_month < kMonthsCode.length(); traverse_month ++){
        temp = kMonthsCode[traverse_month];  
        if(month == temp)
            return kMonthsList[traverse_month];    // Return the real month.
    }

    return "XXX";   // If the code is wrong, then XXX will be returned.
}

// The follwing function takes the input as encoded date and
// returns the real date.
string GetDate(string date){

    string decoded_date_digits;

    const string kDateDigitCode = "QRSTUVWXYZ";     // The code letters of date, each represting
                                                    // the numbers 0 to 9 respectively.
    
    // The following for-loop traverses through date and kDateDigitCode
    // returns the real date, if found.
    for(int traverse_date = 0; traverse_date < date.length(); traverse_date++)
        for(int traverse_code = 0; traverse_code < kDateDigitCode.length(); traverse_code++)
            if(date[traverse_date] == kDateDigitCode[traverse_code])
                decoded_date_digits += to_string(traverse_code);    //Adding the decoded numbers to decoded_date_digits.

    return decoded_date_digits;  // Return the decoded date digits.
}

// The follwing function takes the input as encoded year and
// returns the real year.
string GetYear(string year){

    const string kYearCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";     // The code letters of year, each represting
                                                                    // the numbers 1 to 26 respectively.

    string temp;    // Temporary variable for checking the months.

    // The following for-loop traverses through kYearCode
    // returns the real Year as (1995 + position of coded year in kYearCode + 1), if found.
    for(int traverse_year = 0; traverse_year < kYearCode.length(); traverse_year++){
        temp = kYearCode[traverse_year];
        if(year == temp)
            return  to_string((1995 + traverse_year + 1));  // Return the decoded year.
    }                                                                   
    return "XXXX";      // If the code is wrong, then XXXX will be returned.
}

// The following function is the main function
// that calls other date decoding functions.
string DecodeDate(string encoded_date){
    
    string month, date, year;

    month = GetMonth(encoded_date.substr(0,1));     // Call the function that decodes month.
    date = GetDate(encoded_date.substr(1,2));       // Call the function that decodes date.
    year = GetYear(encoded_date.substr(3,1));       // Call the function that decodes year.

    return (month + "-" + date+ "-" + year);        // Return the decoded date.
}

// The following the main body of the program.
int main(){
    string encoded_date = "ARZM";       // This is the date that is to be decoded.
    string decoded_date;                // This is the decoded date.

    decoded_date = DecodeDate(encoded_date);    // Call the main function to decode date.

    cout << decoded_date;       // Output the decoded date.

    return 0;
}