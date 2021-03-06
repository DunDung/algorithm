package baekjoon.samsung;

import java.io.*;
import java.util.*;

//드래곤 커브
//X 힌트얻고 구현은 직접
public class Q15685 {
	static int[] tx = {1, 0, -1, 0};
	static int[] ty = {0, -1, 0, 1};
	static int[][] a = new int[101][101];

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
			List<Integer> dirList = getDir(d, g);
			for(int j=0; j<dirList.size(); j++) {
				int k = dirList.get(j);
				if(x+tx[k]>=0 && x+tx[k]<=100 &&y+ty[k]>=0 && y+ty[k]<=100) {
					a[x+tx[k]][y+ty[k]] = 1;
					x = x+tx[k];
					y = y+ty[k];
				}
			}
		}
		System.out.println(count());

	}
	public static List<Integer> getDir(int d, int g) {
		List<Integer> dirList = new ArrayList<>();
		dirList.add(d);
		for(int i=0; i<g; i++) {
			int size = dirList.size()-1;
			for(int j=size; j>=0; j--) {
				int k = (dirList.get(j)+1 > 3) ? 0 : dirList.get(j)+1;
				dirList.add(k);
			}
		}
		return dirList;
	}
	public static int count() {
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(a[i][j] == 1) {
					if(a[i+1][j]==1 && a[i+1][j+1]==1 && a[i][j+1]==1) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
class Dc{
	int x;
	int y;

	public Dc(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Dc other = (Dc) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


}
