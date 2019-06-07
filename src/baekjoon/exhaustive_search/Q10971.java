package baekjoon.exhaustive_search;

import java.util.Scanner;

//���ǿ� ��ȸ2
//X
public class Q10971 {
	static void swap(int [] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static boolean nextPermutation(int [] a) {
		int i = a.length-1;
		while(i > 0 && a[i] <= a[i-1])
			i--;

		if(i<=0)
			return false;

		int j = a.length-1;
		while(a[j] <= a[i-1]) {
			j--;
		}

		swap(a, i-1, j);

		j = a.length-1;
		while(i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [][] a = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = scan.nextInt();

		int [] d = new int[n-1];
		//0������ �̵��ϴ� ���� ������ �̵��� �ʱ�ȭ
		for(int i=0; i<n-1; i++) {
			d[i] = i+1;
		}
		int ans = Integer.MAX_VALUE;
        do {
            boolean ok = true;
            int sum = 0;
            //0������ �̵��ϴ� ���� �����߱� ������ -1, ���ϴ� ���� i+1�� �ֱ� ������ -1 => n-2�� �ȴ�.
            for (int i=0; i<n-2; i++) { 
                if (a[d[i]][d[i+1]] == 0) { //������ ������ �� false
                    ok = false;
                } else {
                    sum += a[d[i]][d[i+1]];
                }
            }
			//������ ���ð� ������ 0��° ���ÿ��� ù ��° ���÷� ���� 0�� �ƴϰ� ������ ���ÿ��� 0��° ���÷� ���� 0�� �ƴϸ�
            if (ok && a[0][d[0]] != 0 && a[d[n-2]][0] != 0) { 
                sum += a[0][d[0]] + a[d[n-2]][0]; //0°������ ù ��°�� ���� ��� + ���������� 0��°�� ���� ���
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while(nextPermutation(d));

        System.out.println(ans);
	}

}