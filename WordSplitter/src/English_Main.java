import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.*;

// Recursive implementation of  
// word break problem in java 
public class English_Main {
	// set to hold dictionary values
	private static ArrayList<String> dictionary = new ArrayList<>();

	static boolean dictionaryContains(String word) {
		for (int i = 0; i < dictionary.size(); i++)
			if (dictionary.get(i).equals(word))
				return true;
		return false;
	}

	public static String wordBreak(String word) {
		String result = "", temp = "", resultTemp = "";
		int currentIndex = 0;
		boolean hasResult = false;
		int size = word.length();
		int i = 0;
		while (i < size) {
			for (int j = i + 1; j < size + 1; j++) {
				temp = word.substring(i, j);
				if(dictionaryContains(temp)) {
					resultTemp = temp;
					hasResult = true;
					currentIndex = j;
				}
			}
			if(hasResult) {
				result += resultTemp + " ";
				i = currentIndex;
			} else
				i++;
			
			hasResult = false;
		}
		
		return result;
	}

	public static void main(String[] args) {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(
					FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/file/en.tokens.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String str;

		List<String> list = new ArrayList<String>();
		try {
			while ((str = in.readLine()) != null) {
				list.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] temp_dictionary = list.toArray(new String[0]);

		for (String temp : temp_dictionary) {
			dictionary.add(temp);
		}
		
		//input test cases
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(
					FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/file/mergedTokens_en.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String string;

		List<String> inputList = new ArrayList<String>();
		try {
			while ((string = input.readLine()) != null) {
				inputList.add(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] input_words = inputList.toArray(new String[0]);
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("94463104_Assignment1_EN"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < input_words.length; i++) {
		    try {
				writer.write(wordBreak(input_words[i]) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}