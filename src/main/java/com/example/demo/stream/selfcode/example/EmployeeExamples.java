package com.example.demo.stream.selfcode.example;


import com.example.demo.stream.selfcode.dto.Employee2;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeExamples {
    public static void main(String[] args) {
        List<Employee2> empList = new ArrayList<>();
        createEmployeeList(empList);


//        1. ########################################## Program to print Min/Max employee salary from given Collection ####################################################################################

//      Approch 1
        Optional<Employee2> min = empList.stream().min(Comparator.comparingDouble(Employee2::getSalary));
        System.out.println(min.orElse(null));
        Optional<Employee2> max = empList.stream().max(Comparator.comparingDouble(Employee2::getSalary));
        System.out.println(max.orElse(null));
//      Approach 2
        Optional<Employee2> minSalaryEmp = empList.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee2::getSalary)));
        System.out.println(minSalaryEmp.orElse(null));
        Optional<Employee2> maxSalaryEmp = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary)));
        System.out.println(maxSalaryEmp.orElse(null));



//        2. ############################################## Program to print max salary of an employee from each department ####################################################################################
        Map<String, Optional<Employee2>> maxSalaryByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary))));
        System.out.println("2. ************** max salary of an employee from each department *****************************");
        maxSalaryByDepartment.forEach((key, value) -> System.out.println(key + ":" + value));




//        3.############################################ Program to print active and inactive employees in the given collection  ####################################################################################

        List<Employee2> activeEmpList = empList.stream().filter(x ->  "Yes".equalsIgnoreCase(x.getActive())).toList();
        System.out.println("3. ******************Active Employees*************************");
        activeEmpList.forEach(System.out::println);

//        3.1 find the count of active/inactive employee
        Map<String, Long> activeEmpCount = empList.stream().collect(Collectors.groupingBy(Employee2::getActive, Collectors.counting()));
        System.out.println("3.1. ******************Active/Inactive Employees Count*************************");
        activeEmpCount.forEach((key, value)-> System.out.println(key + ":" + value));

//        3.2 find the name of the employee based on active/inactive
        Map<String, List<String>> activeEmpName = empList.stream().collect(Collectors.groupingBy(Employee2::getActive, Collectors.mapping(Employee2::getName, Collectors.toList())));
        Map<String, List<Employee2>> collect1 = empList.stream().collect(Collectors.groupingBy(Employee2::getActive));
        System.out.println("3.2. ******************Active/Inactive Employees Name*************************");
        activeEmpName.forEach((key, value)-> System.out.println(key + ":" + value));




//        4. ##################################################### Program to print employee details working in each department  ####################################################################################
        Map<String, List<Employee2>> empByDepartment = empList.stream().collect(Collectors.groupingBy(Employee2::getDepartment));
        System.out.println("4. ****************** Department wise employee *************************");
        empByDepartment.forEach((key, value)-> System.out.println(key + ":" + value));

//      5.  print java department employee with the highest salary.
        Optional<Employee2> emap = empList.stream()
                .filter(x->x.getDepartment() == "Java")
                .max(Comparator.comparingDouble(Employee2::getSalary));

        Optional<Employee2> emap2 = empList.stream()
                .filter(x->x.getDepartment() == "Java").collect(Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary)));
        System.out.println("5. **************Department 'Java' Highest salary Employee *****************************");
        System.out.println(emap);
        System.out.println(emap2);

//      6. print the name of employee whose salary is greater than 20000
        List<String> collect = empList.stream().filter(x -> x.getSalary() > 20000).map(Employee2::getName).collect(Collectors.toList());
        System.out.println(collect);

        Map<String, Optional<Employee2>> data = empList.stream().collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary))));
        data.forEach((key,value)-> System.out.println( key+ ":--------:" +value.get().getSalary()));
    }
    private static void createEmployeeList(List<Employee2> empList){
        empList.add(new Employee2(111, "Ram", 32, "No", "HR", 2000, 9000));
        empList.add(new Employee2(112, "Laxman", 20, "Yes", "Java", 2001, 9000));
        empList.add(new Employee2(113, "Bharat", 18, "No", "Java", 2001, 22000));
        empList.add(new Employee2(114, "Strudhan", 20, "No", "Java", 2001, 25000));
        empList.add(new Employee2(115, "Rahim", 22, "Yes", "Python", 2002, 60000));
        empList.add(new Employee2(116, "Krishna", 30, "Yes", "HR", 2000, 43000));
        empList.add(new Employee2(117, "Hanuman", 30, "No", "HR", 2000, 54000));
        empList.add(new Employee2(118, "Shiv", 31, "No", "Python", 2002, 23000));
        empList.add(new Employee2(119, "Vishnu", 33, "Yes", "Finance", 2002, 65000));
        empList.add(new Employee2(120, "ShaniDev", 40, "Yes", "Finance", 2000, 83000));
    }

}
