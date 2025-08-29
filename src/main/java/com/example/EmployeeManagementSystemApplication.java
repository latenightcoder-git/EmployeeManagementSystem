package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... args) {
        // Sample Data
        repository.save(new Employee("Alice", "HR", 40000));
        repository.save(new Employee("Bob", "IT", 55000));
        repository.save(new Employee("Charlie", "Finance",
                60000));
        repository.save(new Employee("David", "Marketing",
                45000));
        repository.save(new Employee("Eva", "Sales", 50000));
        repository.save(new Employee("Frank", "IT", 70000));
    }
}
