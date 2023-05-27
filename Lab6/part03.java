package Lab202;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



public class part03 {
	public static void main(String[] args) {
		
		//3
		FreqStack fS = new FreqStack();
		fS.push(5);
		fS.push(7); 
		fS.push(5);
		fS.push(7);
		fS.push(4); 
		fS.push(5);
		System.out.print(fS.pop()+",");
	    System.out.print(fS.pop()+",");
	    System.out.print(fS.pop()+",");
	    System.out.print(fS.pop()+",");
		
	}
	
	static class FreqStack {
	    Map<Integer, Integer> freqM;
	    Map<Integer, Stack<Integer>> freqS;
	    int maxFreq;

	    public FreqStack() {
	        freqM = new HashMap();
	        freqS = new HashMap();
	        maxFreq = 0;
	    }

	    public void push(int x) {
	        int freq = freqM.getOrDefault(x, 0) + 1;
	        freqM.put(x, freq);
	        if (freq > maxFreq)
	            maxFreq = freq;
	        freqS.computeIfAbsent(freq, z->new Stack()).push(x);
	    }

	    public int pop() {
	    	 int x = freqS.get(maxFreq).pop();
	    	 freqM.put(x, freqM.get(x) - 1);
	         if (freqS.get(maxFreq).size() == 0) {
	             maxFreq--;
	         }
	         
	         return x;
	    }
	}
	
	

}
