package org.humber.country.services;

import org.humber.country.domain.Country;

public interface CountryValidationService {
    void validateCountry(Country country);
}
