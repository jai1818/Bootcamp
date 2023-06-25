package sample1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {

		
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(1);
		hs.add(2);
		hs.add(5);
		hs.add(5);
		hs.add(4);
		hs.add(3);
		
		System.out.println(hs);
		
		hs.addAll(Arrays.asList(new Integer[] {1,2,3,4,5,6,8}));
		System.out.println(hs);
		
		HashSet<Integer> hs3=new HashSet<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5,5}));
		System.out.println(hs3);
		
		HashSet<Integer> hs2=new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,1,2));
		
		System.out.println(hs2);
		
		LinkedHashSet<Integer> lks=new LinkedHashSet<Integer>(Arrays.asList(1,8,3,4,1,1,2,4,5,6,7));
		System.out.println(lks);
		
		TreeSet<Integer> ts=new TreeSet<Integer>(Arrays.asList(8,9,6,7,4,3,3,2,1));
		System.out.println(ts);
		
		
		
		
		
		
		
		
		
	}

}
