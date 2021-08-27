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
			int val = Integer.parseInt(s);
			return val;
		}
	}
}
