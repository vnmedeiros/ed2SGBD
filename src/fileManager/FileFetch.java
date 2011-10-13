package fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class FileFetch {
	
	public static ArrayList<String> getDBs(){
		ArrayList<String> found= new ArrayList<String>();
		FileReader file;
		
		try{
		   file = new FileReader("databases.db");
		   Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
				found.add(sc.nextLine());
			}
			file.close();
		}catch(Exception e){
			System.out.println("fodeu!");
			
		}
		
		return found;
		
	}

}
