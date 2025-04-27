package daalab;
import java.util.Scanner;

public class Warshall {
	static int R[][];
	static int n;
	
	static void compute_Warshall() {
		int i,j,k;
		for(k=1;k<=n;k++) {
			for(i=1;i<=n;i++) {
				for(j=1;j<=n;j++) {
					R[i][j]=R[i][j] | R[i][k] & R[k][j];
				}
			}
		}
	}
	public static void main(String[]args) {
		int i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n=sc.nextInt();
		R=new int[n+1][n+1];
		System.out.println("Enter the matrix in terms of zero's and one's ");
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				R[i][j]=sc.nextInt();
			}
		}
		compute_Warshall();
		System.out.println("Transitive Closure matrix");
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				System.out.print(R[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
