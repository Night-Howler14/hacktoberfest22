// Code to find count of substring of length k with k-1 distinct elements

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
  
    int check(int hsh[], int k){
        int flag=1;
        int ones =0, twoes=0;
        for(int i=0;i<26;i++){
            if(hsh[i]==0 || hsh[i]==1 || hsh[i]==2){
                if(hsh[i]==1) ones++;
                if(hsh[i]==2) twoes++;
            }
            else{
                flag =0;
                break;
            }
        }
        if(flag && ones==k-2 && twoes==1){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    int countOfSubstrings(string s, int k) {
        // code here
        int n=s.size();
        if(k==1){
            return 0;
        }
        int hsh[26];
        for(int i=0;i<26;i++){
            hsh[i]=0;
        }
        int count=0;
        
        for(int i=0;i<k;i++){
            hsh[s[i]-'a']++;
        }
        if(check(hsh, k)){
            count++;
        }
        for(int i=k;i<n;i++){
            hsh[s[i]-'a']++;
            hsh[s[i-k]-'a']--;
            if(check(hsh, k))
            count++;
        }
        return count;
    }
};

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        int K;
        cin>>S;
        cin>>K;

        Solution ob;
        cout << ob.countOfSubstrings(S,K) << endl;
    }
    return 0;
}