package usaco.lifeguards;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class lifeguards {
/*	
ID: aryanvi
LANG: JAVA
PROG: lifeguards
*/

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new File("lifeguards.out"));
		
		int n = sc.nextInt();
		int[] start = new int[n];
		int[] end = new int[n];
		int[] numCovered = new int[1000];
		
		for(int i = 0; i < n; i++) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = start[i]; j < end[i]; j++) {
				numCovered[j]++;
			}
		}
		
		System.out.println(Arrays.toString(numCovered));
		
		int time = 0;
		int maxTime = 0; 
		
		for(int i = 0; i < n; i++) {
			// Fire each cow and compute total distance 
			time = 0;
			for(int j = start[i]; j < end[i]; j++) {
				numCovered[j]--;
			}
			
			for(int k = 0; k < numCovered.length; k++) {
				if(numCovered[k] > 0) {
					time++;
				}
			}
			
			maxTime = Math.max(maxTime, time);
			
			for(int t = start[i]; t < end[i]; t++) {
				numCovered[t]++;
			}
			
		}
		
		pw.print(maxTime);
		pw.close();
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		int n = sc.nextInt();
		int[] S = new int[n];
		int[] E = new int[n];
		
		for(int i = 0; i < n; i++) {
			S[i] = sc.nextInt();
			E[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(E));
		
		int[] numCovered = new int[1000];
		for(int i = 0; i < n; i++) {
			for(int j = S[i]; j < E[i]; j++) {
				numCovered[j]++;
			}
		}
		
		// Fire Each Cow
		int maxCovered = 0;
		for(int i = 0; i < n; i++) {
			int covered = 0; 
			for(int j = S[i]; j < E[i]; j++) {
				numCovered[j]--;
			}
			
			for(int k = 0; k < numCovered.length; k++) {
				if(numCovered[k] > 0) {
					covered++;
				}
			}
			
			//Redo process
			maxCovered = Math.max(maxCovered, covered);
			for(int t = S[i]; t < E[i]; t++) {
				numCovered[t]++;
			}
			
			
		}
		
		pw.print(maxCovered);
		pw.close();
		

		
		/*
		int numberCows = sc.nextInt(); 
		int[] startTimes = new int[numberCows];
		int[] endTimes = new int[numberCows];
		
		
		for(int i = 0; i < numberCows; i++) {
			
			startTimes[i] = sc.nextInt();
			endTimes[i] = sc.nextInt();
			//System.out.println("Start Time: " + startTimes[i] + ", End Time: " + endTimes[i]);
			
		}
		
		// To determine how many cows are present for every single time 
		int[] numCovered = new int[1000];
		for(int i = 0; i < numberCows; i++) {
			for(int t = startTimes[i]; t < endTimes[i]; t++) {
				numCovered[t]++;
			}
		}
		
		int maxCovered = 0;
		
		for(int i = 0; i < numberCows; i++) {
			// Fire a cow, each cow gets fired 
			for(int t = startTimes[i]; t < endTimes[i]; t++) {
				numCovered[t]--;
			}
			
		int covered = 0; 
		for(int t = 0; t < numCovered.length; t++) {
			if(numCovered[t] > 0) {
				covered++; 
		  	}
		}
		
		// Reput cows
		maxCovered = Math.max(covered, maxCovered);
		for(int t = startTimes[i]; t < endTimes[i]; t++) {
			numCovered[t]++;
		}
					
	}
		
		pw.print(maxCovered);
		pw.close();
*/
	}

}
