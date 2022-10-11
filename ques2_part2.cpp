// N Queens Problem

#include <bits/stdc++.h>
using namespace std;

int n;
int queens[20];// queens[i] stores position of queen in the ith row

void display(){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(j==queens[i])
            cout<<'Q'<<" ";
            else
            cout<<'X'<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}

bool check(int row, int col){
    for(int i=0;i<row;i++){
        int prow=i;
        int pcol=queens[i];

        if(col==pcol)
        return 0;
    }
    return 1;
}

int rec(int level){//rec->no of ways to populate {level....n-1} rows for a valid configuraion.
    //level-> current row in which we are placing the queen 

    //pruning

    //basecase
    if(level==n){
        display();      //printing the valid configuration of queens
        return 1;       //we generally return 1 or 0 for counting problems in base case
    }  

    int ans=0;
    //looping over all choices
    for(int col=0;col<n;col++){
        //checking for valid choice
        if(check(level, col)){
            //placeing the queen
            queens[level]=col;
            //explore the option
            ans+=rec(level+1);
            //revert placing the queen
            queens[level]=-1;
        }
    }

    return ans;
}

void solve(){
    cout<<"Enter dimension of the chess board : "<<endl;
    cin>>n;
    memset(queens, -1, sizeof(queens));
    int count = rec(0);
    if(count==0){
        cout<<"No Solution Exists!"<<endl;
    }
    else{
        cout<<"No of possible solutions : "<<count<<endl;
    }
}

int main(){
    int T;
    T=1;
    //cin>>T;
    while(T--){
        solve();
    }
    return 0;
}