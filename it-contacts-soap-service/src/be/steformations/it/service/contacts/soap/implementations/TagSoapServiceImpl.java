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
	public List<TagDto> findAllTags() {
		java.util.List<TagDto> dtos = new java.util.ArrayList<>();
		for (Tag t : this.dao.getAllTags()) {
			TagDto dto = this.dtoFactory.createDto(t);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public TagDto findOneTagById(int id) {
		return this.dtoFactory.createDto(this.dao.getTagById(id));
	}

	@Override
	public TagDto findOneTagByValue(String value) {
		return this.dtoFactory.createDto(this.dao.getTagByValue(value));
	}

	@Override
	public TagDto createAndSaveTag(String value) {
		return this.dtoFactory.createDto(this.dao.createAndSaveTag(value));
	}

	@Override
	public TagDto removeTag(int id) {
		TagDto dto = this.findOneTagById(id);
		if (dto != null){
			this.dao.removeTag(id);;
		}
		return dto;
	}

}
