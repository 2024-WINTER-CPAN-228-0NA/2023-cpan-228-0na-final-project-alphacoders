package org.humber.country.services;

import org.humber.country.domain.Country;

import java.util.List;

public interface CountryJPAService {

    Country getCountryById(Long countryId);

    List<Country> getAllCountries();

    Country saveCountry(Country country);

}
