package daalab;
import java.util.Scanner;
public class binarysearch {
	static int binarySearch(int items[],int Key,int n) {
		int left=0;
		int right=n-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(items[mid]==Key) {
				return mid;
			}
			else if(items[mid]<Key) {
				left=mid+1;
			}
			else if(items[mid]>Key) {
				right=mid-1;
			}
		}
		return-1;
	}
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int i;
		System.out.println("Enter the number of elements");
		int n=sc.nextInt();
		int[]items=new int[n];
		System.out.println("Enter the elements(sorted)");
		for(i=0;i<n;i++) {
			items[i]=sc.nextInt();
			}
		System.out.println("Enter the elements to be searched");
		int Key=sc.nextInt();
		int result=binarySearch(items,Key,n);
		if(result!=-1)
			System.out.println("The elements "+Key+" found at index"+result);
		else
			System.out.println("The elements "+Key+" Not found");
		}
}
