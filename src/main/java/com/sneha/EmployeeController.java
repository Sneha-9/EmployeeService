package com.sneha;

import com.sneha.employeeservice.EmployeeRegisterRequest;
import com.sneha.employeeservice.EmployeeRegisterResponse;
import com.sneha.employeeservice.EmployeeValidationRequest;
import com.sneha.employeeservice.EmployeeValidationResponse;
import com.sneha.exception.DuplicateEmployeeException;
import com.sneha.exception.InternalSystemException;
import com.sneha.exception.ValidationException;
import com.sneha.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping(value = Constant.EMPLOYEE_REGISTER_PATH, consumes = Constant.API_RESPONSE_MEDIA_TYPE, produces = Constant.API_RESPONSE_MEDIA_TYPE)
    EmployeeRegisterResponse registerEmployee(@RequestBody EmployeeRegisterRequest employeeRegisterRequest) throws ValidationException, DuplicateEmployeeException, InternalSystemException {
        log.info("strarting "+ employeeRegisterRequest.getName());
      String response = employeeService.registerEmployee(employeeRegisterRequest.getName(),employeeRegisterRequest.getEmail());

      return EmployeeRegisterResponse.newBuilder().setId(response).build();

    }

    @PostMapping(value = Constant.EMPLOYEE_VALIDATION_PATH, produces = Constant.API_RESPONSE_MEDIA_TYPE)
    EmployeeValidationResponse validateEmployee(@RequestBody EmployeeValidationRequest employeeValidationRequest) throws ValidationException, InternalSystemException {
      boolean response =  employeeService.validateEmployee(employeeValidationRequest.getId());

      return EmployeeValidationResponse.newBuilder().setIsValid(response).build();
    }
}
