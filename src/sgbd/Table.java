package sgbd;

import java.util.ArrayList;
import java.util.StringTokenizer;

import fileManager.FileFetch;
import algorithms.*;

public class Table {
	private String name;
	private ArrayList<Atribute> atributes;
	private ArrayList<ArrayList<String>> datas;
	private int qtdAtributes;
	private int qtdTuples;
	
	//---------------------GETTER E SETTERS-----------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Atribute> getAtributes() {
		return atributes;
	}

	public void setAtributes(ArrayList<Atribute> atributes) {
		this.atributes = atributes;
	}

	public ArrayList<ArrayList<String>> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<ArrayList<String>> datas) {
		this.datas = datas;
	}

	public int getQtdAtributes() {
		return qtdAtributes;
	}

	public void setQtdAtributes(int qtdAtributes) {
		this.qtdAtributes = qtdAtributes;
	}

	public int getQtdTuples() {
		return qtdTuples;
	}

	public void setQtdTuples(int qtdTuples) {
		this.qtdTuples = qtdTuples;
	}
	//------------------------------------------------------------------
	
	public Table(String name){
		this.name=name;
		this.atributes=new ArrayList<Atribute>();
		this.datas=new ArrayList<ArrayList<String>>();
		this.loadTable();
	}
	
	public Table(String name, ArrayList<Atribute> atributes){
		this.name=name;
		this.datas=new ArrayList<ArrayList<String>>();
		this.atributes=atributes;
		this.qtdTuples=0;		
	}
	
	private void loadTable(){
		this.atributes = FileFetch.getTableMD(name);
		this.qtdAtributes=this.atributes.size();		
		
		this.datas=FileFetch.getTableDatas(name);
		this.qtdTuples = datas.size();
	}
	
	public boolean insertTuple(ArrayList<String> line){
		this.datas.add(line);
		qtdTuples++;
		return true;
	}	
	
	public boolean  alterTable(){
		
		return true;
	}
	
	private void removeCollumn(String collumName){
				
	}
	
	private void insertCollumn(){
		
	}
	
	private void alterType(){
		
		
	}
	@Override
	public String toString() {
		String result="";				
		return result;
	}
}
