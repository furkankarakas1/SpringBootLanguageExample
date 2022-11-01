package kodlama.io.kodlama.io.devs.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		//iş kuralları
		
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id){
		
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) { 
		
		if(isLanguageExists(language)) {
			throw new RuntimeException("Language already exist");
		}
		
		if(checkLanguageNameValid(language)) {
			throw new RuntimeException("Language name is not valid");
		}
		
		languageRepository.add(language);
	}

	@Override
	public void update(Language language, int id) {
		
		if(languageRepository.getById(id) == null){
			
			throw new RuntimeException("Language id is not valid");
			
		}
		
		if(isLanguageExists(language)){
			throw new RuntimeException("Language already exist");
			
		}
		
		if(checkLanguageNameValid(language)){
			throw new RuntimeException("Language name is not valid");
		}
		
		languageRepository.update(language, id);
		
	}
	
	
	public boolean isLanguageExists(Language language) {
        return languageRepository.getAll()
        		.stream().anyMatch(l -> l.getLanguageName()
                .equals(language.getLanguageName()));
    }
	 public boolean checkLanguageNameValid(Language language) {
	        return language.getLanguageName().isEmpty() || 
	        		language.getLanguageName().isBlank() ||
	        		language.getLanguageName().length() < 2;
	                                                                                       
	    }

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
		
	}
}
