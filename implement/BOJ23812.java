package implement;

import java.util.*;
import java.io.*;

public class BOJ23812{
    // https://www.acmicpc.net/problem/23812

    // 소요시간 >>
    // 15분 (랜덤문제고 조금만 생각하면 바로 풀 수 있어서 가볍게 풀었다.)

    // 아이디어 >>
    // 뒤집힌 ㅍ모양의 boolean 배열을 만들어서 boolean배열과 n의 크기에 따른 for문을 중첩시켜 값을 출력하도록 한다.
    
    // 에러로그 >>
    // X

    // 개선과정 >>
    // * shape을 모든 ㅍ에 맞춰 모두 적었다가 반복되는 부분이 있어 이를 간략화함.
    // => 메모리 15768 -> 15976 / 시간 192 -> 184
    // * shape을 지역변수로 만들어 넣었음. (원상복구)
    // => 메모리 15976 -> 16540 / 시간 184 -> 196
    // * bw.append에 들어가는 문자를 문자열("")에서 문자('')로 변경 (1등 오예!!)
    // => 메모리 15976 -> 15280 / 시간 184 -> 156
    // * 숏코딩용으로 괄호를 다 줄임. (원상복구)
    // => 메모리 15280 -> 15104 / 시간 156 -> 164
    // * if문 대신 삼항연산자를 사용 (원상복구)
    // => 메모리 15280 -> 15292 / 시간 156 -> 160

    private final static boolean[][] shape = {{true,true,true,true,true},{true,false,false,false,true}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=5;i++){
            for(int row=0;row<n;row++){
                for(boolean b : shape[i%2]){
                    for(int col=0;col<n;col++){
                        if(b) bw.append('@');
                        else bw.append(' ');
                    }                
                }
                bw.append('\n');
            }
        }
        bw.flush();
    }

    // 숏코딩용으로 줄여봤을 때
    //    public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     for(int i=1;i<=5;i++) for(int row=0;row<n;row++){ for(boolean b : shape[i%2]) for(int col=0;col<n;col++) bw.append(b?'@':' '); bw.append('\n');}
    //     bw.flush();
    // }
}