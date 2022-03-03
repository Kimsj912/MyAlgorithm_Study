package implement;

import java.io.*;

public class BOJ1157 {
    // https://www.acmicpc.net/problem/1157

    // 소요시간 >>
    // 2시간
    // 오랜만에 빠르게 푼다는게 최적의 방법을 탐색하다가 오래 걸림... 단순하지만 비효율적인 방식으로 하고싶지않았다.

    // 아이디어 >>
    // A~Z : 65 ~ 90 (총 26개)
    // a~z : 97 ~ 122 (총 26개)
    // ? : 63
    // => A ~ z : 총 52
    // 대문자 인덱스에 맞춘 배열(A는 65로, 입력받은 값-65를 하여 arr의 0번 인덱스에 저장됨)에 그 수를 저장하고
    // 가장많은 문자의 수를 max로 업데이트하며 가장 많은 문자를 ans에 저장한 뒤 출력한다.

    // 에러로그 >>
    // X (백준 기록은 컴파일 실수 혹은 값 받아오는 부분 미개선 때문이다)

    // 개선과정 >>
    // 입력방식 변경 - 기존에 자주쓰던 BufferedReader 대신에 char를 가져오는데 적합한 System.in.read()로 변경
    // => 메모리 24204 -> 14152 / 시간 300 -> 164
    // arr의 개수 세는 법 변경 - arr.length로 for문을 돌때 회전 수를 결정하다가 알파벳 대문자의 수인 26으로 고정
    // => 메모리 동일 / 시간 164 -> 160

    public static void main(String[] args) throws IOException{
        // Input
        int[] arr = new int[26]; // 각 알파벳의 수를 담을 배열
        int ch = System.in.read(); // 입력받은 char를 임시 저장해나감.
        do arr[ch>=97 ? ch-97 : ch-65]++; // 대소문자 여부 판단하여 각 알파벳 수를 증가해나감.
        while((ch=System.in.read())>64);

        // Logic
        char ans = 0; // 정답
        int max = 0; // 가장 많은 알파벳의 개수
        for(int idx = 0; idx<26; idx++){
            if(max<arr[idx]){ // 해당 idx의 알파벳 수가 이전 최대 알파벳 수보다 클경우 max와 ans를 변경시킴.
                max = arr[idx];
                ans = (char)(idx+65);
            } else if( max == arr[idx]) ans='?'; // 해당 idx의 알파벳 수가 이전 최대 알파벳 수와 동일할 경우 ans를 ?로 변경
        }

        // Output
        System.out.println(ans);
    }
}
