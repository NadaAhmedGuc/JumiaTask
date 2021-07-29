package com.jumia.interview.task.facade;

import com.jumia.interview.task.model.entity.Country;
import com.jumia.interview.task.model.entity.PhoneNumber;
import com.jumia.interview.task.model.entity.PhoneNumberListResponseModel;
import com.jumia.interview.task.model.entity.Status;
import com.jumia.interview.task.service.GetPhoneNumbersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPhoneNumbersListFacade {
    @Autowired
    GetPhoneNumbersListService getPhoneNumbersListService;

    public Status validatePhoneNumber(String phoneNumber, String countryRegex){

        if(phoneNumber.matches(countryRegex) == true)
            return Status.VALID;
        else return Status.UNVALID;

    }

    public List<PhoneNumberListResponseModel> getAllPhoneNumberRows(){
        List<PhoneNumberListResponseModel> responseModelList = new ArrayList<PhoneNumberListResponseModel>();
        List<PhoneNumber> phoneNumbers = getPhoneNumbersListService.getAllPhoneNumbers();

        for(PhoneNumber phoneNumber : phoneNumbers ){

            Country country = getPhoneNumbersListService.getSpecificCountry(phoneNumber.getCountryName());
            Status numberStatus = validatePhoneNumber(country.getCountryCode()+phoneNumber.getNumberPostfix(), country.getCountryRegex());

            PhoneNumberListResponseModel phoneNumberListResponseModel = new PhoneNumberListResponseModel();
            phoneNumberListResponseModel.setCountryCode(country.getCountryCode());
            phoneNumberListResponseModel.setCountryName(country.getCountryName());
            phoneNumberListResponseModel.setNumberPostfix(phoneNumber.getNumberPostfix());
            phoneNumberListResponseModel.setStatus(numberStatus);

            responseModelList.add(phoneNumberListResponseModel);
        }

        return responseModelList;
    }

}
