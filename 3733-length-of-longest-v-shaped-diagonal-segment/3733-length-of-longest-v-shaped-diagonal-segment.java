class Solution {
    int[][] dirs={{-1,1},{1,1},{1,-1},{-1,-1}};
    int m,n; int[][] g;
    
    public int lenOfVDiagonal(int[][] grid){
        g=grid; m=g.length; n=g[0].length; int ans=0;
        for(int i=0;i<m;i++)for(int j=0;j<n;j++)
            if(g[i][j]==1)
                for(int d=0;d<4;d++)
                    ans=Math.max(ans,dfs(i,j,d,2,false));
        return ans;
    }

    int dfs(int i,int j,int dir,int val,boolean turned){
        int x=i+dirs[dir][0],y=j+dirs[dir][1];
        if(x<0||y<0||x>=m||y>=n||g[x][y]!=val) return 1;
        int next=(val==2?0:2);
        int best=1+dfs(x,y,dir,next,turned);
        if(!turned) best=Math.max(best,1+dfs(x,y,(dir+1)%4,next,true));
        return best;
    }
}
