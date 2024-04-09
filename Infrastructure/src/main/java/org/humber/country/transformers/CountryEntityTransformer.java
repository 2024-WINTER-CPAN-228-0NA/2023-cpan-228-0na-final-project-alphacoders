package org.humber.country.transformers;

import org.humber.country.domain.Country;
import org.humber.country.repositories.entities.CountryEntity;

import java.util.List;
import java.util.stream.Collectors;


public final class CountryEntityTransformer {

    private CountryEntityTransformer() {
    }

    public static CountryEntity transformToCountryEntity(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryId(country.getCountryId());
        countryEntity.setName(country.getName());
        countryEntity.setPopulation(country.getPopulation());
        return countryEntity;
    }


    public static Country transformToCountry(CountryEntity countryEntity) {
        return Country.builder()
                .countryId(countryEntity.getCountryId())
                .name(countryEntity.getName())
                .population(countryEntity.getPopulation())
                .build();
    }


    public static List<Country> transformToCountries(List<CountryEntity> entities) {
        return entities.stream()
                .map(CountryEntityTransformer::transformToCountry)
                .collect(Collectors.toList());
    }
}
