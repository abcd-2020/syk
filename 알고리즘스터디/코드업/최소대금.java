package step1;

import java.util.Scanner;

public class 최소대금 {

	static float min(int[] a) { //최소값 반환하는 메소드
		int min_num = a[0];
		for(int i = 0; i<a.length; i++) {
			if (min_num>a[i]) min_num=a[i];
		}
		return min_num;
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] pasta = new int[3];
	int[] juice = new int[2];
	
	for (int i=0; i<3; i++) {
		pasta [i] = sc.nextInt();
	}
	for (int i=0; i<2; i++) {
		juice[i]=sc.nextInt();
	}
	float pasta_min = min(pasta);
	float juice_min = min(juice); //소수점1자리까지 출력-String.format 
	System.out.println(String.format("%.1f", (pasta_min + juice_min)*1.1));
	}
}
