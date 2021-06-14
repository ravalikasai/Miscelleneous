package com.cts;

import java.lang.reflect.Array;
import java.util.List;

public class jdbcHandler {
	
	public void display(List list) {
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
	}

}
