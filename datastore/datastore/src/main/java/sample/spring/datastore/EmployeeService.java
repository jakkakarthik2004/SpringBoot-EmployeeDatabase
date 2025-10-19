package sample.spring.datastore;

import org.springframework.stereotype.Service;
import java.util.*;

// @Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    String createEmployee(Employee employee);
    Employee getEmployeeById(long id);
    boolean deleteEmployee(long id);
    String updateEmployee(long id,Employee employee);
}