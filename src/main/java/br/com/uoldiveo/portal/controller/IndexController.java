package br.com.uoldiveo.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.uoldiveo.portal.domain.User;
import br.com.uoldiveo.portal.service.LoginService;

@Controller
public class IndexController {

	@Autowired
    private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public User index(Model model) {
		
		try {
				return loginService.login();
				//model.addAttribute("json", loginService.login());
				//return new ModelAndView("index");			
				
		}catch(Exception ex) {
			ex.printStackTrace();
			//return new ModelAndView("index");
			return null;
		}
	}
	
	/*public String call_me() throws Exception {
		String url = "http://uoldiveo-portal-gateway-poc-painel-ud.z1.orbx.uoldiveo.com/login";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("GET");
	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();

	        
	        JSONObject myResponse = new JSONObject(response.toString());       
	        return myResponse.toString();
	         
	}*/
}