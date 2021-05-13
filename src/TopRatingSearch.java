import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopRatingSearch implements Search {

	@Override
	public List<Employee> search(Employee root, Map<String, Set<Employee>> heirarchy) {
		List<Employee> result = new ArrayList<>();
		Queue<Employee> bfsQueue = new LinkedList<>();
		bfsQueue.add(root);
		while (!bfsQueue.isEmpty()) {
			Employee currEmp = bfsQueue.remove();
			if (currEmp.getRating() == 1) {
				result.add(currEmp);
			}
			Set<Employee> empSet = heirarchy.get(currEmp.getEmpId());
			if (empSet != null) {
				for (Employee emp : empSet) {
					bfsQueue.add(emp);
				}
			}
		}
		return result;
	}

}
