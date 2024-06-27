package com.coforge.controller;

import com.coforge.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeClientController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/all")
    public List<Employee> allEmployee(){
        try{
            Employee forObject[] = restTemplate.getForObject("http://localhost:9090/allEmployee", Employee[].class);
            return Arrays.asList(forObject);
        }
        catch(RestClientException e){
            System.out.println(e);
        }
        return null;
    }
}
