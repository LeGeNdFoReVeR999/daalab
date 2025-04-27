package daalab;
import java.util.Scanner;
public class PrimeMST {
	static int [][]wt;
	static int n;
	static int [][]edges;
	static int cost;
	
	static void prims(){
		int [] u,lowcost,visited;
		int min,mincost=0,i,j,v;
		u=new int[n+1];
		visited=new int[n+1];
		lowcost=new int[n+1];
		edges=new int[n][3];
		visited[1]=1;
		for(i=2;i<=n;i++) {
			visited[i]=0;
			u[i]=1;
			lowcost[i]=wt[1][i];
		}
		for(i=1;i<=n-1;i++) {
			min=lowcost[2];
			v=2;
			for(j=3;j<=n;j++) {
				if(lowcost[j]<min) {
					min=lowcost[j];
					v=j;
				}
			}
			edges[i][1]=u[v];
			edges[i][2]=v;
			mincost+=lowcost[v];
			visited[v]=1;
			lowcost[v]=99;
			for(j=2;j<=n;j++) {
				if( wt[v][j] < lowcost[j] && visited[j]==0) {
					lowcost[j]=wt[v][j];
					u[j]=v;
				}
			}
		}
		System.out.println("\nEdges of mincost spanning tree are");
		for(i=1;i<=n-1;i++) {
			System.out.println("("+edges[i][1]+","+edges[i][2]+")");
		}
		System.out.println("Cost of MST="+mincost);
	}
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices:\n");
		n=sc.nextInt();
		wt=new int[n+1][n+1];
		System.out.println("Enter the weight matrix of the graph:\n");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				wt[i][j]=sc.nextInt();
			}
		}
		prims();
	}
}
