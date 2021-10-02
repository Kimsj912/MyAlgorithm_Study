package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1009 {

    // https://www.acmicpc.net/problem/1009

    // 소요시간 >>
    // 1시간 30분 (아이디어 생각과정이 오래걸렸다. 수학유형은 구현보다 생각과정이 오래걸리는 거 같다.)

    // 아이디어 >>
    // 1번 ->
    // ###이든 ##이든 #이든 맨 마지막 숫자에 따라 10의 나머지는 달라진다.
    // 또한 반목적으로 값이 나타난다(ex. 5는 무조건 맨뒷자리가 5, 6도 맨 뒤자리가 6)
    // (ex2. 3은 맨 뒤자리가 1,3,9,7을 반복하고 7은 1,7,9,3을 반복한다.)
    // 이를 이용하여 맨 처음에 1~10의 10까지의 반복을 찾은 뒤,
    // a와 맞는 반복배열을 가져와 b로 나눈 나머지를 출력한다.

    // 2번 ->
    // 상황 ->
        // 1번은 예시로는 통과하지만 그 이외의 수로는 문제가 생겼다.
        // 그래서 기본적인 방식으로 계산을 해 구해보려 했지만, 수의 범위를 자꾸 초과했다.
        // (long으로 바꿨음에도 Math.pow를 사용하면 값의 범위를 초과한다.)
    // 해결
        // for로 하나하나 곱해나가도록 했다.
        // 그 과정에서 계속 10으로 나눠주면 나머지값은 변하지않지만 범위를 초과하지 않는다.
        // 정답을 출력할때 컴퓨터는 1~10번으로 존재하기 때문에 0번일 경우 10번 컴퓨터로 출력하도록 했다.

    // 에러로그 >>
    // 2번의 상황->과 같다.


    // Attribute
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException{
        // Input
        int testCase = Integer.parseInt(reader.readLine());
        for(int i=0; i<testCase; i++){
            String[] strs = reader.readLine().split(" ");
            int a = Integer.parseInt(strs[0]); // 밑
            int b = Integer.parseInt(strs[1]); // 지수

            // Initialize
            int ans = 1;

            // Logic
            for(int j=0;j<b;j++){ ans=(ans*a)%10; }

            // Output
            System.out.println(ans==0?10:ans);

        }
    }
}
