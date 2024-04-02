import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStream {

    public static void main(String[] args) {
        EmployeeStream employeeStream = new EmployeeStream();
        employeeStream.getEmployeeWithSkill();
    }

    public void getEmployeeWithSkill() {
        List<EmployeeDetails> employees = new ArrayList<>();
        employees.add(new EmployeeDetails(4, "Blesson", 50000.0, "Python", "Development", 25, 3));
        employees.add(new EmployeeDetails(1, "Annu", 60000.0, "Python", "Analyst", 23, 1));
        employees.add(new EmployeeDetails(2, "Anjana", 70000.0, "java", "Analyst", 28, 4));
        employees.add(new EmployeeDetails(5, "Greeshma", 70000.0, "management", "HR", 24, 2));
        long totalEmp = employees.stream().count();
        System.out.println("Total number of employees " + totalEmp);
        Map<String, List<String>> empDept = employees.stream().collect(Collectors.groupingBy(EmployeeDetails::empDepartment, Collectors.mapping(EmployeeDetails::empName, Collectors.toList())));
        System.out.println("Employees grouped according to their department"+empDept);
        double salary = employees.stream().collect(Collectors.summingDouble(EmployeeDetails::empSalary));
        Map<String, Double> deptSalary = employees.stream().collect(Collectors.groupingBy(EmployeeDetails::empDepartment, Collectors.summingDouble(EmployeeDetails::empSalary)));
        System.out.println("Total salary paid to employees " + salary);
        System.out.println("Salary per dept" + deptSalary);
        Map<String, Map<String, Double>> salaryDeptEmp = employees.stream().collect(Collectors.groupingBy(EmployeeDetails::empDepartment, Collectors.toMap(EmployeeDetails::empName,EmployeeDetails::empSalary)));
        System.out.println(salaryDeptEmp);
        List<EmployeeDetails> sortAge = employees.stream().sorted(Comparator.comparingInt(EmployeeDetails::age)).toList();
        System.out.println("Sorted according to age of Employees");
        for (EmployeeDetails emp : sortAge) {
            System.out.println(emp.empName() + " age: " + emp.age() + "\n");
        }
        List<EmployeeDetails> sortExp = employees.stream().sorted(Comparator.comparingDouble(EmployeeDetails::experience)).toList();
        System.out.println("Sorted according to experience of Employees");
        for (EmployeeDetails emp : sortExp)
        {
            System.out.println(emp.empName()+" experience: " + emp.experience()+ "\n");
        }
        List<String> countries = Arrays.asList("Uzbekistan","Japan","India","America","Argentina");
        String longestName = countries.stream().reduce((x,y)->x.length()>y.length()?x:y).get();
        System.out.println("Country with longest name "+longestName);

    }
}
