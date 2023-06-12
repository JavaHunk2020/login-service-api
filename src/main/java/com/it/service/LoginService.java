package com.it.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.controller.UserDTO;
import com.it.dao.LoginRepository;
import com.it.dao.entity.Login;
import com.it.dto.LoginDTO;
import com.it.exception.ResourceNotFoundException;

@Service
public class LoginService {

	// If one bean wanted to use other bean
	@Autowired
	private LoginRepository loginRepository;


	public LoginDTO findByUsername(String username,String password) {
		java.util.Optional<Login> optional= loginRepository.findByUsernameAndPassword(username, password);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Login","username",122);
		}
		LoginDTO loginDTO = new LoginDTO();
		BeanUtils.copyProperties(optional.get(), loginDTO);
		return loginDTO;
	}
	
	public void save(UserDTO userDTO) {
		Login login=new Login();
		BeanUtils.copyProperties(userDTO, login);
		loginRepository.save(login);
	}


}
