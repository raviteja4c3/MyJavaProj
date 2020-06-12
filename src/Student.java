public class Student implements Comparable<Student> {

    private int empId;
    private String empName;
    private int Age;

    public Student() {

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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", Age=" + Age +
                '}';
    }
    public Student(int empId, String empName, int age) {
        this.empId = empId;
        this.empName = empName;
        Age = age;
    }

    @Override
    public int compareTo(Student S) {
        if(this.getAge() > S.getAge() && this.getEmpId() > S.getEmpId())
        return 1;
        return -1;
    }
}
