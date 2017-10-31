package be.steformations.it.service.contacts.soap.interfaces;

import be.steformations.it.java_data.contacts.dto.ContactDto;

@javax.jws.WebService
public interface ContactSoapService {

	java.util.List<ContactDto> findAllContacts();
	ContactDto findOneContactById(int id);
	ContactDto findOneContactByFirstnameAndName(String firstname, String name);
	ContactDto createAndSaveContact(String firstname, String name, String email, String countryAbbreviation, java.util.List<String> tags);
	ContactDto removeContact(int id);
}
