import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStream {

    public static void main(String[] args) {
        EmployeeStream employeeStream = new EmployeeStream();
        employeeStream.getEmployeeWithSkill();
    }

    public void getEmployeeWithSkill() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(4, "Blesson", 50000.0, "Python", "Development", 25, 3));
        employees.add(new Employee(1, "Annu", 60000.0, "Python", "Analyst", 23, 1));
        employees.add(new Employee(2, "Anjana", 70000.0, "java", "testing", 28, 4));
        employees.add(new Employee(5, "Greeshma", 70000.0, "management", "HR", 24, 2));
        long totalEmp = employees.stream().count();
        System.out.println("Total number of employees " + totalEmp);
        Map<String, List<String>> empDept = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDepartment, Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        System.out.println("Employees grouped according to their department"+empDept);
        double salary = employees.stream().collect(Collectors.summingDouble(Employee::getEmpSalary));
        Map<String, Long> deptSalary = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDepartment, Collectors.summingLong(e -> (long) e.getEmpSalary())));
        System.out.println("Total salary of employees " + salary);
        System.out.println("Salary per dept" + deptSalary);
        Map<String, Map<String, Long>> salaryDeptEmp = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDepartment, Collectors.toMap(Employee::getEmpName, e -> (long) e.getEmpSalary())));
        System.out.println(salaryDeptEmp);
        List<Employee> sortAge = employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).toList();
        System.out.println("Sorted according to age of Employees");
        for (Employee emp : sortAge) {
            System.out.println(emp.getEmpName() + " age: " + emp.getAge() + "\n");
        }
        List<Employee> sortExp = employees.stream().sorted(Comparator.comparingDouble(Employee::getExperience)).toList();
        System.out.println("Sorted according to experience of Employees");
        for (Employee emp : sortExp)
        {
            System.out.println(emp.getEmpName()+" experience: " + emp.getExperience()+ "\n");
        }
        List<String> countries = Arrays.asList("Japan","India","America","Argentina");
        String longestName = countries.stream().reduce((x,y)->x.length()>y.length()?x:y).get();
        System.out.println("Country with longest name "+longestName);

    }
}
