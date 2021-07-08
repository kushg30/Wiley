package com.task;

import java.util.Comparator;
//case 3: sort : show all the objects sorted based on string whether that is username or simple string then integers
//expected sort : User{1,"Adam"},Hello,Hi,User{2,"User2"},1,2

public class Type3 implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		if (o1 instanceof User) {
			if (o2 instanceof User) {
				return new SortbyName().compare((User)o1, (User)o2);
				
			} else if (o2 instanceof String) {
				return new SortByString().compare(o1, o2);
				
			} else if (o2 instanceof Integer) {
				return -1;
			}
			
		}else if (o1 instanceof String) {
			if (o2 instanceof String) {
				return ((String)o1).compareTo((String)o2);
				
			} else if (o2 instanceof User) {
				return new SortByString().compare(o1, o2);
				
			} else if (o2 instanceof Integer) {
				return -1;
			}
			
		}else if (o1 instanceof Integer) {
			if (o2 instanceof Integer) {
				return (int)o1 - (int)o2;
				
			} else if (o2 instanceof User || o2 instanceof String) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
