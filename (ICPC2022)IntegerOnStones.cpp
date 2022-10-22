#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef map<int,int> mii;
typedef unordered_map<int,int> umii;
typedef priority_queue <int> pque;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vpii;
typedef vector<vi> vvi;
#define rep(i,b) for(int i=0;i<b;i++)
#define REP(i,a,b) for(int i=a;i<=b;i++)
#define REPR(i,a,b) for(int i=a;i>=b;i--)
#define prefixSum(a,pre,n) pre[0]=a[0]; for(int i=1;i<n;i++) pre[i]=pre[i-1]+a[i];
#define suffixSum(a,suf,n) suf[n-1]=a[n-1]; for(int i=n-2;i>=0;i--) suf[i]=suf[i+1]+a[i];
#define all(v) v.begin(), v.end()
#define lb lower_bound
#define ub uppper_bound
#define fi first
#define se second
#define pb push_back
#define MP make_pair
#define res(i) cout << "Case #" << i << ": "

const int M = 1e9+7;


ll binExpIter(ll a, ll b, ll m){
    ll ans=1;
    while(b){
        if(b&1){
            ans=(ans * 1LL * a)%m;
        }
        a=(a * 1LL * a)%m;
        b>>=1;
    }
    return ans;
}

void solve(){
    ll a, n;
    cin >> a >> n;
    n/=2;
    if(a<0) cout<< 1 <<"\n";
    else cout<< binExpIter(a,n, M)<<"\n";

}

int main(){

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>> t;
    while(t--){
        //res(i);
        solve();
    }
    return 0;
}