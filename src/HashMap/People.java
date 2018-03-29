package HashMap;

import java.util.HashMap;
import java.util.Set;

class People {
	private String name;
	private int age;

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() * 37 + age;
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((People) obj).name) && this.age == ((People) obj).age;
	}

	public static void main(String[] args) {
		People p1 = new People("Jack", 12);
		HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
		hashMap.put(p1, 1);

		System.out.println(hashMap.get(new People("Jack", 12)));
	}
}
