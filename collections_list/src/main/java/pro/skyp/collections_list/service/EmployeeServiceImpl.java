package pro.skyp.collections_list.service;

import org.springframework.stereotype.Service;
import pro.skyp.collections_list.exseption.EmployeeNotFoundException;
import pro.skyp.collections_list.exseption.EmployeeStorageIsFullException;
import pro.skyp.collections_list.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_EMPLOYEES = 100;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Andrey", "Sokolov"),
            new Employee("Ivan", "Ivanov"),
            new Employee("Oleg", "Petrov")
    ));


    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);
        } else {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        Employee employeeToRemove = findEmployee(employee);
            if (employeeToRemove != null) {
                employees.remove(employeeToRemove);
            } else {
                throw new EmployeeNotFoundException("Employee not found: "
                        + employee.getFirstName() + " " + employee.getLastName());
            }
        }
    @Override
    public Employee findEmployee(Employee searchEmployee) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(searchEmployee.getFirstName())
                    && employee.getLastName().equals(searchEmployee.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found: "
                + searchEmployee.getFirstName() + " " + searchEmployee.getLastName());
    }


}

