package pro.skyp.collections_list.service;

import pro.skyp.collections_list.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }
}
