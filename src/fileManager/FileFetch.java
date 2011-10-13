package fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sgbd.Atribute;
import sgbd.BD;
import sgbd.Table;

public class FileFetch {
	
	public static ArrayList<String> getDBsNames(){
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
	
	public static BD getDB(String name){
		FileReader file;
		BD bd = new BD();
		
		
		try{
			file = new FileReader(name);
			Scanner sc = new Scanner(file);
			bd.name=name;
			String nameTb;
			
			while(sc.hasNext()){
				nameTb=sc.nextLine();
				bd.tables.add(new Table(nameTb));
			}
			
			
			
		}catch(Exception e){
			
		}
		return bd;
	}
	
	public static ArrayList<String> getTableMD(String name){
		ArrayList<String> md = new ArrayList<String>();
		FileReader file;
		
		
		try{
			file = new FileReader(name+".mdt");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
				md.add(sc.nextLine());
			}
			
		}catch(Exception e){
			
		}
		
		
		return md;
	}
	
	public static ArrayList<String> getTableDatas(String name){
		ArrayList<String> datas= new ArrayList<String>();
		
        FileReader file;
		
		
		try{
			file = new FileReader(name+".dt");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
				datas.add(sc.nextLine());
			}
			
		}catch(Exception e){
			
		}
		
		
		return datas;
	}
	
	public static void setTable(Table tb){
		
		FileWriter file;
		
		try{
			file= new FileWriter(tb.name+".mdt");
			PrintWriter fileP = new PrintWriter(file);
			ArrayList<Atribute> atributes=tb.atributes;
			
			for(Atribute it: atributes){
				fileP.write(it.name+":"+it.type+"\n");
			}
			fileP.close();
			
			file= new FileWriter(tb.name+".dt");
			fileP = new PrintWriter(file);
			
			ArrayList<String[]> datas=tb.datas;
			
			for(String[] tuple : datas){
				for (int i=0;i<tuple.length-1;i++){
					fileP.write(tuple[i]+"#");
				}
				fileP.write(tuple[tuple.length-1]+"\n");
			}
			fileP.close();
			
			
			
		}catch(Exception e){
			
		}
		
		
	}
	
	

}
