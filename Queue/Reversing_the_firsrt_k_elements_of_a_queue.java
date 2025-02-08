import java.util.*;

public class Reversing_the_firsrt_k_elements_of_a_queue {
    static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;

        }
    }

    static boolean isInside(int X, int y, int N) {
        if(X  >= 1 && X <=  N && y >= 1 && y<= N)
        return true;
        return false;

    }
    static int minStepToReachTarget(
        int knightPos[], int targetPos[], int N){
            int dx[]  =  {-2,-1,1,2,-2,-1,1,2};
            int dy[]= {-1,-2,-2,-1,1,2,2,1};
c 

            Vector<cell> q = new Vector<>();
            q.add(new cell(knightPos[0],knightPos[1],0));
            cell t;
            int x,y;
            boolean visit[][] = new boolean[N+1][N+1];
            visit[knightPos[0]][knightPos[1]] = true;
            while (!q.isEmpty()) {
                t = q.firstElement();
                q.remove(0);
                if(t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;
                for(int  i=0; i<8;  i++){
                    x =t.x + dx[i];
                    y = t.y + dy[i];
                    if (isInside(x, y, N) && !visit[x][y]) {
                        visit[x][y] = true;
                        q.add(new cell(x, y, t.dis + 1));
                        }

                }
                
            }
            return Integer.MAX_VALUE;
        }
        public static void main(String[] args){
            int N = 30;
            
            
            int knightPos[] = { 1, 1 };
            int targetPos[] = { 30, 30 };
            System.out.println(
            minStepToReachTarget(
            knightPos, targetPos, N));
        }
}
