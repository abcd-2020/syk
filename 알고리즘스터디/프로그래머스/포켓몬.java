package step1;

import java.util.HashSet;

public class Æ÷ÄÏ¸ó {

	public int solution(int[] nums) {
        int answer = 0;
     HashSet<Integer>set = new HashSet<Integer>();
     
     for (int i = 0; i < nums.length; i++) {
    	 set.add(nums[i]);
     }
     
     if (set.size()==nums.length/2) {
    	 answer = set.size();
     }
     else if (set.size()>nums.length/2) {
    	 answer = nums.length/2;
     }
     else if (set.size()<nums.length/2) {
    	 answer = set.size();
     }
        
       return answer; 
   } 
}