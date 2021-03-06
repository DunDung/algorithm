package baekjoon.exhaustive_search;

import java.util.*;
import java.io.*;

//N�� M (4)
public class Q15652 {
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		backTrack(0);
		System.out.print(sb.toString());
	}

	public static void backTrack(int cnt) {
		if(cnt==M) {
			for(int v : nums) {
				sb.append(v+" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=1; i<=N; i++) {
			if(cnt > 0 && i>=nums[cnt-1]) {
				nums[cnt] = i;
				backTrack(cnt+1);
			}
			if(cnt == 0) {
				nums[cnt] = i;
				backTrack(cnt+1);
			}
		}
	}
}