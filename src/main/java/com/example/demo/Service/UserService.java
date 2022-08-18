package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Dto.Department;
import com.example.demo.Dto.ResponseTemplateDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public ResponseTemplateDto getUser(Long userId) {
		ResponseTemplateDto resTemDto = new ResponseTemplateDto();
		User user =  userRepo.findByUserId(userId);
		
		Department department =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDeptId(), Department.class);
		
		resTemDto.setDepartment(department);
		resTemDto.setUser(user);
		
		return resTemDto;
	}
}
