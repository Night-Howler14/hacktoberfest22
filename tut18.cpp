#include<iostream>
// Structures, Unions and typedef 

using namespace std;

typedef struct employee
{
    /* data */
    int eId;
    char favChar;
    float salary;
} ep;

//Unions are like structures but they provide a better memory management
union money{
      int rice;
      char car;
      float pounds;
      //pure me se only ek datatype ko use kr skte h memory ko apne hisaab se optimise krke jo ki C++ union ki madad se krke deta h
      //in teeno ka jo maximum h utni memory allocate ho jaa a gi cz use to koi ek hi krna h
};

int main(){

    // struct employee harry; // or ep harry;
    // struct employee Shubham; // or ep Shubham;
    // struct employee Rohan; // or ep Rohan;

    // harry.eId = 1;
    // harry.favChar = 'c';
    // harry.salary = 1200000000;

    // cout << "The value is " << harry.eId << endl;
    // cout << "The value is " << harry.favChar << endl;
    // cout << "The value is " << harry.salary << endl;
    


    union money m1;
    m1.rice = 34;
   // m1.car = 'c';
    cout << m1.rice << endl; // agr m1.car = 'c' krte h and m1.rice print krte h to hme garbage value milegi
    // but agr m1.car print krege to shii dega cz avii hm yhi use kr rhe h cz in teeno me se koi ek use kr skte h cz hmari memory share ki jaa rhi h

    

    enum Meal { breakfast, lunch, dinner};
    Meal p1 = lunch; // as Meal ek datatype bn chuka h
    //cout << m1; // to print m1 as numbers
    cout << (p1 == 1); // compare kr rhe h...as m1 = lunch ki value 1 h 2 nii isiliye output 0 hoga
    // cout << breakfast << endl;
    // cout << lunch << endl;
    // cout << dinner << endl;
    // enum ka use krke hm integer nos. de skte h usme jitni v values hogi usko --> prog zada readable hoga

    return 0;
}