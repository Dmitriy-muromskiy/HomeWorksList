package pro.skyp.collections_list.service;

import pro.skyp.collections_list.model.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);
    Employee findEmployee(Employee searchEmployee);

}
