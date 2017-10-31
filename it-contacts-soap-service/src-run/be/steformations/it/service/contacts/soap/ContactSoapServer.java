package be.steformations.it.service.contacts.soap;

import be.steformations.it.service.contacts.soap.implementations.TagSoapServiceImpl;

public class ContactSoapServer {

	public static void main(String[] args) {
		TagSoapServiceImpl tagSoapService = new TagSoapServiceImpl();
		javax.xml.ws.Endpoint.publish("http://localhost:8080/contacts-soap/ws/TagSoapService?wsdl", tagSoapService);
		
		System.out.println("Service Soap contact prêt");
	}
	
}
