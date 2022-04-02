package com.example.customerconsolidinfo.Service;

import com.example.customerconsolidinfo.feignclients.CustomerFeignClient;
import com.example.customerconsolidinfo.models.Customer;
import com.example.customerconsolidinfo.request.CreateAddressRequest;
import com.example.customerconsolidinfo.request.CreateCustomerRequest;
import com.example.customerconsolidinfo.response.AddressResponse;
import com.example.customerconsolidinfo.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.Arrays;
import java.util.List;
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CustomerFeignClient customerFeignClient;

    @Autowired
    WebClient webClient;


    @Override
    public List<CustomerResponse> getAllCustomers() {
        return restTemplate.getForObject("http://localhost:8081/api/customer/all", List.class);

    }

    @Override
    public String addCustomer(CreateCustomerRequest createCustomerRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CreateCustomerRequest> entity = new HttpEntity<CreateCustomerRequest>(createCustomerRequest, headers);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("http://localhost:8081/api/customer", HttpMethod.POST, entity, String.class);

        return responseEntity.getBody();

    }

    @Override
    public String getCustomerById(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/api/customer/getById/"+id, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();
    }

    @Override
    public String getAllAdresses() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/api/address/all", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public String addAddress(CreateAddressRequest createAddressRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CreateAddressRequest> entity = new HttpEntity<>(createAddressRequest,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/api/address", HttpMethod.POST, entity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public String getAddressById(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/api/address/"+id, HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public CustomerResponse getCustomerByIdViaWebClient(Long id) {
        Mono<CustomerResponse> customerResponse = webClient.get().uri("/getById/" + id)
                .retrieve().bodyToMono(CustomerResponse.class);
        return customerResponse.block();
    }


    public CustomerResponse getCustomerByIdViaFeignClient(Long id) {
        CustomerResponse customerResponse  = customerFeignClient.getCustomerByIdViaFeignClient(id);
        return customerResponse;
    }

}
