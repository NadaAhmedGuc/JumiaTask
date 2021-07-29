package com.jumia.interview.task.controller;

import com.jumia.interview.task.model.entity.Country;
import com.jumia.interview.task.model.entity.PhoneNumber;
import com.jumia.interview.task.model.entity.PhoneNumberListResponseModel;
import com.jumia.interview.task.repositories.PhoneNumberRepository;
import com.jumia.interview.task.service.GetPhoneNumbersListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneNumberController {

    private final GetPhoneNumbersListService getPhoneNumbersListService;
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberController(GetPhoneNumbersListService getPhoneNumbersListService, PhoneNumberRepository phoneNumberRepository) {
        this.getPhoneNumbersListService = getPhoneNumbersListService;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @GetMapping("/allPhoneNumbers")
    public List<PhoneNumberListResponseModel> allPhoneNumbers(){
        List<PhoneNumberListResponseModel> responseModelList = new ArrayList<PhoneNumberListResponseModel>();
        List<PhoneNumber> phoneNumbers = getPhoneNumbersListService.getAllPhoneNumbers();

        for(PhoneNumber phoneNumber : phoneNumbers ){

            Country country = getPhoneNumbersListService.getSpecificCountry(phoneNumber.getCountryName());

            PhoneNumberListResponseModel phoneNumberListResponseModel = new PhoneNumberListResponseModel();
            phoneNumberListResponseModel.setCountryCode(country.getCountryCode());
            phoneNumberListResponseModel.setCountryName(country.getCountryName());
            phoneNumberListResponseModel.setNumberPostfix(phoneNumber.getNumberPostfix());
            phoneNumberListResponseModel.setStatus(phoneNumber.getStatus());

            responseModelList.add(phoneNumberListResponseModel);
        }

        return responseModelList;
    }

    @GetMapping("test")
    Page<PhoneNumber> getPage() {
        return phoneNumberRepository.findAll(Pageable.ofSize(20).withPage(0));
    }


}
