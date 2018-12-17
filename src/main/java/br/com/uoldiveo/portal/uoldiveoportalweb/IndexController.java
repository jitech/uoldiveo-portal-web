package br.com.uoldiveo.portal.uoldiveoportalweb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(Model model) {
		
		try {
				model.addAttribute("json", call_me());
				return new ModelAndView("index");			
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("index");
		}
	}
	
	public String call_me() throws Exception {
		String url = "http://uoldiveo-portal-login-poc-painel-ud.z1.orbx.uoldiveo.com/login";
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
	        return myResponse.getString("origin");
	         
	}
}