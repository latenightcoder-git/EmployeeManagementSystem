package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    public Page<Employee> getPaginatedEmployees(int pageNo,
                                                int pageSize, String sortField, String sortDirection) {
        Sort sort =
                sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,
                sort);
        return repository.findAll(pageable);
    }
    public void saveEmployee(Employee emp) {
        repository.save(emp);
    }
}

