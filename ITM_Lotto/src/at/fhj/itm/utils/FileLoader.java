package at.fhj.itm.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.ws.rs.core.Context;

public class FileLoader {

	public String getFile(String fileName){
		StringBuilder result = new StringBuilder("");
		
		URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
		System.out.println("DEBUG: URL: " + resource);
		try (InputStream in = resource.openStream()){
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inReader);
			String line;
			while((line = br.readLine())!=null){
				result.append(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		
		//File file = new File(Thread.currentThread().getContextClassLoader().getResource("/" + fileName).getFile());
//		try (Scanner scanner = new Scanner(file)){
//			while(scanner.hasNextLine()){
//				result.append(scanner.nextLine());
//				
//			}
//			scanner.close();
//			
//		} catch(IOException e){
//			e.printStackTrace();
//		}
		
		return result.toString();
	}

}
