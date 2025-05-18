package daalab;
import java.util.Scanner;

public class Knapsack {
    static int[] p, wt;
    static int c, n;

    static void knapsack_dp() {
        int[][] k = new int[n + 1][c + 1];
        int i, j, w;

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= c; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (wt[i] <= w) {
                    k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }

        System.out.println("The Selected item are:");
        int currCap = c;
        int m = n;
        while (m > 0) {
            if (k[m][currCap] != k[m - 1][currCap]) {
                System.out.println("Item " + m + " Weight: " + wt[m] + " Profit: " + p[m]);
                currCap = currCap - wt[m];
            }
            m--;
        }

        System.out.println("Total profit of items added to the knapsack = " + k[n][c]);

        System.out.println("\nIntermediate results:");
        // Print capacity header
        System.out.print("\t");
        for (j = 0; j <= c; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        // Print DP matrix
        for (i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("Item " + i + " (0,0)\t");
            } else {
                System.out.print("Item " + i + " (" + p[i] + "," + wt[i] + ")\t");
            }
            for (j = 0; j <= c; j++) {
                System.out.print(k[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int max(int a, int b) {
        return (a > b) ? a : b; // fixed: return the larger value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items");
        n = sc.nextInt();

        p = new int[n + 1];
        wt = new int[n + 1];

        System.out.println("Enter the items profit");
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println("Enter the items weight");
        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter the Maximum capacity");
        c = sc.nextInt();

        System.out.println("\n0/1 Knapsack using Dynamic Programming");
        knapsack_dp();
    }
}
