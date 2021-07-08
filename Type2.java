package com.task;

import java.util.Comparator;
//case 2: sort : show me sorted strings then users sorted by user id then integers

//expected sort : Hello,Hi, User{1, "Adam"}, User{2,"User2"},1,2
public class Type2 implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {

		if (o1 instanceof String) {
			if (o2 instanceof String) {
				return ((String)o1).compareTo((String)o2);
				
			} else if (o2 instanceof User || o2 instanceof Integer) {
				return -1;
				
			}
			return 0;
		}else if (o1 instanceof User) {
			if (o2 instanceof User) {
				return new SortbyId().compare((User)o1,(User)o2);

			} else if (o2 instanceof Integer) { 
				return -1;
			} else if (o2 instanceof String) {
				return 1;
			}
			return 0;
		} else if (o1 instanceof Integer) {
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
