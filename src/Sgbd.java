import java.util.ArrayList;

import fileManager.FileFetch;


public class Sgbd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> dbs= FileFetch.getDBs();
		System.out.println(dbs.size());

	}

}
