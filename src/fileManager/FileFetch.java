package fileManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import sgbd.Atribute;
import sgbd.DB;
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
	
	public static DB getDB(String name){
		FileReader file;
		DB bd = new DB();
		
		
		try{
			file = new FileReader(name);
			Scanner sc = new Scanner(file);
			bd.setName(name);
			String nameTb;
			
			while(sc.hasNext()){
				nameTb=sc.nextLine();
				bd.getTables().add(new Table(nameTb));
			}
			
			
			
		}catch(Exception e){
			
		}
		return bd;
	}
	
	public static ArrayList<Atribute> getTableMD(String name){
		ArrayList<Atribute> atributes = new ArrayList<Atribute>();
		FileReader file;
		
		try{
			file = new FileReader(name+".mdt");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
				String str = sc.nextLine();
				StringTokenizer stk = new StringTokenizer(str,":");
				String nameAtr=stk.nextToken();
				String typeAtr=stk.nextToken();				
				atributes.add(new Atribute(nameAtr, typeAtr));
			}			
		}catch(Exception e){
			
		}		
		return atributes;
	}
	
	public static ArrayList<ArrayList<String>> getTableDatas(String name){
		ArrayList<ArrayList<String>> datas= new ArrayList<ArrayList<String>>();
		ArrayList<String> line;
		
        FileReader file;
		
		try{
			file = new FileReader(name+".dt");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
				line = new ArrayList<String>();
				String str = sc.nextLine();
				StringTokenizer stk = new StringTokenizer(str,"#\n");
				while(stk.hasMoreTokens())
					line.add(stk.nextToken());
				datas.add(line);
			}
		}catch(Exception e){
			
		}
		return datas;
	}
	
	public static void setTable(Table tb){
		
		FileWriter file;
		
		try{
			file= new FileWriter(tb.getName()+".mdt");
			PrintWriter fileP = new PrintWriter(file);
			ArrayList<Atribute> atributes=tb.getAtributes();
			
			for(Atribute it: atributes){
				fileP.write(it.getName()+":"+it.getType()+"\n");
			}
			fileP.close();
			
			file= new FileWriter(tb.getName()+".dt");
			fileP = new PrintWriter(file);
			
			ArrayList<ArrayList<String>> datas=tb.getDatas();
			
			for(ArrayList<String> line : datas){
				for (int i=0;i<tb.getQtdAtributes()-1;i++){
					fileP.write(line.get(i)+"#");
				}
				fileP.write(line.get(tb.getQtdAtributes()-1)+"\n");
			}
			fileP.close();
			
		}catch(Exception e){
			
		}
		
		
	}
	
	

}
