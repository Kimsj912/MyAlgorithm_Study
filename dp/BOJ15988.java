package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    // https://www.acmicpc.net/problem/15988

    // 소요시간 >>
    // 1시간

    // 아이디어 >>
    // 9095랑 매우 흡사해보임

    // 에러 로그 >>
    // 틀렸습니다 -숫자가 너무 커서 long으로 해줘야할 덧 같다.
    // 시간초과 - 쓸데없이 -1을 먼저 넣어줌. long문제 해결하면서 기본값인 0보다 원래 다 큰데 이를 혹시나 하는 마음으로 -1로 넣으면서
    // 불필요한 for문을 돌려버림.
    // 시간초과 - 1000000이 넘는 값을 테스트 케이스마다 새로 돌아서 시간이 오래걸림. 테스트 케이스의 값이 어떻든 dpline[]은 동일하니
    // 재탕할 수 있도록 new하는 부분을 for문 전에 미리 빼둠.



    private static long[] dpline;

    private static long func(int indexNum) {
        if(dpline[indexNum]!=0) return dpline[indexNum];
        else {
            dpline[indexNum] = (func(indexNum-1)+func(indexNum-2)+func(indexNum-3))%1000000009;
            return dpline[indexNum];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(reader.readLine());

        dpline = new long[1000001]; //숫자로 인덱스를 쓰려고 함.
        dpline[1] = 1;
        dpline[2] = 2;
        dpline[3] = 4;

        for (int i=0;i<T;i++){
            int n =Integer.parseInt(reader.readLine());
            System.out.println(func(n));
        }
    }

}
