package at.fhj.itm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class FileLoader {

	public String getFile(String fileName){
		StringBuilder result = new StringBuilder("");
		
		URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
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
		
		return result.toString();
	}

}
