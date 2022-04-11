package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	public List<Contact>  getAllContacts();
	public Contact getContactById(Integer contactId);
	public boolean deleteContactById(Integer contactId);
		

}
