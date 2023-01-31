package dependencias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> emp = new ArrayList<>();
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		for(int c = 0; c < n; c++) {
			System.out.println("Employee #"+(c+1)+":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(emp, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			emp.add(new Employee(id, name, salary));
		}
		
		System.out.println("Enter the employee id that will have salary increase : ");
		Integer id = sc.nextInt();
		
		
		Integer pos = findId(emp, id);
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.get(pos).increaseSalary(percentage);
		}
		
		System.out.println("List of employees: ");
		for (Employee x : emp) {
			System.out.println(x);
			}

		
		sc.close();
	}
	public static boolean hasId(List<Employee> emp, int id) {
		Employee emp2 = emp.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp2 != null;			
	}
	
	public static Integer findId(List<Employee> emp, int id) {
		for(int c = 0; c < emp.size(); c++) {
			if(emp.get(c).getId() == id) {
				return c;
			}
		}
		return null;
	}
	
}
