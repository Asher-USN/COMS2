
public class Dog {
	
	//2864809
	String name;
	int age;
public Dog(String n, int a) {
	name = n;
	age = a;
	
}

public void bark() {
	System.out.println(getName() + ":woof");
}
public void setName(String n) {
	name = n;
}
public String getName(){
	return name;
}
public void setAge(int a) {
	age = a;
}

public int getAge() {
	return age;
}

}
