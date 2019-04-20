package usaco.mixmilk;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class mixmilk {

	public static void main(String[] args) throws IOException {
			
		Scanner sc = new Scanner(new FileReader("mixmilk.in")); 
		PrintWriter pw = new PrintWriter(new File("mixmilk.out")); 
		
		long[] capacity = new long[3];
		long[] amount = new long[3];
		
		for(int i = 0; i < 3; i++) {
			capacity[i] = sc.nextLong();
			amount[i] = sc.nextLong();
		}
		
		System.out.println(Arrays.toString(capacity));
		System.out.println(Arrays.toString(amount));

		for(int i = 1; i <= 33; i++) {
			//Bucket 0 -> 1
			if(amount[0] + amount[1] <= capacity[1]) {
				amount[1] = amount[0] + amount[1];
				amount[0] = 0;
			}
			else if(amount[0] + amount[1] > capacity[1]) {
				amount[0] = amount[0]-(capacity[1] - amount[1]);
				amount[1] = capacity[1];
			}
			//Bucket 1 -> 2			
			if(amount[1] + amount[2] <= capacity[2]) {
				amount[2] = amount[1] + amount[2];
				amount[1] = 0;
			}
			else if(amount[1] + amount[2] > capacity[2]) {
				amount[1] = amount[1]-(capacity[2] - amount[2]);
				amount[2] = capacity[2];
			}
			//Bucket 2 -> 0	
			if(amount[2] + amount[0] <= capacity[0]) {
				amount[0] = amount[0] + amount[2];
				amount[2] = 0;
			}
			else if(amount[2] + amount[0] > capacity[0]) {
				amount[2] = amount[2]-(capacity[0] - amount[0]);
				amount[0] = capacity[0];
			}
			
			System.out.println("Bucket 0: " + amount[0]);
			System.out.println("Bucket 1: " + amount[1]);
			System.out.println("Bucket 2: " + amount[2]);
			
		}
		//Bucket 0 -> 1		
		if(amount[0] + amount[1] <= capacity[1]) {
			amount[1] = amount[0] + amount[1];
			amount[0] = 0;
		}
		else if(amount[0] + amount[1] > capacity[1]) {
			amount[0] = amount[0]-(capacity[1] - amount[1]);
			amount[1] = capacity[1];
		}
		
		System.out.println("Bucket 0: " + amount[0]);
		System.out.println("Bucket 1: " + amount[1]);
		System.out.println("Bucket 2: " + amount[2]);
		
		pw.println(amount[0]);
		pw.println(amount[1]);
		pw.print(amount[2]);
		
		pw.close();
			
	}

}