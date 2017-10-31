package be.steformations.it.service.contacts.soap.implementations;

import java.util.List;

import be.steformations.it.java_data.contacts.dto.TagDto;
import be.steformations.it.service.contacts.soap.ContactSoapDaoFactory;
import be.steformations.it.service.contacts.soap.SoapDtoFactory;
import be.steformations.it.service.contacts.soap.interfaces.TagSoapService;
import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;

@javax.jws.WebService(endpointInterface="be.steformations.it.service.contacts.soap.interfaces.TagSoapService")
public class TagSoapServiceImpl implements TagSoapService {

	private TagDao dao;
	private SoapDtoFactory dtoFactory;
	
	public TagSoapServiceImpl() {
		super();
		this.dao = ContactSoapDaoFactory.getInstance().getTagDao();
		this.dtoFactory = new SoapDtoFactory();
	}

	@Override
	public List<TagDto> findAll() {
		java.util.List<TagDto> dtos = new java.util.ArrayList<>();
		for (Tag t : this.dao.getAllTags()) {
			TagDto dto = this.dtoFactory.createDto(t);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public TagDto findOneById(int id) {
		return this.dtoFactory.createDto(this.dao.getTagById(id));
	}

	@Override
	public TagDto findOneByValue(String value) {
		return this.dtoFactory.createDto(this.dao.getTagByValue(value));
	}

	@Override
	public TagDto createAndSave(String value) {
		return this.dtoFactory.createDto(this.dao.createAndSaveTag(value));
	}

	@Override
	public TagDto remove(int id) {
		TagDto dto = this.findOneById(id);
		if (dto != null){
			this.dao.removeTag(id);;
		}
		return dto;
	}

}
