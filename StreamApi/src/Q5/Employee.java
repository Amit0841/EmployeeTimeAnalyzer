package Q5;

public class Employee {
	private String Emplid;
	private String name;
	private String designation;
	private double Salary;
	public Employee(String emplid, String name, String designation, double salary) {
		super();
		Emplid = emplid;
		this.name = name;
		this.designation = designation;
		Salary = salary;
	}
	public String getEmplid() {
		return Emplid;
	}
	public void setEmplid(String emplid) {
		Emplid = emplid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Emplid=" + Emplid + ", name=" + name + ", designation=" + designation + ", Salary=" + Salary
				+ "]";
	}
	
	
}
