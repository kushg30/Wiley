package com.task;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
/*----------TASK--------------------------------------

set = [2,1, User{2,"User2"},User{1,"Adam"},Hi,Hello]

integers
users
strings

case 1: sort : show the integers first then users sorted by user id then strings

expected sort : 1,2,User{1,"Adam"}, User{2,"User2"} (user by id),Hello,Hi

case 2: sort : show me sorted strings then users sorted by user id then integers

expected sort : Hello,Hi, User{1, "Adam"}, User{2,"User2"},1,2

case 3: sort : show all the objects sorted based on string whether that is username or simple string then integers

expected sort : User{1,"Adam"},Hello,Hi,User{2,"User2"},1,2

-------------------------------------------------------
*/

class User {
	private int id;
	private String name;

	User() {}

	User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}

class SortbyId implements Comparator<User>{
	@Override
	public int compare(User o1, User o2) {
		return o1.getId() - o2.getId();
	}
}

class SortByString implements Comparator<Object>{
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof User) {
			if(o2 instanceof String) {
				return ((User)o1).getName().compareTo((String)o2);
			}
		}else if(o1 instanceof String) {
			if(o2 instanceof User) {
				return ((String)o1).compareTo(((User)o2).getName());
			}
		}
		return 0;
	}
}

class SortbyName implements Comparator<User>{
	@Override
	public int compare(User o1, User o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

public class ComparatorSorting {

	public static void main(String[] args) {
		Set<Object> set = new TreeSet<Object>(new Type3());
		set.add(2);
		set.add(1);
		set.add(new User(2, "User2"));
		set.add(new User(1, "Adam"));
		set.add(new String("Hi"));
		set.add(new String("Hello"));

		set.forEach(e -> System.out.println(e));

	}

}
