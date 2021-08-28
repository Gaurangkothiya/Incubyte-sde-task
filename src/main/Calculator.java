package main;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Calculator {
	
	boolean throwException = false;
	ArrayList<String> negNums = new ArrayList<>();
	
	public Calculator()
	{
	}
	
	public int Add(String s) throws Exception {
		if(s.length() == 0 ) {
			return 0;
		}
		else if(s.length()==1) {
			return Integer.parseInt( Character.toString(s.charAt(0)));
		}
		else {
			
			int ans=0;
			
			String[] nums = null;
			String dmtr = ",|\n";
			String t=s;
			
			if(s.charAt(0)=='/' && s.charAt(1)=='/') {
				
				if(checkMultiDelimeter(s)) {
					
					List<Character> lst = new ArrayList<>();
					
					HashMap<Character , Integer > mp = new HashMap<>();
					for(int i=0;i<s.length()-1;++i) {
						if(s.charAt(i) == '[') {
							if( ! mp.containsKey(s.charAt(i+1)) ) {
								lst.add(s.charAt(i+1));
								mp.put(s.charAt(i+1),1);
							}
						}
						else if(s.charAt(i+1)==']') {
							if( ! mp.containsKey(s.charAt(i)) ) {
								lst.add(s.charAt(i));
								mp.put(s.charAt(i),1);
							}
						}
					}
					
					for(int i=0;i<t.length();++i) {
						if(t.charAt(i) == '[' || t.charAt(i)==']') {
							String tmp = t.substring(0,i);
							if(i+1<t.length()) {
								t = tmp + t.substring(i+1);
							}
							else t = tmp;
							i--;
						}
					}
					
					t = t.substring(2);
					
					for(int i=0;i<lst.size();++i) {
						dmtr = dmtr + "|" + Character.toString(lst.get(i));
					}
					
				}
				else {
					dmtr = Character.toString(s.charAt(2));
					t = s.substring(5);
				}				
			}
			
			nums = t.split(dmtr);
			ans = Sum(nums);
			
			if(this.throwException) {
				throw new NegativeNumException("Negatives not allowed:- ",this.negNums);
			}
			return ans;
		}
	}
	
	private boolean checkMultiDelimeter(String s) {
		return (s.charAt(2) == '['); 
	}	
	
	private int Sum(String[] nums){
		int sum=0;
		
        for(String num:nums){
        	System.out.println(num);
        	if(num.length()==0) continue;
        	if(Integer.parseInt(num)<0) {
        		this.negNums.add(num);
                this.throwException = true;
        	}
        	if(Integer.parseInt(num)>1000 ) continue;
            sum+=Integer.parseInt(num);
        }
        
        return sum;
	}
	
}
