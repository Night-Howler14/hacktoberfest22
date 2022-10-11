#include <bits/stdc++.h>
using namespace std;

int max_profit=INT_MIN;
pair<int, int> splitpair = {-1, -1};
pair<int, int> bestpair = {-1, -1};

int farthestPairSplit(vector <int> &v, int low, int mid, int high){
    int min_price = INT_MAX;
    int max_price = INT_MIN;
    
    for(int i=low; i<= mid; i++){
        if(v[i]<min_price){
            min_price = v[i];
            splitpair.first = i;
        }
    }
    for(int i=mid+1; i<=high;i++){
        if(v[i]>max_price){
        max_price = v[i];
        splitpair.second = i;
        }
    }

    return (max_price-min_price);
}

int farthestPair(vector <int> &v, int low, int high){
    if(low>=high)
    return INT_MIN;
    
    else{
        int mid = (low+high)/2;
        int left_profit = farthestPair(v, low, mid);
        int right_profit = farthestPair(v, mid+1, high);
        int split_profit = farthestPairSplit(v, low, mid, high);
        
        if(split_profit>max_profit){
            max_profit=split_profit;
            bestpair.first = splitpair.first;
            bestpair.second = splitpair.second;
        }

        return max_profit;
    }
}

int main(){
    cout<<"Enter number of days : "<<endl;
    int days;
    cin>>days;
    cout<<"Enter price of stock for each day : "<<endl;
    vector <int> price;
    int p;
    for(int i=0;i<days;i++){
        cin>>p;
        price.push_back(p);
    }
    
    int maxprofit = farthestPair(price, 0, days-1);
    
    if(maxprofit>0){
        cout<<"Maximum Profit : "<<maxprofit<<endl;
        cout<<"Buy on day : "<<(bestpair.first+1)<<endl;
        cout<<"Sell on day : "<<(bestpair.second+1)<<endl;
    }
    else{
        cout<<"No way to make money during the "<<days<<" days."<<endl;
    }
    
    return 0;
}