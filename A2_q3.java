import java.util.*;
public class A2_q3 {
	 public static void main(String[] args) {
		 Scanner input= new Scanner(System.in);     
		 System.out.println("Enter the size of an array  ");  
		 int a= input.nextInt(); 
		 int []students= new int[a];
		 for(int i=0 ; i<a ; i++) {
			 students[i]= input.nextInt(); 
		
		 }
		 System.out.printf("output:\n");
		 for(int i=0; i<a; i++){
		        int counter = 0;
		        for(int j=0; j<i; j++){
		            if (students[j] > students[i]){
		                counter += 1;
		            }
		            
		        }
		        	System.out.print(counter+" ");
		    }
		 
	 }
	}