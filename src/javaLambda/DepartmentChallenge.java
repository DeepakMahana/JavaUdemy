package javaLambda;

import java.util.ArrayList;
import java.util.List;

public class DepartmentChallenge {

    private String name;
    private List<EmployeeChallenge> employees;

    public DepartmentChallenge(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(EmployeeChallenge employee){
        employees.add(employee);
    }

    public List<EmployeeChallenge> getEmployees() {
        return employees;
    }
}
