package step1;



public class 카펫 {
	  public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int sum = brown + yellow; 
	        double sqrt = Math.sqrt(sum); //제곱근 구하기
	        int a = (int) sqrt; 
	        int b = sum/a; //a*b== sum && a-2 * b-2 == yellow여야 함
	        if((a*b!= sum) || (a-2) * (b-2) != yellow) {
	        	while (a>=1) {
	        		a = a-1;
	        		if (sum % a ==0) {
	        			b = sum/a;
	        			if ((a*b == sum)&&((a-2)*(b-2)==yellow)) {
	        				break;
	        			}
	        		}
	        	}
	        }
	        	if (a>=b) {
	        		answer[0] = a;
	        		answer[1] = b;
	        	}else {
	        		answer[0] = b;
	        		answer[1] = a;
	        	}
	        return answer;
	    }
	}