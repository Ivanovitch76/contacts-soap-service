package be.steformations.it.service.contacts.soap.implementations;

import java.util.List;

import be.steformations.it.java_data.contacts.dto.ContactDto;
import be.steformations.it.service.contacts.soap.ContactSoapDaoFactory;
import be.steformations.it.service.contacts.soap.SoapDtoFactory;
import be.steformations.it.service.contacts.soap.interfaces.ContactSoapService;
import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.dao.ContactDao;

@javax.jws.WebService(endpointInterface="be.steformations.it.service.contacts.soap.interfaces.ContactSoapService")
public class ContactSoapServiceImpl implements ContactSoapService {

	private ContactDao dao = ContactSoapDaoFactory.getInstance().getContactDao();
	private SoapDtoFactory dtoFactory = new SoapDtoFactory();
	
	
	
	public ContactSoapServiceImpl() {
		super();
	}

	@Override
	public List<ContactDto> findAllContacts() {
		java.util.List<ContactDto> dtos = new java.util.ArrayList<>();
		for (Contact contact : this.dao.getAllContacts()) {
			dtos.add(this.dtoFactory.createDto(contact, this.dao.getTagsByContact(contact.getId())));
		}
		return dtos;
	}

	@Override
	public ContactDto findOneContactById(int id) {
		ContactDto dto = null;
		Contact c = this.dao.getContactById(id);
		if (c != null){
			dto = this.dtoFactory.createDto(c, this.dao.getTagsByContact(c.getId()));
		}
		return dto;
	}

	@Override
	public ContactDto findOneContactByFirstnameAndName(String firstname, String name) {
		ContactDto dto = null;
		Contact c = this.dao.getContactByFirstnameAndName(firstname, name);
		if (c != null){
			dto = this.dtoFactory.createDto(c, this.dao.getTagsByContact(c.getId()));
		}
		return dto;
	}

	@Override
	public ContactDto createAndSaveContact(String firstname, String name, String email, String countryAbbreviation,
			java.util.List<String> tags) {
		ContactDto dto = null;
		Contact c = this.dao.createAndSaveContact(firstname, name, email, countryAbbreviation, tags);
		if (c != null){
			dto = this.dtoFactory.createDto(c, this.dao.getTagsByContact(c.getId()));
		}
		return dto;
	}

	@Override
	public ContactDto removeContact(int id) {
		ContactDto dto = this.findOneContactById(id);
		if (dto != null){
			this.dao.removeContact(id);
		}
		return dto;
	}

}
