package com.sneha;

public class Constant {
    public static final String NAME_VALIDATION_EXCEPTION_MESSAGE = "Name cannot be empty or null";
    public static final String ID_VALIDATION_EXCEPTION_MESSAGE = "Id cannot be empty or null";
    public static final String INVALID_ID_VALIDATION_EXCEPTION_MESSAGE = "Invalid Id provided";
    public static final String DUPLICATE_EMPLOYEE_EXCEPTION_MESSAGE = "Employee already exists";
    public static final String EMAIL_VALIDATION_EXCEPTION_MESSAGE = "Email cannot be null or empty";
    public static final String INTERNAL_SYSTEM_EXCEPTION_MESSAGE = "Something went wrong, please try again";

    public static final String EMPLOYEE_REGISTER_PATH = "/employee/registration";
    public static  final String EMPLOYEE_VALIDATION_PATH = "/employee/validation";

    public static final String API_RESPONSE_MEDIA_TYPE = "application/json";
    public static final String EMPLOYEE_DAO_TABLE_NAME ="employees";
    public static final String EMPLOYEE_COLUMN_CREATEDAT = "createdat";
    public static final String EMPLOYEE_COLUMN_UPDATEDAT = "updatedat";

}
