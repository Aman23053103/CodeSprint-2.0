import java.util.Scanner;
interface Employee {
void getDetails();
}
interface Manager extends Employee {
void getDeptDetails();
}

class Head implements Manager {
int empId;
String empName;
int deptId;
String deptName;
public void getDetails() {
Scanner sc = new Scanner(System.in);
System.out.print("Enter employee_id:");
empId = sc.nextInt();
sc.nextLine();
System.out.print("Enter employee_name:");
empName = sc.nextLine();
}
public void getDeptDetails() {
Scanner sc = new Scanner(System.in);
System.out.print("Enter department_id:");
deptId = sc.nextInt();
sc.nextLine();
System.out.print("Enter department_name:");
deptName = sc.nextLine();
}
public void displayDetails() {
System.out.println("Employee Id : " + empId);
System.out.println("Employee Name : " + empName);
System.out.println("Department Id : " + deptId);
System.out.println("Department Name : " + deptName);
}
}
public class EmployeeDetails {
public static void main(String[] args) {
Head head = new Head();
head.getDetails();
head.getDeptDetails();
head.displayDetails();
}
}
