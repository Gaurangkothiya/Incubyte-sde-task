package main;

public class Calculator {
	public Calculator()
	{
	}
	
	public int Add(String s) {
		if(s.length() == 0 ) {
			return 0;
		}
		else {
			String[] nums = s.split(",|\n");
			
			int sum = 0;
			for(String num : nums) {
				if(num.length() == 0) continue;
				sum += Integer.parseInt(num);
			}
			return sum;
		}
	}
}
