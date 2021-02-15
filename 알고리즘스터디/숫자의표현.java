package step1;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++ ) {
        	answer += dfs(n, i, 0);
        }
        return answer;
    }
    
    public static int dfs(int n, int start, int sum) {
    	if (sum>=n) return n==sum?1:0;
    	return dfs(n, start+1, sum+start);
    }
    
    
}