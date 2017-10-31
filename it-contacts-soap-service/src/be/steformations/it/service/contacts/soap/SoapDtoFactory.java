package be.steformations.it.service.contacts.soap;

import be.steformations.it.java_data.contacts.dto.ContactDto;
import be.steformations.it.java_data.contacts.dto.CountryDto;
import be.steformations.it.java_data.contacts.dto.TagDto;
import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;

public class SoapDtoFactory {

	public ContactDto createDto(Contact c, java.util.List<? extends Tag> tags){
		ContactDto dto = null;
		if (c != null){			
			dto = new ContactDto();
			dto.setId(c.getId());
			dto.setFirstname(c.getFirstname());
			dto.setName(c.getName());
			dto.setEmail(c.getEmail());
			dto.setCountry(this.createDto(c.getCountry()));
			for (Tag tag : tags) {
				dto.getTags().add(this.createDto(tag));
			}
		}
		return dto;
	}
	
	public TagDto createDto(Tag t){
		TagDto dto = null;
		if (t != null){
			dto = new TagDto();
			dto.setId(t.getId());
			dto.setValue(t.getValue());
		}
		return dto;
	}
	
	public CountryDto createDto(Country c){
		CountryDto dto = null;
		if (c != null){
			dto =  new CountryDto();
			dto.setId(c.getId());
			dto.setAbbreviation(c.getAbbreviation());
			dto.setName(c.getName());
		}
		return dto;		
	}
	
}
