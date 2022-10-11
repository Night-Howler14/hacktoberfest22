import java.util.*;

public class flyods_triangle {
    public static void main(String args[]){
        System.out.println("Enter the number n");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(k+1+" ");
                k++;
            }
            System.out.println();
        }
    }
    
}
