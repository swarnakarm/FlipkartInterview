import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Search {

	public List<Employee> search(Employee root, Map<String, Set<Employee>> heirarchy);
	
}
