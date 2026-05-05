package com.sneha.service;

import com.sneha.Constant;

import com.sneha.exception.DuplicateEmployeeException;
import com.sneha.exception.InternalSystemException;
import com.sneha.exception.ValidationException;
import com.sneha.model.EmployeeDao;
import com.sneha.store.EmployeeRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private EmployeeRepository employeeRepository;

  public  String registerEmployee(String name, String email) throws ValidationException, InternalSystemException, DuplicateEmployeeException {

        if(name == null || name.isEmpty()){
            log.error("Name is null or empty");
            throw new ValidationException(Constant.NAME_VALIDATION_EXCEPTION_MESSAGE);
        }
        if(email == null || email.isEmpty()){
            throw new ValidationException(Constant.EMAIL_VALIDATION_EXCEPTION_MESSAGE);
        }
        boolean employeeAlreadyPresent;

        try{
            employeeAlreadyPresent=  employeeRepository.findByEmail(email).isPresent();
        }
        catch (Exception e){
           throw new InternalSystemException(Constant.INTERNAL_SYSTEM_EXCEPTION_MESSAGE) ;
        }

        if(employeeAlreadyPresent)
        {

            throw new DuplicateEmployeeException(Constant.DUPLICATE_EMPLOYEE_EXCEPTION_MESSAGE);
        }

        EmployeeDao updatedEmployee;

        try {
            updatedEmployee = employeeRepository.save(EmployeeDao.builder().name(name).email(email).build());
        }
        catch (Exception e){
            throw new InternalSystemException(Constant.INTERNAL_SYSTEM_EXCEPTION_MESSAGE) ;
        }

        String id;
        try{
            id = updatedEmployee.getId();
        }
        catch (Exception e){
            throw new InternalSystemException(Constant.INTERNAL_SYSTEM_EXCEPTION_MESSAGE) ;
        }

        return id;

    }

    public boolean validateEmployee(String id) throws ValidationException, InternalSystemException {
      if(id == null || id.isEmpty()){
          throw new ValidationException(Constant.ID_VALIDATION_EXCEPTION_MESSAGE);
      }
        boolean validEmployee;
      try {
          validEmployee = employeeRepository.findById(id).isPresent();
      }
      catch (Exception e){
          throw new InternalSystemException(Constant.INTERNAL_SYSTEM_EXCEPTION_MESSAGE) ;
      }

      if(!validEmployee){
            throw  new ValidationException(Constant.INVALID_ID_VALIDATION_EXCEPTION_MESSAGE);
      }

      return validEmployee;

    }
}
