/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package germanlabtool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author markymark1346
 */
public class QueryHandler {
    
    String fileContents;
    
    public QueryHandler(){
        System.out.println("Created");
        fileContents = null; // TODO: Maybe make this not null? And give it an error message?
    }
    
    public String loadELANFile(File loadedFile){
        System.out.println("ELAN FILE LOADED");
        String testString = "";
        //String fileContents = null; // TODO: Maybe make this not null? And give it an error message?
        try {
		File fileDir = loadedFile;
		BufferedReader in = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));
		        
                // This prints out the inputted txt file. Must be UTF-8!
                // TODO: Save the file text to the pane
		while ((fileContents = in.readLine()) != null) {
                    testString = testString + fileContents + " ";
		    System.out.println(fileContents);
		}
		        
                in.close();
	    } 
	    catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
	    } 
	    catch (IOException e) {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e) {
			System.out.println(e.getMessage());
	    }
        return testString;
	}
    
    public String convertToStanford(File loadedFile) throws IOException{
        // TODO: Convert the output to the text file! :)
        String path = loadedFile.getAbsolutePath();
        System.out.println("STANFORD CONVERSION");
        ProcessBuilder pb = new ProcessBuilder("/bin/bash", "./lexparser.sh", path).inheritIO();
        //ProcessBuilder pb = new ProcessBuilder("/bin/bash", "./lexparser.sh", "data/testsent.txt").inheritIO();  
        // ProcessBuilder pb = new ProcessBuilder("/bin/bash", "./lexparser.sh", "data/words.txt").inheritIO();  // http://stackoverflow.com/questions/23813611/parsing-messy-texts-with-stanford-parser
        pb.directory(new File("/Users/markymark1346/Development/GermanLabTool/stanfordparser"));
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
           builder.append(line);
           //builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        
        return result; 
    }
    
    public void convertToCONLL() throws IOException{
        //TODO: CONLL10 and Fix Path to file. Maybe use plain text for CONLL example
        System.out.println("CONLL CONVERSION");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "\"*\"", "-Xmx500m", "edu.stanford.nlp.pipeline.StanfordCoreNLP", "-annotators", "tokenize,ssplit,pos", "-file", "input.txt","-outputFormat", "conll").inheritIO();  
        pb.directory(new File("/Users/markymark1346/Development/GermanLabTool/stanfordconll"));
        pb.start();
        
        //java -cp "*" -Xmx500m edu.stanford.nlp.pipeline.StanfordCoreNLP -annotators tokenize,ssplit,pos -file wikipedia.txt -outputFormat conll
    }
    
}
