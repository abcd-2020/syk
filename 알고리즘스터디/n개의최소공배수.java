package step1;



public class n�����ּҰ���� {
	public int solution(int[] arr) {
		int answer = 0; 	
		int lcm = arr[0];
		for (int i=1; i<arr.length; i++ ) { // 0���ε����� �������� ��� �ε����� �ּҰ������ ����
			lcm = getLcm(lcm, arr[i]);
		}
        return lcm;
    }
	
	public static int getGcd(int a, int b) {//�ִ�����
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}return a;
	}
	
	public static int getLcm(int a, int b) {//�ּҰ����
		return a * b/getGcd(a, b);
	}
}
