package org.humber.country.controllers;



import org.humber.country.domain.Country;
import org.humber.country.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {



    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country createdCountry = countryService.createCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @GetMapping("/{countryId}")
    public Country getCountryById(@PathVariable Long countryId) {
        return countryService.getCountry(countryId);
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long countryId, @RequestBody Country country) {
        country.setCountryId(countryId);
        Country updatedCountry = countryService.updateCountry(country);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long countryId) {
        boolean deleted = countryService.deleteCountry(countryId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
