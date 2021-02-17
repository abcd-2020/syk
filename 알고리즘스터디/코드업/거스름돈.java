package step1;

import java.util.Scanner;

public class °Å½º¸§µ· {

	public static void main(String[] args) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		int sum = 0;
		while (n>=50000) {
			n=n-50000;
			sum++;
		}
		while (n>=10000) {
			n=n-10000;
			sum++;
		}
		while (n>=5000) {
			n=n-5000;
			sum++;
		}
		while (n>=1000) {
			n=n-1000;
			sum++;
		}
		while (n>=500) {
			n=n-500;
			sum++;
		}
		while (n>=100) {
			n=n-100;
			sum++;
		}
		while (n>=50) {
			n=n-50;
			sum++;
		}
		while (n>=10) {
			n=n-10;
			sum++;
		}System.out.println(sum);

	}

}
