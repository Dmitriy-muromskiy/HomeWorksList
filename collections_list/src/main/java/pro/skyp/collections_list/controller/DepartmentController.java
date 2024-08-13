package pro.skyp.collections_list.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.skyp.collections_list.model.Employee;
import pro.skyp.collections_list.service.DepartmentService;

import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee getMaxSalary(int departmentId) {
        return departmentService.getEmployeeMaxSalary(departmentId);

    }

    @GetMapping("/mix-salary")
    public Employee getMixSalary(int departmentId) {
        return departmentService.getEmployeeMinSalary(departmentId);

    }
    @GetMapping(value = "/all",params = "departmentId")
    public List<Employee> getAllEmployee(Integer departmentId){
        return  departmentService.getEmployee(departmentId);

    }
    @GetMapping("/all")
    public Map<Integer,List<Employee>> getAllEmployeeByDepartment(){
        return  departmentService.getGroupEmployeeByDepartment();

    }

}
