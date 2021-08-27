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
			String[] nums = s.split(",");
			if(nums.length == 1) {
				return Integer.parseInt(nums[0]);
			}
			else {
				return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) ;
			}
		}
	}
}
