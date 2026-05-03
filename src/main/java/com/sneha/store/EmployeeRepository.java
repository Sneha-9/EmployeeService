package com.sneha.store;

import com.sneha.model.EmployeeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDao, String> {
     Optional<EmployeeDao> findByEmail(String email);
}
