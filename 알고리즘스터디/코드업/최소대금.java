package step1;

import java.util.Scanner;

public class �ּҴ�� {

	static float min(int[] a) { //�ּҰ� ��ȯ�ϴ� �޼ҵ�
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
	float juice_min = min(juice); //�Ҽ���1�ڸ����� ���-String.format 
	System.out.println(String.format("%.1f", (pasta_min + juice_min)*1.1));
	}
}
