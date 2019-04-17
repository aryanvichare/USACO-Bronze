package usaco.backforth;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class backforth {

//ID: aryanvi	 
//LANG: JAVA
//PROG: backforth
	
	static ArrayList<Integer> barn1 = new ArrayList<Integer>();
	static ArrayList<Integer> barn2 = new ArrayList<Integer>();
	static int[] poss = new int[2000]; 

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader("backforth.in")); // Read in
		PrintWriter pw = new PrintWriter(new File("backforth.out")); // Print out
		
		for(int i = 0; i < 10; i++) {
			barn1.add(sc.nextInt());
		}
		for(int i = 0; i < 10; i++) {
			barn2.add(sc.nextInt());
		}
		
		tuesday(1000, barn1, barn2);
		int ans = 0;
		
		for(int i = 0; i < 2000; i++) {
			ans += poss[i];
			//System.out.println("Ans = " + ans + " at index " + i);
		}
		
		System.out.println(ans);
		pw.print(ans);
		pw.close();
		
	}
	
	public static void tuesday(int b1Amount, ArrayList<Integer> b1, ArrayList<Integer> b2) {
		for(int i = 0; i < b1.size(); i++) {
			int x = b1.get(i);
			ArrayList<Integer> newB1 = new ArrayList<Integer>();
			ArrayList<Integer> newB2 = new ArrayList<Integer>();
			newB1 = deepCopy(b1);
			newB2 = deepCopy(b2);
			
			newB2.add(x);
			newB1.remove(i);
			wednesday(b1Amount - x, newB1, newB2);
		}
	}
	
	public static void wednesday(int b1Amount, ArrayList<Integer> b1, ArrayList<Integer> b2) {
		for(int i = 0; i < b2.size(); i++) {
			int x = b2.get(i);
			ArrayList<Integer> newB1 = new ArrayList<Integer>();
			ArrayList<Integer> newB2 = new ArrayList<Integer>();
			newB1 = deepCopy(b1);
			newB2 = deepCopy(b2);
			
			newB1.add(x);
			newB2.remove(i);
			thursday(b1Amount + x, newB1, newB2);
		}
	}
	
	public static void thursday(int b1Amount, ArrayList<Integer> b1, ArrayList<Integer> b2) {
		for(int i = 0; i < b1.size(); i++) {
			int x = b1.get(i);
			ArrayList<Integer> newB1 = new ArrayList<Integer>();
			ArrayList<Integer> newB2 = new ArrayList<Integer>();
			newB1 = deepCopy(b1);
			newB2 = deepCopy(b2);
			
			newB2.add(x);
			newB1.remove(i);
			friday(b1Amount - x, newB1, newB2);
		}
	}
	
	public static void friday(int b1Amount, ArrayList<Integer> b1, ArrayList<Integer> b2) {
		for(int i = 0; i < b2.size(); i++) {
			int x = b2.get(i);
			poss[x + b1Amount] = 1;
		}
	}
	
	public static ArrayList<Integer> deepCopy(ArrayList<Integer> arr1){
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 0; i < arr1.size(); i++) {
			arr2.add(arr1.get(i));
		}
		return arr2;
	}
}
