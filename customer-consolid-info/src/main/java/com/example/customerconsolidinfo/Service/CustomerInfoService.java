package com.example.customerconsolidinfo.Service;

import com.example.customerconsolidinfo.feignclients.CustomerFeignClient;
import com.example.customerconsolidinfo.models.Customer;
import com.example.customerconsolidinfo.request.CreateAddressRequest;
import com.example.customerconsolidinfo.request.CreateCustomerRequest;
import com.example.customerconsolidinfo.response.AddressResponse;
import com.example.customerconsolidinfo.response.CustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerInfoService {


    List<CustomerResponse> getAllCustomers();

    String addCustomer(CreateCustomerRequest createCustomerRequest);

    String getCustomerById(Long id);

    String getAllAdresses();

    String addAddress(CreateAddressRequest createAddressRequest);

    String getAddressById(Long id);

    CustomerResponse getCustomerByIdViaWebClient(Long id);

    CustomerResponse getCustomerByIdViaFeignClient(Long id);


}
