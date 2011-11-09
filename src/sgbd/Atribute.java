package sgbd;

public class Atribute implements Comparable {
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Atribute(String name,String type){
		this.name=name;
		this.type=type;
	}

	@Override
	public int compareTo(Object arg) {
		
		Atribute argAtr=(Atribute)arg;
		
		return (this.name.compareTo(argAtr.name));
		
	}
}
