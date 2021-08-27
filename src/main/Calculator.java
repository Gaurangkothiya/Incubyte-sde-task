package main;

public class Calculator {
	public Calculator()
	{
	}
	
	public int Add(String s) {
		if(s.length() == 0 ) {
			return 0;
		}
		else if(s.length() == 1) {
			return Integer.parseInt(s);
		}
		else {
			
			int ans=0;
			
			if(s.matches("//(.)\n(.*)")) {
				
				char dmter = s.charAt(2);
				s = s.substring(4);
				String[] nums = s.split(Character.toString(dmter));
				ans = Sum(nums);
			}
			else {
				String[] nums = s.split(",|\n");
				ans = Sum(nums);
			}
			return ans;
		}
	}
	
	private int Sum(String[] nums) {
		int sum=0;
        for(String num:nums){
        	if(num.length()==0) continue;
            sum+=Integer.parseInt(num);
        }
        return sum;
	}
	
}
