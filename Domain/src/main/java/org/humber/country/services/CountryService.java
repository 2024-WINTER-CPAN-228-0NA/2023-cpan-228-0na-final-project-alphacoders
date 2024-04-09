package org.humber.country.services;

import org.humber.country.domain.Country;

import java.util.List;

public interface CountryService {

    Country createCountry(Country country);

    boolean deleteCountry(Long countryId);

    Country updateCountry(Country country);

    Country getCountry(Long countryId);

    List<Country> getAllCountries();
}
