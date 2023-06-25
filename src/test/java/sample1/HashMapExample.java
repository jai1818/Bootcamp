package sample1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<String, String> stdinfo=new HashMap<String,String>();
		stdinfo.put("Empname", "Jay");
		stdinfo.put("Desig", "QA");
		stdinfo.put("Location", "chennai");
		stdinfo.put("Location", "bangl");

		System.out.println(stdinfo);
		//Iterate using keyset
		Iterator<String> iterator = stdinfo.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = stdinfo.get(key);
			System.out.println(key +" -----"+value);}
		//iterate using entryset
		Iterator<Entry<String, String>> it2 = stdinfo.entrySet().iterator();
		while (it2.hasNext()) {
			Entry<String, String> next = it2.next();
			System.out.println(next.getKey()+"-----"+next.getValue());
		}
		System.out.println("-------------");
		stdinfo.forEach((k,v) -> System.out.println(k + "-----"+v));


		HashMap<Integer, String> com1=new HashMap<>();
		com1.put(1, "A");
		com1.put(2, "B");
		com1.put(3, "C");
		//		

		com1.forEach((k,v)->System.out.println(k +"---"+v));
		System.out.println(com1);

		HashMap<Integer, String> com2=new HashMap<>();
		com2.put(4, "A");
		com2.put(5, "B");
		com2.put(6, "C");


		HashMap<Integer, String> com3=new HashMap<>();
		com3.put(1, "A");
		com3.put(2, "B");
		com3.put(3, "C");
		com3.put(4, "C");

		System.out.println(com1.get(1));

		//1.Comparing key value using equals method

		System.out.println(com1.equals(com2));//true
		System.out.println(com1.equals(com3));//false

		//2.Compare same keys using keySet() method
		System.out.println(com1.keySet().equals(com2.keySet()));
		System.out.println(com1.keySet().equals(com3.keySet()));

		//3.combining keys of both maps using HashSet

		HashSet<Integer> combkey = new HashSet<Integer>(com1.keySet());
		System.out.println(combkey);
		combkey.addAll(com3.keySet());
		System.out.println(combkey);
		combkey.removeAll(com2.keySet());
		System.out.println(combkey);
		//4.Compare maps by value

		System.out.println(com1.values().equals(com2.values()));
		System.out.println(new ArrayList<>(com1.values()).equals(new ArrayList<>(com2.values())));
		System.out.println(new ArrayList<>(com1.values()).equals(new ArrayList<>(com3.values())));

		System.out.println(new HashSet<>(com1.values()).equals(new HashSet<>(com2.values())));
		System.out.println(new HashSet<>(com1.values()).equals(new HashSet<>(com3.values())));
		//5.coverting hashmap to arraylist 

		List<Integer> ll=com3.keySet().stream().collect(Collectors.toList());

		System.out.println(ll);

		List<String> l2=	com3.values().stream().collect(Collectors.toList());
		System.out.println(l2);

		List<Map.Entry<Integer, String>> l3=com3.entrySet().stream().collect(Collectors.toList());
		System.out.println(l3);
		
		//typical Arraylist
		
	List<Integer>	l4=new ArrayList<Integer>(com3.keySet());
	for (Integer integer : l4) {
		System.out.println(integer);
	}
//	
//	List<Map.Entry<Integer, String>> l5=new ArrayList(com3.keySet());
//	for (Entry<Integer, String> entry : l5) {
//		System.out.println(entry);
//	}
	List<Map.Entry<Integer, String>> l6 = new ArrayList<>(com3.entrySet());
	for (Map.Entry<Integer, String> entry : l6) {
	    System.out.println(entry);
	}


	}

}
