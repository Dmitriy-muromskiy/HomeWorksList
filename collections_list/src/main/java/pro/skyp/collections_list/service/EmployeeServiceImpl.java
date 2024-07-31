package pro.skyp.collections_list.service;

import org.springframework.stereotype.Service;
import pro.skyp.collections_list.exseption.EmployeeAlreadyAddedException;
import pro.skyp.collections_list.exseption.EmployeeNotFoundException;
import pro.skyp.collections_list.model.Employee;


import java.util.*;
^
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);

        return employee;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            employeeMap.remove(employee.getFullName());
            return employeeMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();


    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();

    }
    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employeeMap.values());

    }
}
