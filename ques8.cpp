#include <bits/stdc++.h>
using namespace std;

int binarySearch(vector <int> &d, int element){
    int low = 0, high = d.size()-1;
    int mid;
    while(high-low>1){
        mid = (high+low)/2;
        if(d[mid]>element)
        high=mid-1;
        else
        low=mid;
    }
    if(d[high]<=element)
    return high;
    else if(d[low]<=element)
    return low;
    else
    return -1;
}

int main(){
    cout<<"Enter number of petrol pumps : "<<endl;
    int n;
    cin>>n;
    cout<<"Enter the distances of each petrol pump : "<<endl;
    vector <int> distance;
    int d;
    for(int i=0;i<n;i++){
        cin>>d;
        distance.push_back(d);
    }
    cout<<"Enter fuel capacity of the car : "<<endl;
    int capacity;
    cin>>capacity;

    sort(distance.begin(), distance.end());           //sorting distances in increasing order
    
    bool flag = 1;
    for(int i=1;i<n;i++){
        if(distance[i]-distance[i-1]>capacity){
            flag=0;
            break;
        }
    }

    if(flag==0){
        cout<<"Not possible to reach Kolkata from Bongora."<<endl;
    }
    else{
        int pos = 0;        //stores index for last petral pump used
        int count=0;        //stores number of petrol pumps visited
        cout<<"Positions of petrol pumps visited : "<<endl;
        while(pos!=n-1){
            cout<<distance[pos]<<" ";
            pos=binarySearch(distance, distance[pos]+capacity);
            count++;
        }
        cout<<endl;
        cout<<"Minimum number of stops (for filling petrol) : "<<count<<endl;
    }

    return 0;
}