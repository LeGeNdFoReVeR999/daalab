package daalab;
import java.util.Scanner;

public class SumofSubset {
    static int[] set, x;
    static int d, n;
    static int count = 0;

    static void sumofsub(int s, int k) {
        int i;
        x[k] = 1;

        if (s + set[k] == d) {
            count++; // Fix: increment count
            if (count == 1) {
                System.out.println("The subsets with sum = " + d + " are:");
            }
            System.out.print("{ ");
            for (i = 1; i <= n; i++) {
                if (x[i] == 1) {
                    System.out.print(set[i] + " ");
                }
            }
            System.out.println("}");
        } else {
            if (s + set[k] < d && k + 1 <= n) {
                sumofsub(s + set[k], k + 1);
                x[k + 1] = 0;
            }
            if (k + 1 <= n && s + set[k + 1] <= d) {
                x[k] = 0;
                sumofsub(s, k + 1);
                x[k + 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int sum = 0, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        n = sc.nextInt();
        set = new int[n + 1];
        x = new int[n + 1];
        System.out.println("Enter the set of elements in increasing order:");
        for (i = 1; i <= n; i++) { // Fix: changed from i < n to i <= n
            set[i] = sc.nextInt();
        }
        System.out.println("Enter the sum (d):");
        d = sc.nextInt();

        for (i = 1; i <= n; i++) {
            sum += set[i];
        }
        if (sum < d || set[n] > d) { // Fix: use set[n] instead of set[i]
            System.out.println("No subset possible with sum = " + d);
            return;
        }

        sumofsub(0, 1);

        if (count == 0) {
            System.out.println("No solution exists");
        }
    }
}
