package org.humber.country.services.impl;

import org.humber.country.domain.Country;
import org.humber.country.repositories.CountryJPARepository;
import org.humber.country.repositories.entities.CountryEntity;
import org.humber.country.services.CountryJPAService;
import org.humber.country.transformers.CountryEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.humber.country.transformers.CountryEntityTransformer.transformToCountry;
import static org.humber.country.transformers.CountryEntityTransformer.transformToCountryEntity;

@Service
public class CountryJPAServiceImpl implements CountryJPAService {

    private final CountryJPARepository countryJPARepository;

    @Autowired
    public CountryJPAServiceImpl(CountryJPARepository countryJPARepository) {
        this.countryJPARepository = countryJPARepository;
    }

    @Override
    public Country getCountryById(Long countryId) {
        return countryJPARepository.findById(countryId)
                .map(CountryEntityTransformer::transformToCountry)
                .orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return Optional.of(countryJPARepository.findAll())
                .map(CountryEntityTransformer::transformToCountries)
                .orElse(null);
    }

    @Override
    public Country saveCountry(Country country) {
        CountryEntity countryEntity = transformToCountryEntity(country);
        CountryEntity savedEntity = countryJPARepository.save(countryEntity);
        return transformToCountry(savedEntity);
    }
}
