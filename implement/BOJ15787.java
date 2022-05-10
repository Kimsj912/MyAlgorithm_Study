package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15787 {
    // https://www.acmicpc.net/problem/15787
    // �̹����� ��Ʈ����ŷ�� ������ �����ֱ俣 ���� ���� �������� �� ����.
    // ��Ʈ����ŷ�� ������ ���� ������ ������ ũ�� �������� Ǯ �� �ִ� �ǹ� �ܰ��� �����̴�.
    // (�޸� 38736 �ð� 396���� ���� Java11���� 8/79��)

    // �ҿ�ð� >>
    // 1�ð� 30�� (��Ʈ����ŷ �����̶� ������ �̼��ߴ�.)

    // ���̵�� >>
    // 0) n�� m�� �Է¹��� �� m�ٿ� ���� �����ڵ�[code], ������ȣ[t], (1,2�ڵ��� ��� �°��¼�[p])�� ������ �����Ѵ�.
    // 1) ���ۿ� ���� ��Ʈ�� �̵���Ų��.
    //  // 1�� �ڵ� = ���� t�� �¼� p�� �°��� �¿�� = trains[t]�� ������ p��° ��Ʈ�� 1�� ����
    //  // 2�� �ڵ� = ���� t�� �¼� p�� �°��� ������ = trains[t]�� ������ p��° ��Ʈ�� 0�� ����
    //  // 3�� �ڵ� = ���� t�� �°��� �ڷ� �δ� = trains[t]�� ������ ��Ʈ�� ���ڸ��� <<�� �о��
    //  // 4�� �ڵ� = ���� t�� �°��� ������ �δ� = trains[t]�� ������ ��Ʈ�� ���ڸ��� >>�� �о��
    // 2) Set�� trains���� ���� ���� ��� �ߺ� �����ϰ� �� ���� ����Ѵ�.
    //  // Set�� �ߺ����X + ���� ��� X�� �ڷᱸ������ �̿�

    // �����α� >>
    // Ʋ�Ƚ��ϴ� - �ڸ����� 20�� �Ѱų� 1�� �Ѵ� �κп� ���� ó���� ���� �ʾҴ�.

    // ��������
    // * switch������ ®�ٰ� �Ŀ� if������ �ٲ�.
    // => �޸� 38580 -> 38736 / �ð� 396 -> ����
    // => ���� ������ �񱳸� �ϴ� ��� if���� switch�� �� ȿ�������� �� �� �־���.
    // * HashSet��� Set�� ���
    // => �޸� 38580 -> 39124 / �ð� 396 -> 404
    // => HashSet�� Set���� �޸������ε� �ð������ε� �� ȿ�����̾���.
    public static void main(String[] args) throws IOException{
        // Input & Initialize
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()); // ������ ��
        int m = Integer.parseInt(st.nextToken()); // ����� ��
        int[] trains = new int[n]; // �������� ���� �迭

        // Logic
        int code, t, p=0;
        for(int i=0;i<m;i++){
            // code = �ڵ�, t = ������ȣ, p = �¼���ȣ
            st = new StringTokenizer(reader.readLine());
            code = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken())-1;
            // �ڵ尡 1,2�� ��쿡�� p�� �޴´�.
            if(code<3) p = Integer.parseInt(st.nextToken());

            switch(code){
                case 1 :
                   // trains[t] += (int)Math.pow(2,(p-1)) �� ����.
                    trains[t] |= (1<<p-1);
                    break;
                case 2 :
                   // trains[t] -= (int)Math.pow(2,(p-1)) �� ����.
                    trains[t] &= ~(1<<(p-1));
                    break;
                case 3 :
                    // �°����� �ڷ� �δ�. (1001 -> 0100 ó�� ����)
                    trains[t] <<= 1;
                    trains[t] &= ((1<<20)-1);
                    break;
                case 4 :
                    // �°����� ������ �δ�. (1001 -> 0010 ó�� ����)
                    trains[t] >>= 1;
                    trains[t] &= ~0;
                    break;
            }
        }
        // Output
        HashSet<Integer> res = new HashSet<>();
        for(int val : trains) res.add(val);
        System.out.println(res.size());
    }
}
