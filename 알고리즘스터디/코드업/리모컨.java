package step1;

import java.util.Scanner;

public class 리모컨 {
	
	 static int temp(int start, int finish){
		    int num = 0; // 반복 횟수
		    int need = finish - start; // 필요한 온도
		    
		    if(need < 0) need*= -1;
		    
		    while(true){
		        if(need >= 10){ // 필요한 온도가 10도 이상
		            need -= 10;
		            num++;
		        }else if(need >= 8){ // 필요한 온도가 8도 이상일 경우 10도를 더하고 1도를 빼는것이 최소횟수
		            need -= 10;
		            num++;
		        }else if(need >= 5){ // 필요한 온도가 5도 이상
		            need -= 5;
		            num++;
		        }else if(need >= 4){ // 필요한 온도가 4도 이상일 경우 5도를 더하고 1도를 빼는것이 최소횟수
		            need -= 5;
		            num++;
		        }else if(need > 0){ // 필요한 온도가 1~3일 경우
		            need -= 1;
		            num++;
		        }else if(need == 0){ 
		            break;
		        }else{ // 필요한 온도가 - 인 경우
		            need += 1;
		            num++;
		        }
		        
		    }

		        return num; // 횟수 반환
		    }
		    
		    public static void main (String[] args) {
		        Scanner sc = new Scanner(System.in);
		        
		        System.out.println(temp(sc.nextInt(),sc.nextInt()));
		    }
		}