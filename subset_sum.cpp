#include<bits/stdc++.h>
using namespace std;

void subsetsum(int i ,int sum ,vector<int>&a,int n,vector<int>&sumsubset){
    //base
    if(i == n)
    {
        sumsubset.push_back(sum);
        return;
    }
    
    //pick
    subsetsum(i+1,sum+a[i],a,n,sumsubset);

    //not pick
    subsetsum(i+1,sum,a,n,sumsubset);

}

vector<int>subsetsums(vector<int>a,int n)
{
    vector<int>sumsubset;
    subsetsum(0,0,a,n,sumsubset);
    sort(sumsubset.begin(),sumsubset.end());
    return sumsubset;
}


int main()
{
    int n;
    cin>>n;
    vector<int>v;
    int x;
    for (int i = 0; i < n; i++)
    {
        cin>>x;
        v.push_back(x);
    }

    vector<int>ans=subsetsums(v,n);
    for(auto it:ans)
    {
        cout<<it<<" ";
    }
    cout<<endl;
    return 0;
}
