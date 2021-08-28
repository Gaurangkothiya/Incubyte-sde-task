package main;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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
		else {
			
			int ans=0;
			
			String[] nums = null;
			String dmtr="";
			String t=s;
			
			if(s.charAt(0)=='/' && s.charAt(1)=='/') {
				
				if(checkMultiDelimeter(s)) {
					dmtr = SplitDelimeter(s);
					t = makeSubString(s);
				}
				else {
					dmtr = Character.toString(s.charAt(2));
					t = s.substring(5);
				}				
			}
			else {
				dmtr = ",|\n";
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
	
	private String SplitDelimeter(String s) {
		int l = s.indexOf('[');
		int r = s.indexOf(']');
		return s.substring(l+1,r);
	}

	private String makeSubString(String s) {
		int r = s.indexOf(']');
		return s.substring(r+3);
	}
	
	
	private int Sum(String[] nums){
		int sum=0;
		
        for(String num:nums){
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
