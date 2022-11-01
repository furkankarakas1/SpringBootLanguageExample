package kodlama.io.kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	
	Language getById(int id);
	void add(Language language);
	void update(Language language,int id);
	void delete(int id);
	
}
