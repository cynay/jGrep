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

    public static void main(String[] args){
    	
    	int argscount = args.length;
    	
    	if (argscount < 2){
    		System.err.println("Usage: grep regex file");
    		System.exit(1);
    	}
    	    	
    	String regex = args[0];
    	String file = args[1];
    	
    	System.out.println(argscount);
    	System.out.println("---------");
    	
    	for(int x = 0; x < argscount; x++){
    		System.out.println(args[x]);
    	}
    
    	// Compile RE Pattern
    	Pattern pat = null;
    	try{
    		pat = Pattern.compile(regex);
    	}catch (PatternSyntaxException e) {
    		System.err.println("Invalid RegulaExpression syntax: " 
    				+ e.getDescription());
    		System.exit(1);
    	}
    	
    	// Read File
    	BufferedReader in = null;
    	try{
    		in = new BufferedReader(new FileReader(file));
    	}catch(FileNotFoundException e) {
    		System.err.println("Unable to open file " + file 
    				+ ": " + e.getMessage());
    	}
    	
    	try {
			String line;
			while((line = in.readLine()) != null) {
				Matcher m = pat.matcher(line);
				if (m.find())
					System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}



/*
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import org.kohsuke.args4j.*;

public class Grep {

    public static void main(String[] args){
    	
    	CommandLineValues values = new CommandLineValues(args);
        CmdLineParser parser = new CmdLineParser(values);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.exit(1);
        }

        // Now you can use the command line values
        
    	
    	
    	
    	
    	String regex = args[0];
    	String file = args[1];
    	
        Pattern pattern = null;
        Matcher matcher = null;
        //BufferedReader bf = new BufferedReader(new FileReader(file));
        //String line = bf.readLine();
        
        System.out.println("miau");
        
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {
            try{
                pattern = 
                Pattern.compile(console.readLine("%nEnter your regex: "));

                matcher = 
                pattern.matcher(console.readLine("Enter input string to search: "));
            }
            catch(PatternSyntaxException pse){
                console.format("There is a problem" +
                               " with the regular expression!%n");
                console.format("The pattern in question is: %s%n",
                               pse.getPattern());
                console.format("The description is: %s%n",
                               pse.getDescription());
                console.format("The message is: %s%n",
                               pse.getMessage());
                console.format("The index is: %s%n",
                               pse.getIndex());
                System.exit(0);
            }
            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}
*/


