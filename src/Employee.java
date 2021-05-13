
public class Employee {

	private String empId;
	private String managerId;
	private String name;
	private int rating;
	private EmployeeType empType;

	public Employee() {

	}

	public Employee(String empId, String name, 
			int rating, EmployeeType empType, String managerId) {
		this.empId = empId;
		this.name = name;
		this.rating = rating;
		this.empType = empType;
		this.managerId = managerId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public EmployeeType getEmpType() {
		return empType;
	}

	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}

}