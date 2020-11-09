package com.duanxuehan.liantongfenlianggeshu05;

import com.duanxuehan.liangtongfenliang04.Graph;

public class CC {
    // 求解联通分量的个数

    private Graph G;
    private int[] visited;
    private int cccount = 0;

    public CC(Graph G){

        this.G = G;
        visited = new int[G.V()];
        for(int i = 0; i < visited.length; i ++)
            visited[i] = -1;

        for(int v = 0; v < G.V(); v ++)
            if(visited[v] == -1){
                dfs(v, cccount);
                cccount ++;
            }
    }

    private void dfs(int v, int ccid){

        visited[v] = ccid;
        for(int w: G.adj(v))
            if(visited[w] == -1)
                dfs(w, ccid);
    }

    public int count(){
        for(int e: visited)
            System.out.print(e + " ");
        System.out.println();
        return cccount;
    }

    public static void main(String[] args){

        Graph g = new Graph("g1.txt");
        CC cc = new CC(g);
        System.out.println(cc.count());
    }
}
