import java.util.*;

public class stock {
    public static int[] MCS(int arr[], int low, int mid, int high) {
        int brr[] = new int[3];
        int suml = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + arr[i];
            if (sum > suml) {
                suml = sum;
                brr[0] = i;
            }
        }
        sum = 0;
        int sumr = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + arr[i];
            if (sumr < sum) {
                sumr = sum;
                brr[1] = i;
            }
        }
        brr[2] = sumr + suml;
        return brr;

    }

    public static int[] maxsub(int[] arr, int low, int high) {
        int[] brr = new int[3];
        if (high == low) {
            brr[0] = low;
            brr[1] = high;
            brr[2] = arr[low];
            return brr;
        }
        int[] lt = new int[3];
        int[] rt = new int[3];
        int[] cr = new int[3];
        int mid;
        mid = (high + low) / 2;
        lt = maxsub(arr, low, mid);
        rt = maxsub(arr, mid + 1, high);
        cr = MCS(arr, low, mid, high);
        if (lt[2] > rt[2] && lt[2] > cr[2]) {
            return lt;
        } else if (rt[2] > lt[2] && rt[2] > cr[2]) {
            return rt;
        } else {
            return cr;
        }

    }

    public static void main(String args[]) {
        int s[] = new int[100];
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        int k = 0;
        int d[] = new int[1000];

        for (int i = 1; i < n; i++) {
            d[k] = s[i] - s[i - 1];
            k++;
        }

        int b[] = new int[3];
        b = maxsub(d, 0, n - 2);
        System.out.printf("Buy at %d\n", s[b[0]]);

        System.out.printf("Sell at %d", s[b[1] + 1]);

        System.out.printf("\nThe maximum sum is %d", b[2]);
    }

}
