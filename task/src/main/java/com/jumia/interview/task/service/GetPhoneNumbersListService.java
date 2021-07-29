package com.jumia.interview.task.service;

import com.jumia.interview.task.model.entity.Country;
import com.jumia.interview.task.model.entity.PhoneNumber;
import com.jumia.interview.task.model.entity.Status;
import com.jumia.interview.task.repositories.CountryRepository;
import com.jumia.interview.task.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetPhoneNumbersListService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    //getting all phoneNumber records
    public List<PhoneNumber> getAllPhoneNumbers()
    {
        return phoneNumberRepository.findAll();
    }

    //getting all phoneNumber records by status
    public List<PhoneNumber> getPhoneNumbersByStatus(Status status)
    {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumberRepository.findByStatus(status).forEach(phoneNumberRec -> phoneNumbers.add(phoneNumberRec));
        return phoneNumbers;
    }

    //getting all phoneNumber records by country
    public List<PhoneNumber> getPhoneNumbersByCountry(String countryName)
    {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumberRepository.findByCountryName(countryName).forEach(phoneNumberRec -> phoneNumbers.add(phoneNumberRec));
        return phoneNumbers;
    }

    //getting all phoneNumber records by country
    public List<PhoneNumber> getPhoneNumbersByCountryAndStatus(String countryName, Status status)
    {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumberRepository.findByCountryNameAndStatus(countryName,status).forEach(phoneNumberRec -> phoneNumbers.add(phoneNumberRec));
        return phoneNumbers;
    }

    //getting all country records
    public List<Country> getAllCountries()
    { return countryRepository.findAll();
    }
    //getting a specific country record
    public Country getSpecificCountry(String countryName)
    {
        return countryRepository.findById(countryName).get();
    }
}
