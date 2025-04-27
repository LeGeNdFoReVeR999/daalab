package daalab;
import java.util.Scanner;
import java.util.Random;
public class quicksort {
	private int []a;
	void input() {
		Scanner sc=new Scanner(System.in);
		Random rm =new Random();
		System.out.println("Enter the total numbers");
		int n=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=rm.nextInt(1000);
		}
	}
	void display() {
		for(int X:a) {
			System.out.println(X+" ");
		}
	}
	void sort() {
		Quicksort(0,a.length-1);
	}
	void Quicksort(int left,int right) {
		if(left<right) {
			int s=partition(left,right);
			Quicksort(left,s-1);
			Quicksort(s+1,right);
		}
	}
	int partition(int left,int right) {
		int pivot=a[left];
		int i=left+1;
		int j=right;
		while (i <= j) {
			while (i <= right && a[i] <= pivot) {
				i++; 
			}
			while (j >= left && a[j] > pivot) {
				j--;
			}
			if (i < j) {
				swap(i, j); 
			}
		}
		swap(left, j);
		return j;
	}
	private void swap(int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String [] args) {
		quicksort sorter= new quicksort();
		sorter.input();
		System.out.println("Array before sorting\n");
		sorter.display();
		long startTime=System.nanoTime();
		sorter.sort();
		long endTime=System.nanoTime();
		double duration=(endTime-startTime)/100000;
		System.out.println("\nArray after sorting");
		sorter.display();
		System.out.println("\nthe time for sorting is "+duration+"milliseconds");
	}
}
