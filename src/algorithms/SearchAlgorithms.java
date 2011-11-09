package algorithms;

import java.util.ArrayList;

public class SearchAlgorithms<T>{
	
	public int linearSearch(ArrayList<T> array,T obj){
		
		int index=0;
		Comparable objComp =(Comparable)obj;
		
		for(Object it:array){
			Comparable itComp =(Comparable)it;
				
		   if(objComp.compareTo(it)==0) return index;
		      else index++;
}
				
		return -1;
	}
	

}
