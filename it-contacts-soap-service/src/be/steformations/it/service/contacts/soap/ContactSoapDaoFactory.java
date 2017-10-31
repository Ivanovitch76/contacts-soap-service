package be.steformations.it.service.contacts.soap;

import be.steformations.java_data.contacts.interfaces.dao.ContactDao;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.java_data.contacts.interfaces.dao.DaoFactory;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

public class ContactSoapDaoFactory implements DaoFactory{

	private static DaoFactory instance = new ContactSoapDaoFactory();
	
	private ContactDao contactDao;
	private TagDao tagDao;
	private CountryDao countryDao;
	
	
	
	public ContactSoapDaoFactory() {
		super();
		javax.sql.DataSource dataSource 
			= new org.springframework.jdbc.datasource.SingleConnectionDataSource("jdbc:postgresql://localhost/contacts", "postgres", "postgres", true);
		this.tagDao = new TagManager(dataSource);
		this.countryDao = new CountryManager(dataSource);
		this.contactDao = new ContactsManager(dataSource, countryDao, tagDao);
	}

	public static DaoFactory getInstance(){
		return instance;
	}
	
	@Override
	public ContactDao getContactDao() {

		return contactDao;
	}

	@Override
	public CountryDao getCountryDao() {

		return countryDao;
	}

	@Override
	public TagDao getTagDao() {

		return tagDao;
	}

	
}
