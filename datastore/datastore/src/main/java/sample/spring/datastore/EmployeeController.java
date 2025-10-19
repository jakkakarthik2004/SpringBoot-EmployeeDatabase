package sample.spring.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    // This class will handle HTTP requests related to Employee operations
    // For example, methods for creating, retrieving, updating, and deleting employees
    // will be defined here in the future.
    //like preface of for the backside it receives the request and sends to below sevice layer
    @Autowired
    EmployeeService empservice;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        // This method will interact with the service layer to retrieve all employees
        
        return empservice.getAllEmployees();
    }
    
    @PostMapping("/employees/create")
    public  String createEmployee(@RequestBody Employee employee){
        return empservice.createEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id){
        return empservice.getEmployeeById(id);
    }
    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        boolean x=empservice.deleteEmployee(id);
        if(x){
            return "Deleteddd successfully";
        }else{
            return "faileded to delete";
        }
    }
    @PutMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable long id,@RequestBody Employee emp){
        return empservice.updateEmployee(id, emp);
    }
}
