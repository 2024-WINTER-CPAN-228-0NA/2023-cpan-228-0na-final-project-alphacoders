package org.humber.country.repositories;

import org.humber.country.repositories.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryJPARepository extends JpaRepository<CountryEntity, Long> {

}
