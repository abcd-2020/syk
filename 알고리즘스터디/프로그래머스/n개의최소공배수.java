package step1;



public class n개의최소공배수 {
	public int solution(int[] arr) {
		int answer = 0; 	
		int lcm = arr[0];
		for (int i=1; i<arr.length; i++ ) { // 0번인덱스를 기준으로 모든 인덱스와 최소공배수를 구함
			lcm = getLcm(lcm, arr[i]);
		}
        return lcm;
    }
	
	public static int getGcd(int a, int b) {//최대공약수
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}return a;
	}
	
	public static int getLcm(int a, int b) {//최소공배수
		return a * b/getGcd(a, b);
	}
}
