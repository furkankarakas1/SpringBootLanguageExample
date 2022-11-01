package kodlama.io.kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import kodlama.io.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	List<Language> languages;
	
	
	
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"Python"));

		
	}


	@Override
	public List<Language> getAll() {
		
		return languages;
	}


	@Override
	public Language getById(int id)  {
			
			for(Language language : languages) {
				if(language.getId() == id) {
					return language;
				}
				
			}return null;
		}
	

	@Override
	public void add(Language language) {
		languages.add(language);
		
	}
	
	public void update(Language language, int id) {
		Language changedLanguage = getById(id);
		changedLanguage.setLanguageName(language.getLanguageName());
	}


	@Override
	public void delete(int id) {
		Language language = getById(id);
		languages.remove(language);
		
	}

}
