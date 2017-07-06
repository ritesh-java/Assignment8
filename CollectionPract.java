
package packageone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionPract{
	public static void main(String args[]){
		ArrayList<Integer> list = new ArrayList<Integer>();
	    System.out.println("1.) ArrayList:");
		list.add(30);list.add(100);list.add(304);list.add(10);list.add(876);list.add(4);list.add(45);list.add(23);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		Collections.sort(list);
		System.out.println();
		Iterator<Integer> itr = list.iterator();
		System.out.println("Minium value is: "+itr.next());
		System.out.println();
		HashSet<Integer> hashlist = new HashSet<Integer>();
		hashlist.add(145);hashlist.add(164);hashlist.add(65);hashlist.add(45);hashlist.add(435);hashlist.add(6);hashlist.add(15);
		System.out.println("2.) HashSet: ");
		Iterator<Integer> itr3 = hashlist.iterator();
		while(itr3.hasNext()){
			System.out.print(itr3.next()+" ");
		}
		
		List<Integer> l = new ArrayList<Integer>(hashlist);
		System.out.println();
		Collections.sort(l);
		Iterator<Integer> itr1 = l.iterator();
		System.out.println("Minimum value: "+itr1.next());
		
		System.out.println();System.out.println();
		Collections.reverse(list);
		System.out.println("3.) Reverse Array List");
		
		Iterator<Integer> itr4 = list.iterator();
		
		while(itr4.hasNext()){
			System.out.print(itr4.next()+" ");
		}
		System.out.println();System.out.println();
		
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1,"Ramesh");hashmap.put(2,"Rohit");hashmap.put(3,"Aakriti");hashmap.put(4,"Nick");hashmap.put(5,"David");hashmap.put(6,"Emilly");hashmap.put(7,"Gursimran");
		System.out.println("HashMap:");
		for(Map.Entry<Integer, String> map: hashmap.entrySet()){
			System.out.println("Key: "+map.getKey()+" and value: "+map.getValue());
		}
		System.out.println();
		System.out.println("4.) Checking if the HashMap contains a paricular key 4");
		if(hashmap.containsKey(4)){
			System.out.println("Yes it contains the key and it's value is "+hashmap.get(4));
		}
		System.out.println();
		System.out.println("5.) Checking if the HashMap contains a paricular value Rohit");
		if(hashmap.containsValue("Rohit")){
			System.out.println("Yes it contains the value!!");
		}
		
		System.out.println();System.out.println();
		TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
		tree.put(101, "Sunday");tree.put(102, "Monday");tree.put(103, "Tuesday");tree.put(104, "Wednesday");tree.put(105, "Thursday");tree.put(106, "Friday");tree.put(107, "Saturday");
		System.out.println("6.) TreeMap: ");
		for(Map.Entry<Integer, String> treeset: tree.entrySet()){
			System.out.println("Key: "+treeset.getKey()+" and value: "+treeset.getValue());
		}
		System.out.println();
		
		System.out.println("Lowest Key "+tree.firstKey()+" and the highest key is "+tree.lastKey());
	}
}