package org.humber.country.services.impl;

import lombok.NonNull;
import org.humber.country.domain.Country;
import org.humber.country.exceptions.ErrorCode;
import org.humber.country.exceptions.CountryValidationException;
import org.humber.country.services.CountryValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CountryNameValidation implements CountryValidationService {
    @Override
    public void validateCountry(@NonNull Country country) {
        if (country.getName() == null || !StringUtils.hasLength(country.getName().trim())) {
            System.err.println("Country name is null");
            throw new CountryValidationException(ErrorCode.INVALID_COUNTRY_NAME);
        }
    }
}
