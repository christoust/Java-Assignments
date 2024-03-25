public class Employee {

    private int empId;
    private String empName;
    private double empSalary;
    private String skill;
    private String empDepartment;
    private int age;
    private float experience;

    public Employee(int empId, String empName, double empSalary, String skill,String empDepartment,int age,float experience) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.skill = skill;
        this.empDepartment = empDepartment;
        this.age=age;
        this.experience = experience;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEmpDepartment()
    {
        return empDepartment;
    }

    public  void setEmpDepartment(String empDepartment)
    {
        this.empDepartment=empDepartment;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

    public float getExperience(){return experience;}

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", skill='" + skill + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", age=" + age + '\''+
                ", experience=" + experience +
                '}';
    }
}
