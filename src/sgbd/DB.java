package sgbd;

import java.util.ArrayList;

public class DB {
	private String name;
	private ArrayList<Table> tables= new ArrayList<Table>();
	private int qtdTables;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Table> getTables() {
		return tables;
	}
	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
	public int getQtdTables() {
		return qtdTables;
	}
	public void setQtdTables(int qtdTables) {
		this.qtdTables = qtdTables;
	}
		
}
