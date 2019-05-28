package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {

        List<String> someNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G50", "G60",
                "I26", "I17", "I29",
                "O71"
        );

        EmployeeChallenge john = new EmployeeChallenge("John Doe", 30);
        EmployeeChallenge jane = new EmployeeChallenge("Jane Deer", 25);
        EmployeeChallenge jack = new EmployeeChallenge("Jack Hill", 40);
        EmployeeChallenge snow = new EmployeeChallenge("Snow White", 22);

        DepartmentChallenge hr = new DepartmentChallenge("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        DepartmentChallenge accounting = new DepartmentChallenge("Accounting");
        accounting.addEmployee(john);

        List<DepartmentChallenge> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(departmentChallenge -> departmentChallenge.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("------------------------------");

        List<String> sortedGNumbers = someNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<EmployeeChallenge>> groupedByAge = departments.stream()
                .flatMap(departmentChallenge -> departmentChallenge.getEmployees().stream())
                .collect(Collectors.groupingBy(employeeChallenge -> employeeChallenge.getAge()));


        departments.stream()
                .flatMap(departmentChallenge -> departmentChallenge.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

    }
}
