package usaco.blist;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class blist {

	public static void main(String[] args) throws IOException { 

		Scanner sc = new Scanner(new FileReader("blist.in")); // Read in
		PrintWriter pw = new PrintWriter(new File("blist.out")); // Print out
		
		int n = sc.nextInt();
		int S[] = new int[n];
		int T[] = new int[n];
		int B[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			S[i] = sc.nextInt();
			T[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		
		int maxBuckets = 0;
		int currentBuckets = 0; 
		
		for(int time = 1; time <= 1000; time++) {
			currentBuckets = 0;
			
			for(int i = 0; i < n; i++) {
				if (S[i] <= time && time <= T[i]) {
			        currentBuckets += B[i];
			        //System.out.println(currentBuckets);
			      }
			}
			
			maxBuckets = Math.max(maxBuckets, currentBuckets);
		}
		
		//System.out.println("Max Buckets = " + maxBuckets);
		pw.println(maxBuckets);
		pw.close();
	
		
	}
}
