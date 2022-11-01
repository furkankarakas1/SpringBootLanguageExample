package kodlama.io.kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();
		
	}
	
	@GetMapping("/getById/{id}")
	
	public Language getById(@PathVariable("id") int id)  {
		
		return languageService.getById(id);
	} 
	
	@PostMapping("/add")
	public void add(@RequestBody Language language){
		
		languageService.add(language);
	}
	@PutMapping("/update/{id}")
	public void update(@RequestBody Language language, @PathVariable int id) {
        languageService.update(language, id);
    }
	
	 @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable int id) {
	        languageService.delete(id);
	    }
	
}
