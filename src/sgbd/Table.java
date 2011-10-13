package sgbd;

import java.util.ArrayList;

public class Table {
	String name;
	ArrayList<Atributes> atributes= new ArrayList<Atributes>();
	int qtdAtributes;
	int qtdTuples;
	
	public Table(){
		qtdAtributes=atributes.size();
	}

}
