package be.steformations.it.service.contacts.soap;

import be.steformations.it.java_data.contacts.dto.TagDto;
import be.steformations.java_data.contacts.interfaces.beans.Tag;

public class SoapDtoFactory {

	public TagDto createDto(Tag t){
		TagDto dto = null;
		if (t != null){
			dto = new TagDto();
			dto.setId(t.getId());
			dto.setValue(t.getValue());
		}
		return dto;
	}
	
}
