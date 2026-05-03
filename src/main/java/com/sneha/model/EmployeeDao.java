package com.sneha.model;


import com.sneha.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = Constant.EMPLOYEE_DAO_TABLE_NAME)
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmployeeDao {

    private String name;
    private String email;

    @Id
    @UuidGenerator
    private String id;

    @CreationTimestamp
    @Column(name = Constant.EMPLOYEE_COLUMN_CREATEDAT, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = Constant.EMPLOYEE_COLUMN_UPDATEDAT)
    private LocalDateTime updatedAt;



}
