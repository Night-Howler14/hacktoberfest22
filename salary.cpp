// salary.cpp: Rishabh Dev
// Description: Calculate the most profitable option for salary.

#include <iostream>
using namespace std;

// Constants which are defined throught the program
#define kPricePerUnit 225  // average price of a pair of shoes
#define kWeeklyWage 600    // current weekly wage - Method 1
#define kSalary 7          // hourly salary - Method 2 
#define kHoursPerWeek 40   // number of ours worked - Method 2
#define kCommission2 0.10  // commission - Method 2
#define kCommission3 0.20  // commission - Method 3
#define kBonusPerUnit 20   // bonus - Method 3

//A function to get the weekly sales of the units
int GetInput(){
    int units;
    cout << "Enter the number of units sold: ";
    if(!(cin >> units && units > -1)){
        cin.clear();
        cin.ignore(10000,'\n');
        cout << "Numbers only. " << endl;
        return 0;
    }else{
        return units;
    }
}

//Method 1: This is always the same; $600 per week
void CalcMethod1(){
    cout << "Method 1: " << kWeeklyWage << endl;
}

//Method 2: A salary of $7.00 per hour plus a 10% commision on sale
void CalcMethod2(int weekly_sales){
    double per_hour, commission, total_pay;

    per_hour = (kSalary * kHoursPerWeek);
    commission = (weekly_sales * kPricePerUnit) * kCommission2;
    total_pay = per_hour + commission;

    cout << "Method 2: " << total_pay << endl;
}

// Method 3: No salary, but 20% commissions and $20 for each pair of shoes sold
void CalcMethod3(int weekly_sales){
    double bonus, commission, total_pay;

    bonus = kBonusPerUnit * weekly_sales;
    commission = (weekly_sales * kPricePerUnit) * kCommission3;
    total_pay = bonus + commission;

    cout << "Method 3: " << total_pay << endl;
}

int main(){

    int weekly_sales = GetInput();
    CalcMethod1();
    CalcMethod2(weekly_sales);
    CalcMethod3(weekly_sales); 

    return 0;
}