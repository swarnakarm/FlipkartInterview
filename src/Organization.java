import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Organization {

	Map<String, Set<Employee>> heirarchy;
	Employee ceo;

	public Organization() {
		heirarchy = new HashMap<>();
	}

	public void addEmployee(Employee emp) {
		if (emp.getEmpType() == EmployeeType.CEO) {
			ceo = emp;
		} else {
			Set<Employee> empSet = heirarchy.getOrDefault(emp.getManagerId(), new HashSet<>());
			empSet.add(emp);
			heirarchy.put(emp.getManagerId(), empSet);
		}
	}

	public void printHeirarchy(String empId) {
		printHeirarchy(ceo, empId);
	}

	boolean printHeirarchy(Employee root, String cmpEmpId) {
		if (root == null) {
			return false;
		}
		if (root.getEmpId().equals(cmpEmpId)) {
			System.out.print(root.getEmpId());
			return true;
		}
		Set<Employee> set = heirarchy.get(root.getEmpId());
		if (set != null) {
			for (Employee emp : set) {
				if (printHeirarchy(emp, cmpEmpId)) {
					System.out.print(" -> ");
					System.out.print(root.getEmpId());
					return true;
				}
			}
		}
		return false;
	}

	List<Employee> topPerformers() {
		Search searchStrategy = new TopRatingSearch();
		return searchStrategy.search(ceo, heirarchy);
	}

}