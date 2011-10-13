package sgbd;

import java.util.ArrayList;
import java.util.StringTokenizer;

import fileManager.FileFetch;

public class Table {
	public String name;
	public ArrayList<Atribute> atributes= new ArrayList<Atribute>();
	public ArrayList<String[]> datas;
	public int qtdAtributes;
	public int qtdTuples;
	
	public Table(String name){
		this.name=name;
		ArrayList<String> temp = FileFetch.getTableMD(name);
		qtdAtributes=temp.size();
		datas = new ArrayList<String[]>();
		
		
		for(String str: temp){
			StringTokenizer stk = new StringTokenizer(str,":");
			String nameAtr=stk.nextToken();
			String typeAtr=stk.nextToken();

			atributes.add(new Atribute(nameAtr,typeAtr));
		}
		
		temp=FileFetch.getTableDatas(name);
		qtdTuples = temp.size();	
		for(String str: temp){
			StringTokenizer stk = new StringTokenizer(str,"#\n");			
			String strTemp[]=new String[qtdAtributes];
			for(int i=0;i<qtdAtributes;i++){
				strTemp[i]=stk.nextToken();				
			}
			datas.add(strTemp);
		}
	}
	
	public Table(String name, ArrayList<Atribute> atributes){
		this.name=name;
		this.datas=new ArrayList<String[]>();
		this.atributes=atributes;
		this.qtdTuples=0;
		
	}
	
	public boolean insertTuple(String[] datas){
		this.datas.add(datas);
		qtdTuples++;
		return true;
	}
	
	@Override
	public String toString() {
		String result="";
		for(String[] tupla: datas){
			for(String atributo:tupla){
				result+=atributo+" ";
			}
			result+="\n";				
		}			
		return result;
	}

}
