package usaco.blocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class blocks {
/*	
ID:aryanvi 
LANG:JAVA 
PROG:blocks
*/

	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter(new File("blocks.out"));
		
		int n = sc.nextInt();
		int[] freq = new int[26];
		
		for(int i = 0; i < n; i++) {
			String firstWord = sc.next();
			String secondWord = sc.next();
			
			System.out.println("First Word: " + firstWord + ", Second Word: " + secondWord);
			// a is 0, 
			// b is 1, 
			// c is 2
			
			int[] first = getFreq(firstWord);
			int[] second = getFreq(secondWord);
			
			for(int j = 0; j < 26; j++) {
				if(first[j] > second[j]) {
					freq[j] += first[j];
				}
				else {
					freq[j] += second[j];
				}
			}
		}
		
		for(int i = 0; i < 26; i++) {
			pw.println(freq[i]);
		}
		
		pw.close();
			
		/*
		int n = sc.nextInt();
		int[] blocks = new int[26];
		
		for(int i = 0; i < n; i++) {
			
			String firstWord = sc.next();
			String secondWord = sc.next();
			
			int[] firstFreq = getFrequency(firstWord);
			int[] secondFreq = getFrequency(secondWord);
			
			for(int j = 0; j < blocks.length; j++) {
				
				if(firstFreq[j] > secondFreq[j]) {
					blocks[j] += firstFreq[j]; 
				}
				else {
					blocks[j] += secondFreq[j]; 
				}

			}
		}
		
		for(int i = 0; i < blocks.length; i++) {
			pw.println(blocks[i]);;
		}
		pw.close();
	
     }
	
	*/
	
}

	public static int[] getFreq(String word) {
		
		int[] freq = new int[26];
		for(int i = 0; i < word.length(); i++) {	
			int index = word.charAt(i) - 'a';
			freq[index]++; 
		}
		
		return freq;
	
	}
}