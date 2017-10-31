package be.steformations.it.service.contacts.soap.implementations;

import java.util.List;

import be.steformations.it.java_data.contacts.dto.CountryDto;
import be.steformations.it.service.contacts.soap.ContactSoapDaoFactory;
import be.steformations.it.service.contacts.soap.SoapDtoFactory;
import be.steformations.it.service.contacts.soap.interfaces.CountrySoapService;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
@javax.jws.WebService(endpointInterface="be.steformations.it.service.contacts.soap.interfaces.CountrySoapService")
public class CountrySoapServiceImpl implements CountrySoapService {

	private CountryDao dao = ContactSoapDaoFactory.getInstance().getCountryDao();
	private SoapDtoFactory dtoFactory = new SoapDtoFactory();
	
	
	
	public CountrySoapServiceImpl() {
		super();
	}
	@Override
	public List<CountryDto> findAllCountries() {
		java.util.List<CountryDto> dtos = new java.util.ArrayList<>();
		for (Country country : this.dao.getAllCountries()) {
			dtos.add(this.dtoFactory.createDto(country));		
		}
		return dtos;
	}
	@Override
	public CountryDto findOneCountryById(int id) {
		CountryDto dto = null;
		for (java.util.Iterator<? extends Country> iter = this.dao.getAllCountries().iterator();
				iter.hasNext() && dto == null;) {
			Country c = iter.next();
			if (c.getId().intValue() == id){
				dto = this.dtoFactory.createDto(c);
			}
		}
		return dto;
	}
	@Override
	public CountryDto findOneCountryByAbbreviation(String abbreviation) {
		return this.dtoFactory.createDto(this.dao.getCountryByAbbreviation(abbreviation));
	}
	@Override
	public CountryDto createAndSaveCountry(String abbreviation, String name) {
		return this.dtoFactory.createDto(this.dao.createAndSaveCountry(abbreviation, name));
	}
	

}
