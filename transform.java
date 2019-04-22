package usaco.transform;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class transform {
	
	/*
	ID: aryanvi1
	LANG: JAVA
	PROB: transform
	*/

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(new FileReader("transform.in"));
		PrintWriter pw = new PrintWriter(new File("transform.out"));
		
		int n = sc.nextInt();
		char[][] orig = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String line = sc.next();
			for(int j = 0; j < n; j++) {
				orig[i][j] = line.charAt(j);
			}
		}
		
		char[][] transformed = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String line = sc.next();
			for(int j = 0; j < n; j++) {
				transformed[i][j] = line.charAt(j);
			}
		}
		
		if(Arrays.deepEquals(clockwise(orig), transformed)) {
			pw.println(1);
		}
		else if(Arrays.deepEquals(clockwise(clockwise(orig)), transformed)) {
			pw.println(2);
		}
		else if(Arrays.deepEquals(clockwise(clockwise(clockwise(orig))), transformed)) {
			pw.println(3);
		}
		else if(Arrays.deepEquals(reflect(orig), transformed)) {
			pw.println(4);
		}
		else if(Arrays.deepEquals(reflect(clockwise(orig)), transformed) || Arrays.deepEquals(reflect(clockwise(clockwise(orig))), transformed) || Arrays.deepEquals(reflect(clockwise(clockwise(clockwise(orig)))), transformed)){
			pw.println(5);
		}
		else if(Arrays.deepEquals(orig, transformed)){
			pw.println(6);
		}
		else {
			pw.println(7);
		}
		
		pw.close();
	
	}
	
	public static char[][] clockwise(char[][] input) {
		
		char[][] arr = new char[input.length][input.length];
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++) {
				arr[j][input.length-i-1] = input[i][j];
			}
		}
		
		return arr;	
	}
	
	public static char[][] reflect(char[][] input){
		char[][] arr = new char[input.length][input.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = input[i][input.length-j-1];
			}
		}
		return arr;	
	}
}
