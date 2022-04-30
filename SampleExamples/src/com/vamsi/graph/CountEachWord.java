package com.vamsi.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Maintain a Map with key as word and value as count of the respective word.
 * For each occurrence of the word(key), increment its corresponding count(value) in the Map.
 * 
 * @author Vamsi
 *
 */
public class CountEachWord {
	
	public static void main(String[] args) throws FileNotFoundException  {
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		countWords("C:\\Users\\vamsi\\eclipse-workspace\\SampleExamples\\src\\com\\vamsi\\graph\\SampleWords", wordsMap);
		System.out.println("Count: " + wordsMap);
	}
	
	static void countWords(String filename, Map<String, Integer> wordsMap) throws FileNotFoundException {
		Scanner file = new Scanner(new File(filename));
		while (file.hasNext()) {
			String word = file.next();
			Integer count = wordsMap.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			wordsMap.put(word, count);	
		}
		file.close();
	}
}