import java.util.*;
public class array {
    public static void main(String[] args)
    {
        int[] arr = new int[5];
        arr[0]=15;
        arr[1]=12;
        arr[2]=56;
        arr[3]=100;
        arr[4]=65;
        System.out.println("Enter any number : ");
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        if (i<5)
        {
        System.out.println(arr[i]);
        }
        else 
        {
        System.out.println("Invalid number");
        }
    }
}
