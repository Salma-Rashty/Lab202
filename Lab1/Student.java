package Lab202;

public class Student{
	 public String name;
	 public String department;
	 public int ID;
	 
	public Student(String name, String department, int ID) {
		this.name = name;
		this.department = department;
		this.ID = ID;
	}
	public String toString() {
		return "Name: " +this.name+"\nDepartment: "+this.department+"\nID: "+this.ID;
	}
}
