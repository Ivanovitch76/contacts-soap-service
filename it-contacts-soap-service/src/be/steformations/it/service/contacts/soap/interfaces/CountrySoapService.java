package be.steformations.it.service.contacts.soap.interfaces;

import be.steformations.it.java_data.contacts.dto.CountryDto;

@javax.jws.WebService
public interface CountrySoapService {

	java.util.List<CountryDto> findAll();
	CountryDto findOneById(int id);
	CountryDto findOneByAbbreviation(String abbreviation);
	CountryDto createAndSave(String abbreviation, String name);
	
}
