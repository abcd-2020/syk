package step1;

import java.util.Arrays;

public class 최솟값만들기 {

	public static int solution(int []A, int []B)
    {
        int answer = 0;	        
        int j = B.length-1;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=0; i<A.length; i++) {
        	answer=answer+(A[i]*B[j]);
        	j--;
        }

        return answer;
    }
	
	
}