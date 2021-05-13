import java.util.List;

public class Main {

	
	public static void main(String[] args){
		Organization org = new Organization();
		Employee emp1 = new Employee("1","E1",1,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp1);
		Employee emp2 = new Employee("2","E2",2,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp2);
		Employee emp3 = new Employee("3","E3",3,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp3);
		Employee emp4 = new Employee("4","E4",1,EmployeeType.EMPLOYEE, "12");
		org.addEmployee(emp4);
		Employee emp5 = new Employee("5","E5",2,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp5);
		Employee emp6 = new Employee("6","E6",3,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp6);
		Employee emp7 = new Employee("7","E7",3,EmployeeType.EMPLOYEE, "12");
		org.addEmployee(emp7);
		Employee emp8 = new Employee("8","E8",3,EmployeeType.EMPLOYEE, "11");
		org.addEmployee(emp8);
		Employee emp9 = new Employee("9","E9",3,EmployeeType.EMPLOYEE, "12");
		org.addEmployee(emp9);
		Employee emp10 = new Employee("10","E10",2,EmployeeType.EMPLOYEE, "12");
		org.addEmployee(emp10);
		
		Employee mgr1 = new Employee("11","M1",1,EmployeeType.MANAGER, "13");
		org.addEmployee(mgr1);
		Employee mgr2 = new Employee("12","M2",2,EmployeeType.MANAGER, "13");
		org.addEmployee(mgr2);
		Employee sMgr1 = new Employee("13","SM1",2,EmployeeType.MANAGER, "14");
		org.addEmployee(sMgr1);
		Employee cMgr1 = new Employee("14","CEO1",1,EmployeeType.CEO, null);
		org.addEmployee(cMgr1);
		org.printHeirarchy("4");
		List<Employee> topPerformers = org.topPerformers();
		System.out.println();
		System.out.println("Top Performers");
		for(Employee emp: topPerformers){
			System.out.print(emp.getEmpId()+", ");
		}
	}
	
	
	
	
	
}
