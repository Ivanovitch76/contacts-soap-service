package be.steformations.it.service.contacts.soap.interfaces;

import be.steformations.it.java_data.contacts.dto.TagDto;

@javax.jws.WebService
public interface TagSoapService {

	java.util.List<TagDto> findAll();
	TagDto findOneById (int id);
	TagDto findOneByValue (String value);
	TagDto createAndSave(String value);
	TagDto remove(int id);
}
