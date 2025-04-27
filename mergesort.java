package daalab;
import java.util.random.*;
import java.util.Random;
import java.util.Scanner;
public class mergesort {
	private int[]a;
	void input() {
		Scanner sc=new Scanner(System.in);
		Random rm=new Random();
		System.out.println("Enter the total numbers:");
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
		Mergesort(0,a.length-1);
	}
	void Mergesort(int left,int right) {
		int mid;
		if(left<right) {
			mid=(left+right)/2;
			Mergesort(left,mid);
			Mergesort(mid+1,right);
			merge(left,mid,right);
		}
	}
	void merge(int left, int mid, int right) {
		int temp[]=new int[a.length];
		for(int i=left;i<=right;i++) {
			temp[i]=a[i];
		}
		int i =left;
		int j=mid+1;
		int k =left;
		
	while(i<=mid && j<=right) {
		if(temp[i]<=temp[j]) {
			a[k++]=temp[j++];
		}
		else {
			a[k++]=temp[j++];
		}
	}
	while(i<=mid) {
		a[k++]=temp[i++];
	}
}
public static void main(String[]args) {
	mergesort sorter=new mergesort();
	sorter.input();
	System.out.println("Array before sorting\n");
	sorter.display();
	long startTime=System.nanoTime();
	sorter.sort();
	long endTime=System.nanoTime();
	double duration=(endTime-startTime)/100000;
	System.out.println("Array after sorting");
	sorter.display();
	System.out.println("Time for sorting is "+duration+"milli seconds");
	}
}