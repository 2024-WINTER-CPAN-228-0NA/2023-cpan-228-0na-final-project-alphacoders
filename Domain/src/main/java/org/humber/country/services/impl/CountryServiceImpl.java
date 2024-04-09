package org.humber.country.services.impl;

import org.humber.country.domain.Country;
import org.humber.country.exceptions.ErrorCode;
import org.humber.country.exceptions.CountryValidationException;
import org.humber.country.services.CountryJPAService;
import org.humber.country.services.CountryService;
import org.humber.country.services.CountryValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryJPAService countryJpaService;
    private final List<CountryValidationService> validationServices;

    @Autowired
    public CountryServiceImpl(CountryJPAService countryJpaService, List<CountryValidationService> validationService) {
        this.countryJpaService = countryJpaService;
        this.validationServices = validationService;
    }




    @Override
    public Country createCountry(Country country) {
        System.out.println("In method createCountry, validating country= " + country.toString());
        for (CountryValidationService validationService : validationServices) {
            if (validationService instanceof CountryIdValidation) {
                System.out.println("Skipping the validation");
                continue;
            }
            validationService.validateCountry(country);
        }
        System.out.println("Saving country");
        return countryJpaService.saveCountry(country);
    }

    @Override
    public boolean deleteCountry(Long countryId) {
        System.out.println("Deleting country");
        Country country = countryJpaService.getCountryById(countryId);
        return country != null;
    }

    @Override
    public Country updateCountry(Country country) {
        //TODO: implemet the update but not needed
        System.out.println("Updating country");
        return null;
    }

    @Override
    public Country getCountry(Long countryId) {
        System.out.println("Getting country");
        if(countryId == null) {
            System.err.println("Country id is null");
            throw new CountryValidationException(ErrorCode.INVALID_COUNTRY_ID);
        }
        return countryJpaService.getCountryById(countryId);
    }



    @Override
    public List<Country> getAllCountries() {
        return countryJpaService.getAllCountries();
    }
}
