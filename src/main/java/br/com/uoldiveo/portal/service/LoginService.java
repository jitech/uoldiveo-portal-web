package br.com.uoldiveo.portal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.uoldiveo.portal.domain.User;

@Service
public class LoginService {

	@HystrixCommand(fallbackMethod = "defaultLogin")
	public User login() {
		return new RestTemplate().getForObject("http://uoldiveo-portal-gateway-poc-painel-ud.z1.orbx.uoldiveo.com/login", User.class);
	}
	
	@SuppressWarnings("unused")
	private String defaultLogin() {
        return "Hello User!";
    }
}
