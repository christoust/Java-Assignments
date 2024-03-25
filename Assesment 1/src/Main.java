import com.ust.assessment.Address;
import com.ust.assessment.Employee;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Employee, Address> empAddress = new HashMap<Employee,Address>();
        Employee emp1 = new Employee(1,"Christo");
        Employee emp2 = new Employee(2,"Akshaya");
        Employee emp3 = new Employee(3,"Sreelakshmi");
        Address emp1Address = new Address(20,"Ayarkunnam","Kottayaam",68654);
        Address emp2Address = new Address(21,"kannurStreet","kannur",68666);
        Address emp3Address = new Address(22,"kollamStreet","kollam",69664);
        empAddress.put(emp1,emp1Address);
        empAddress.put(emp2,emp2Address);
        empAddress.put(emp3,emp3Address);
        Address address = getAddress(empAddress,emp1);
        System.out.println(address);
//        List<>


    }
    public static Address getAddress (Map<Employee,Address>empAdd,Employee obj)
    {
        Address address = empAdd.get(obj);
        if(address==null)
        {
            System.out.println("Employee does not exist");
        }

        return address;


    }
}