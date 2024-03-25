import java.util.*;

public class EmpolyeeInfo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(4, "Blesson", 50000.0,"java", "HR",30,2));
        employees.add(new Employee(1, "Annu",  60000.0, "java","Development",22,3));
        employees.add(new Employee(2, "Anjana",  70000.0,"python", "Sales",23,4));
//        employees.add(new Employee(5, "Greeshma",  70000.0,,"sql", "Marketing"));
//        employees.add(new Employee(3, "Christo",  70000.0, "Marketing"));
//        employees.add(new Employee(2, "Anjana", 70000.0, "Marketing"));


        Set<Integer> employeeIDs = new HashSet<>();


        for (Employee record : employees) {
            employeeIDs.add(record.getEmpId());
        }
        List<Integer> sortedEmployeeIDs = new ArrayList<>(employeeIDs);
        sortedEmployeeIDs.sort(Collections.reverseOrder());
        Map<Integer, Employee> employeeInfo = new HashMap<>();

        for (int empID : sortedEmployeeIDs) {
            for (Employee record : employees) {
                if (record.getEmpId() == empID) {
                    employeeInfo.put(empID, record);
                    break;
                }
            }
        }
        for (int empID : sortedEmployeeIDs) {
            System.out.println("Details of Employee with id: " + empID);
            Employee ob = employeeInfo.get(empID);
            System.out.println("\tEmployee Name: " + ob.getEmpName());
            System.out.println("\tEmployee email: " + ob.getEmpSalary());
            System.out.println("\tEmployee Salary: " + ob.getEmpSalary());
        }
    }
}

