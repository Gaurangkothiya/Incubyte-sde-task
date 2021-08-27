package main;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class NegativeNumException extends Exception{

	public NegativeNumException(String message, ArrayList<String> numbers) {
        super(message + String.join(",", numbers));
    }
}