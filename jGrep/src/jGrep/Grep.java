/*
 * Grep.java
 * 
 * Copyright 2015 cyn <cyn@vendetta>
 * 
 * 
 */
package jGrep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Grep {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) {

		int argscount = args.length;

		if (argscount < 2) {
			System.err.println("Usage: grep regex file");
			System.exit(1);
		}

		String regex = args[0];
		String file = args[1];

		// Compile RE Pattern
		Pattern pat = null;
		try {
			pat = Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			System.err.println("Invalid RegulaExpression syntax: "
					+ e.getDescription());
			System.exit(1);
		}

		// Read File
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + file + ": "
					+ e.getMessage());
		}

		try {
			String line;
			boolean match = false;
			int linenumber = 1;
			
			// Match each line and color the match
			// Coloring only tested in Linux bash
			while ((line = in.readLine()) != null) {
				Matcher m = pat.matcher(line);
				int count = 0;
				int position = 0;
				int length = line.length();
				int start = 0;
				int end = 0;
				
				while (m.find()) {
					match = true;
					count++;
					start = m.start();
					end = m.end();
					
					if (count == 1)
						System.out.print("Line: " + linenumber + " | ");
					
					System.out.print(line.substring(position, start));
					System.out.print(ANSI_GREEN);
					System.out.print(line.substring(start, end));
					System.out.print(ANSI_RESET);
					position = end;
					
				}
				
				if (match == true){
					System.out.println(line.substring(end, length));
				}
				
				match = false;
				linenumber++;
			}
			System.out.println();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
