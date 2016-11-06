package at.fhj.itm.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileLoader {
	
	
	public String getFile(String fileName){
		StringBuilder result = new StringBuilder();
		ClassLoader classLoader = getClass().getClassLoader();
		
		File file = new File(classLoader.getResource("/" + fileName).getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while(scanner.hasNextLine()){
				result.append(scanner.nextLine());
				
			}
			scanner.close();
			
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return result.toString();
	}

}
