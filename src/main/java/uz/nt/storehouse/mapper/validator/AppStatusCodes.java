package uz.nt.storehouse.mapper.validator;

import jakarta.persistence.criteria.CriteriaBuilder;

public class AppStatusCodes {
    public static final Integer VALIDATION_ERROR_CODE = -2;
    public static final Integer NOT_FOUND_ERROR_CODE = -1;
    public static final Integer OK_CODE = 0;
    public static final Integer DATABASE_ERROR_CODE = 1;
    public static final Integer UNEXPECTED_ERROR_CODE = 2;
    public static final Integer DUPLICATE_ERROR_CODE = 3;
}
