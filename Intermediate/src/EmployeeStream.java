import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStream {

    public void getEmployeeWithSkill() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(4, "Blesson", 50000.0, "Python"));
        employees.add(new Employee(1, "Annu", 60000.0, "Python"));
        employees.add(new Employee(2, "Anjana", 70000.0, "java"));
        employees.add(new Employee(5, "Greeshma", 70000.0, "sql"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the skill: ");
        String skill = sc.next();
        try {
            List<String> skilled = employees.stream().filter((e) -> e.getSkill().equalsIgnoreCase(skill)).map(Employee::getEmpName).toList();
            if (skilled.isEmpty()) {
                throw new EmlpoyeeNotFoundException("Employee with skill " + skill + " not found");

            } else {
                System.out.println("Employees skilled in " + skill + " are");
                skilled.forEach(System.out::println);
            }
        } catch (EmlpoyeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
