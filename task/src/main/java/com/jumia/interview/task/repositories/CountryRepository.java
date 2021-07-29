package com.jumia.interview.task.repositories;

import com.jumia.interview.task.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
