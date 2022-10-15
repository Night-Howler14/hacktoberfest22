#include<bits/stdc++.h>
using namespace std;

void dfs(int node,vector<int>adj[],int visited[],vector<int>&list)
{
    visited[node]=1;
    list.push_back(node);

    for(auto it:adj[node])
    {
        if(!visited[it])
        {
            dfs(it,adj,visited,list);
        }
    }
}

vector<int>dfsofgraph(int v,vector<int>adj[])
{
    int visited[v];
    for (int i = 0; i < v; i++)
    {
        visited[i]=0;
    }
    
    int start=0;  
    vector<int>list;
    dfs(start,adj,visited,list);

    return list;
}

int main()
{
    int n,m;
    cin>>n>>m;
    vector<int>adj[n];
    for (int i = 0; i < m; i++)
    {
        int u,v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int>ans =dfsofgraph(n,adj);

    for (int i = 0; i < ans.size(); i++)
    {
        cout<<ans[i]<<"---";
    }

    return 0;
}