package sgbd;

public class Atribute {
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
}
