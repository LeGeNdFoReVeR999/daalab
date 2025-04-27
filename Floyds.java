package daalab;
import java.util.Scanner;
public class Floyds {
	static int dist[][];
	static int n;
	static void compute_floyd() {
		int i,j,k;
		for(k=1;k<=n;k++) {
			for(i=1;i<=n;i++) {
				for(j=1;j<=n;j++) {
					dist[i][j]=min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
	}
	static int min(int a, int b) {
		if(a<b) {
			return a;
		}
		else {
			return b;
		}
	}
	public static void main(String[]args) {
		int i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		n=sc.nextInt();
		dist=new int[n+1][n+1];
		System.out.println("Enter the weighted matrix(99 for no edges):");
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				dist[i][j]=sc.nextInt();
			}
		}
		compute_floyd();
		System.out.println("All pairs shortest path distance matrix is");
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				System.out.print(dist[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
