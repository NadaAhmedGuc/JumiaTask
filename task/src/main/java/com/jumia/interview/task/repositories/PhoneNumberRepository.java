package com.jumia.interview.task.repositories;

import com.jumia.interview.task.model.entity.PhoneNumber;
import com.jumia.interview.task.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {

    List<PhoneNumber> findByStatus(Status status);

    List<PhoneNumber> findByCountryName(String countryName);

    List<PhoneNumber> findByCountryNameAndStatus(String countryName, Status status);
}
