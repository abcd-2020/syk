package step1;

import java.util.Arrays;

public class 최대값과최솟값 {
	 public String solution(String s) {
	        String answer = "";
	        String[] array = s.split(" ");   
	        
	        int[] nums = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
	        int min = nums[0];
	        int max = nums[0];
	        
	        Arrays.sort(nums);
	        min=nums[0];
	        max=nums[nums.length-1];
	        String min1 = Integer.toString(min);
	        String max2 = Integer.toString(max);
	        answer = min1+" "+ max2;
	       
	        return answer;
	    }
	 
	 
	}

