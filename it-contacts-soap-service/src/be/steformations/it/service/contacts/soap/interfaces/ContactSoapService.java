package be.steformations.it.service.contacts.soap.interfaces;

import be.steformations.it.java_data.contacts.dto.ContactDto;

@javax.jws.WebService
public interface ContactSoapService {

	java.util.List<ContactDto> findAll();
	ContactDto findOneById(int id);
	ContactDto findOneByFirstnameAndName(String firstname, String name);
	ContactDto createAndSave(String firstname, String name, String email, String countryAbbreviation, java.util.List<String> tags);
	ContactDto remove(int id);
}
