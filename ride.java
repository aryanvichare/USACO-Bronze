package usaco.ride;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ride.out"));

		String group = in.readLine();
		String comet = in.readLine();

		if (toNumber(group) % 47 == toNumber(comet) % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		out.close();
		System.exit(0);
	}

	public static int toNumber(String name) {
		int product = 1;
		for (int i = 0; i < name.length(); i++) {
			int charValue = (name.charAt(i) - 'A' + 1);
			product = product * charValue;
		}
		return product;
	}
}