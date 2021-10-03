package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1010 {
    // https://www.acmicpc.net/problem/1010
    // 소요시간 >>
    // 22:32 ~ 11:54 (1시간 22분)

    // 아이디어 >>
    // dp[n][m]을 [n][m]으로 표현하면 해당 문제는 다음과 같은 규칙을 갖는다.
    // [3][6] = [2][5]+[2][4]+[2][3]+[2][2];
    // [3][5] = [2][4]+[2][3]+[2][2];
    // => [3][6] = [2][5] + [3][5];
    // => [n][m]=[n][m-1]+[n-1][m-1]


    // 에러로그 >>
    // X


    // Attribute
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] dp;
    private static int n,m;


    // Main
    public static void main(String[] args) throws IOException{
        int testCase =  Integer.parseInt(reader.readLine());
        for (int i=0;i<testCase;i++){
            initialize();
            logic(n,m);
            output();

        }
    }

    public static void initialize() throws IOException{
        // Input
        String[] line = reader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        // Initialize
        dp = new int[30][30]; // [n][m] or [서쪽][동쪽]

    }

    // Logic
    public static int logic(int i, int j){
        if(dp[i][j]!=0)
            return dp[i][j];
        else if (i==0 || i==j)
            dp[i][j]=1;
        else
            dp[i][j] = logic(i,j-1)+ logic(i-1,j-1);

        return dp[i][j];
    }


    // Output
    public static void output(){
        System.out.println(dp[n][m]);

    }
}
