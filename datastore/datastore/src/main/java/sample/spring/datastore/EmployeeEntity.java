package sample.spring.datastore;

// import javax.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name="employeesdata")
public class EmployeeEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String Department;
    private String Phone;
    private String Email;
}
