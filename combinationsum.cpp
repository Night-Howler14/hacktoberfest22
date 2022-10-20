#include <bits/stdc++.h>
using namespace std;
// arr= [2,3,6,7] , target=7 you have to find all the combination whose sum of elements is equal to target
// ans=[2,2,3] , [7] 

void findcombination(int index,int target,vector<int> &arr,vector<vector<int>> &ans,vector<int> &ds){
	if (index==arr.size())
	{
		if (target==0)
		{
			ans.push_back(ds);
		}
		return;
	}
	if(arr[index]<=target){
		ds.push_back(arr[index]);
		findcombination(index,target-arr[index],arr,ans,ds);
		ds.pop_back();
	}
	findcombination(index+1,target,arr,ans,ds);
}


vector<vector<int>> combinationsum(vector<int> &arr,int target){
	vector<vector<int>> ans;
	vector<int> ds;
	findcombination(0,target,arr,ans,ds);
	return ans;
}

int main(){

	int n,x;
	cin>>n;
	vector<int> arr;

	for (int i = 0; i < n; ++i)
	{
		cin>>x;
		arr.push_back(x);
	}

	int target;
	vector<vector<int>> ans=combinationsum(arr,target);

	for (int i = 0; i < ans.size(); ++i)
	{
		for (int j = 0; j <ans[i].size() ; ++j)
		{
			cout<<ans[i][j]<<" ";
		}
		cout<<endl;
	}

}