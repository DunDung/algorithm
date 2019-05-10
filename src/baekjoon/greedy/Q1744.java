package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//�� ����
//0�� ���� �� ���� -�� 0���� ó��
//���� �� ����� ū������ ����
//������ ���� �� ���� ���´�.
public class Q1744 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] a = new int[n];
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<n; i++){
			a[i] = scan.nextInt();
		}

		Arrays.sort(a);
		boolean zero = false;
		for(int i=n-1; i>=0; i--) {
			if(a[i]>0) {
				if(i-1 >= 0 && a[i-1]>1 && a[i]>1)
					list.add(a[i--] * a[i]);
				else
					list.add(a[i]);
			}
			else if(a[i] == 0) {
				zero = true;
				break;
			}
			else
				break;

		}
		for(int i=0; i<n; i++){
			if(a[i]<0) {
				if(i+1<n && a[i+1]<0)
					list.add(a[i++] * a[i]);
				else {
					if(!zero)
						list.add(a[i]);
				}
			}
			else 
				break;
		}

		int ans = 0;
		for(int i=0; i<list.size(); i++){
			ans +=list.get(i);
		}
		System.out.println(ans);

	}

}
