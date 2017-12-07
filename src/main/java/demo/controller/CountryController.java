package demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import demo.model.Country;
import demo.model.Job;
import demo.repository.CountryRepository;
import demo.repository.JobRepository;

@Controller
public class CountryController {
	@Autowired
	public CountryRepository countryRepository;
	
    @RequestMapping("/country")
    public List<Country> country(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	List<Country> country = countryRepository.findAll();
    	System.out.println("ok");
    	model.addAttribute("country", country);
    	System.out.println(country.get(5).getCountryId());
    	return country;
    }
    	   
    
}
