package org.humber.country.services.impl;

import lombok.NonNull;
import org.humber.country.domain.Country;
import org.humber.country.exceptions.ErrorCode;
import org.humber.country.exceptions.CountryValidationException;
import org.humber.country.services.CountryValidationService;
import org.springframework.stereotype.Component;

@Component
public class CountryIdValidation implements CountryValidationService {
    @Override
    public void validateCountry(@NonNull Country country) {
        if(country.getCountryId() == null) {
            System.err.println("Country id is null");
            throw new CountryValidationException(ErrorCode.INVALID_COUNTRY_ID);
        }
    }
}
