package com.iv.org.front.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iv.org.biz.entity.EmployeeEntity;
import com.iv.org.biz.service.EmployeeService;

@RestController
@RequestMapping("/employeemaster")
public class EmployeeMasterController {
	
	@RequestMapping(value="/getEmpById", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmpById(@RequestParam String empId) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<EmployeeEntity> responseEntity = restTemp.getForEntity("http://localhost:8090/org-service/employeemasterservice/getEmpById?empId=2115", EmployeeEntity.class);
		
		EmployeeEntity employeeEntity = responseEntity.getBody();
		return mapper.writeValueAsString(employeeEntity);
//		return JSONObject.valueToString(employeeEntity);
	}

}
