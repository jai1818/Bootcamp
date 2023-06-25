package sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class PrintCloseToZero {

	public static void main(String[] args) {

		
		Integer[] ar= {-1,1,2,-3,5,4,-4};
		
		
		 ArrayList<Integer> aa = new ArrayList<>(Arrays.asList(ar));
		 
		 for (int i = 0; i < aa.size(); i++) {
			int abs=Math.abs(aa.get(i));
			aa.set(i, abs);
			
		}
		 Collections.sort(aa);
		 System.out.println(aa.get(0));
		 
		 
	}

}
