package sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<Integer> aL = new ArrayList<Integer>();
		aL.add(10);
		aL.add(20);
		aL.add(25);
		aL.add(35);
		aL.add(40);
		System.out.println(aL.size());
		System.out.println(aL);
		
		for (int i = 0; i < aL.size(); i++) {
			System.out.println(aL.get(i));
		}
		System.out.println("=======");
		for (Integer integer : aL) {
			System.out.println(integer);
		}
		System.out.println("=======");
		
		Iterator<Integer> it = aL.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		System.out.println("=======");
		
		aL.stream().forEach(ele -> System.out.println(ele));
		
		System.out.println("=======");
		
		//List with other collection
		
		
		ArrayList <Integer> list=new ArrayList<Integer>(Arrays.asList(1,3,4,5,7,10,20,30,40));
		System.out.println(list);
		//to remove even numbers and print odd numbers
//			list.removeIf(num -> num%2 ==0);
//			System.out.println(list);
		//to print only even numbers remove odd 
			
			list.removeIf(num -> num%2 !=0);
			System.out.println(list);
			
		//coverting arraylist to array
			
			ArrayList<String> names=new ArrayList<String>(Arrays.asList("Jay","Prakash","Praveen","jp"));
			Object o[]=names.toArray();
//			System.out.println(Arrays.toString(o));
			for (int i = 0; i < o.length; i++) {
				System.out.println(o[i]);
			}
			
		//coverting array to arraylist 
			String[] names1= {"JJJJ","prakash","jp","ijp"};
			
			System.out.println(Arrays.toString(names1));
			ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(names1));
			
			System.out.println(arrayList);
			
		//Synchronization in list can be achived by 2 one by method(synchronizedlist) and
			//CopyOnWriteArrayList class 
			
	List<String> nam	=Collections.synchronizedList(new ArrayList<String>());
		nam.add("Jp");
		nam.add("jap");
		nam.add("prak");
		
		synchronized (nam) {
		Iterator<String> itr=	nam.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
				}
			
			CopyOnWriteArrayList<String> li=new CopyOnWriteArrayList<String>();
			li.add("oops");
			li.add("java");
			li.add("python");
			
		Iterator<String> i=	li.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			
		}
			
		}
		
		//To remove duplicate values from ArrayList
		
		ArrayList<Integer> dup=
				new ArrayList<Integer>(Arrays.asList(1,1,22,4,5,3,4,3,2,6,7,8,5,9));
		
		//using LinkedHashSet-->set will not allow duplicates
		
		LinkedHashSet<Integer> setdup=new LinkedHashSet<Integer>(dup);
		ArrayList<Integer> dup2= new ArrayList<Integer>(setdup);
		System.out.println(dup2);
		
		//using Java 8 ->stream().distinct.collect(Collectors.toList())
		ArrayList<Integer> marks=
				new ArrayList<Integer>(Arrays.asList(1,1,22,4,5,3,4,3,2,6,7,8,5,9));
	List<Integer> lm=	marks.stream().distinct().collect(Collectors.toList());
	System.out.println(lm);
	
	//COmparig two array list
	ArrayList<String> comp1= new ArrayList<String>(Arrays.asList("Java","Python","Go"));
	ArrayList<String> comp2= new ArrayList<String>(Arrays.asList("Java","Python","Go"));
	ArrayList<String> comp3= new ArrayList<String>(Arrays.asList("PHP","Python","Go"));

//	Collections.sort(comp1);
//	Collections.sort(comp2);
//	System.out.println(comp1.equals(comp2));
	
//	comp3.removeAll(comp2);
	
	comp3.retainAll(comp2);
	System.out.println(comp3);
	System.out.println(comp2);
	
		
		}
		
		
		
	}

}
