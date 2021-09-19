package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1002 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase ; i++){
            String[] orgStr = br.readLine().split(" ");

            int x1 = Integer.parseInt(orgStr[0]);
            int y1 = Integer.parseInt(orgStr[1]);
            int r1 = Integer.parseInt(orgStr[2]);
            int x2 = Integer.parseInt(orgStr[3]);
            int y2 = Integer.parseInt(orgStr[4]);
            int r2 = Integer.parseInt(orgStr[5]);


            // r1>r2로 가정한 결과이기 떄문에
            if(r1<r2){
                int tmp = r1;
                r1=r2;
                r2=tmp;
            }
            double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            int ans = 0;// 만남 X(멀리 떨어짐(d>r1+r2), 포함됨(d<r1-r2))
            if(d==r1+r2) ans = 1; // 외접
            else if(d==r1-r2 && d!=0) ans = 1; // 내접 ( d==0이면 포함임)
            else if(r1-r2 < d && d<r1+r2) ans = 2; // 두점 교차
            else if(d==0 && r1==r2) ans=-1; // 일치

            System.out.println(ans);
        }
    }
}
