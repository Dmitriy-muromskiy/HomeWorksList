package pro.skyp.collections_list.service;


import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;
import pro.skyp.collections_list.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeMinSalary(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeMaxSalary(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployee(int department){
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> getGroupEmployeeByDepartment(){
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
