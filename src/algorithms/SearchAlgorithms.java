package algorithms;

import java.util.ArrayList;

public class SearchAlgorithms {
	
	public int linearSearch(ArrayList<Comparable> array,Comparable obj){
		
		int index=0;
		
		for(Comparable it:array)	
		if(obj.compareTo(it)==0) return index;
		else index++;
				
		return -1;
	}
	

}
