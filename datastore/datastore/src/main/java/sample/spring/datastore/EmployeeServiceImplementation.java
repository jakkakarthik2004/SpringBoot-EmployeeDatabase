package sample.spring.datastore;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    // This class will implement the EmployeeService interface
    // It will handle the business logic related to Employee operations
    
    @Override
    public List<Employee> getAllEmployees(){
        // This method will interact with the data layer to retrieve all employees

        List<EmployeeEntity> getData=employeeRepository.findAll();
        

    List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity i:getData){
            Employee setting =new Employee();
            setting.setId(i.getId());
            setting.setName(i.getName());
            setting.setDepartment(i.getDepartment());
            setting.setMail(i.getEmail());
            setting.setPhone(i.getPhone());
            employees.add(setting);
        }

        return employees;

    }
    @Override
    public String createEmployee(Employee employee){
        // employees.add(employee);
        EmployeeEntity empo=new EmployeeEntity();
        
        BeanUtils.copyProperties(employee, empo);
        empo.setEmail(employee.getMail());
        employeeRepository.save(empo);
        return "create successfully";
    }

    @Override
    public Employee getEmployeeById(long id){
        // This method will interact with the data layer to retrieve an employee by ID
        EmployeeEntity getById=employeeRepository.findById(id).get();


        Employee onId=new Employee();
        onId.setId(getById.getId());
        onId.setDepartment(getById.getDepartment());
            onId.setName(getById.getName());
            onId.setMail(getById.getEmail());
            onId.setPhone(getById.getPhone());
        return onId;
    }

    @Override
    public boolean deleteEmployee(long id){
        // This method will interact with the data layer to delete an employee by ID
        EmployeeEntity getById=employeeRepository.findById(id).get();
        employeeRepository.delete(getById);
    //     Iterator<Employee> iterator = employees.iterator();
    // while (iterator.hasNext()) {
    //     Employee emp = iterator.next();
    //     if (emp.getId() == id) {
    //         iterator.remove(); 
    //         return true;
    //     }
    // }
    // return false;
        // return false;
        return true;
    }

    @Override
    public String updateEmployee(long id,Employee employee){

        EmployeeEntity getById=employeeRepository.findById(id).get();


        // Employee onId=new Employee();
        // onId.setId(getById.getId());
        getById.setDepartment(employee.getDepartment());

        getById.setName(employee.getName());
        getById.setPhone(employee.getPhone());
        getById.setEmail(employee.getMail());
            // onId.setName(getById.getName());
            // onId.setMail(getById.getEmail());
            // onId.setPhone(getById.getPhone());
            employeeRepository.save(getById);
        return "Updated SUccessFull";
        // for(Employee emp:employees){
        //     if(emp.getId()==id){
        //         emp.setName(employee.getName());
        //         emp.setDepartment(employee.getDepartment());
        //         emp.setMail(employee.getMail());
        //         emp.setPhone(employee.getPhone());
        //         return "update successfully";
        //     }
        // }
        // return "Employee not found";
    }

}
