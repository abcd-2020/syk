package step1;

import java.util.Scanner;

public class ������ {
	
	 static int temp(int start, int finish){
		    int num = 0; // �ݺ� Ƚ��
		    int need = finish - start; // �ʿ��� �µ�
		    
		    if(need < 0) need*= -1;
		    
		    while(true){
		        if(need >= 10){ // �ʿ��� �µ��� 10�� �̻�
		            need -= 10;
		            num++;
		        }else if(need >= 8){ // �ʿ��� �µ��� 8�� �̻��� ��� 10���� ���ϰ� 1���� ���°��� �ּ�Ƚ��
		            need -= 10;
		            num++;
		        }else if(need >= 5){ // �ʿ��� �µ��� 5�� �̻�
		            need -= 5;
		            num++;
		        }else if(need >= 4){ // �ʿ��� �µ��� 4�� �̻��� ��� 5���� ���ϰ� 1���� ���°��� �ּ�Ƚ��
		            need -= 5;
		            num++;
		        }else if(need > 0){ // �ʿ��� �µ��� 1~3�� ���
		            need -= 1;
		            num++;
		        }else if(need == 0){ 
		            break;
		        }else{ // �ʿ��� �µ��� - �� ���
		            need += 1;
		            num++;
		        }
		        
		    }

		        return num; // Ƚ�� ��ȯ
		    }
		    
		    public static void main (String[] args) {
		        Scanner sc = new Scanner(System.in);
		        
		        System.out.println(temp(sc.nextInt(),sc.nextInt()));
		    }
		}