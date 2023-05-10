package com.masai;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	
public static void main(String[] args) {
	List <String> list= Arrays.asList("howrah","kolkata","pune","panjab","patna");
	
	PrintList print = lis -> {
		
		Consumer<String> c = d -> {
			System.out.println(d);
	};
	lis.forEach(c);
	};
	print.display(list);
}


}
