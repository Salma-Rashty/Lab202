package Lab202;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubsetSum {
	public static void main(String[]args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(7);
		set.add(1);
		set.add(8);
		set.add(-3);
		System.out.println(subsetSum(set));
		
	}
	
	public static boolean subsetSum(Set<Integer>set) {
		ArrayList<Integer> arr = new ArrayList<Integer>(set);
		for(int i=0 ; i<set.size() ; i++) {
			for(int j=0 ; j<set.size() ; j++) {
				if(i==j) {
					continue;
				}
				else if(arr.get(i)+arr.get(j)==4) {
					return true;
				}
				else{
					continue;
				}
			}
		}
		return false;
	}

}
