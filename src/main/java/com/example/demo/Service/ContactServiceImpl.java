package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ContactRepository;
import com.example.demo.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact c) {
		
		c.setActiveSW("Y");
		Contact save = contactRepo.save(c);
		
		if( save.getContactId() == null)
		
		return false;
		
		else
			return true;
	}

	@Override
	public List<Contact> getAllContacts() {
		
		Contact c = new Contact();
		c.setActiveSW("Y");
		return contactRepo.findAll(Example.of(c));
		
		/*
		return contactRepo.findAll().stream()
				.filter(  (Contact cont) -> { return cont.getActiveSW() == "Y" ;})
				.collect(Collectors.toList());
		*/		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<Contact>  ops = contactRepo.findById(contactId);
		if ( ops.isPresent())
			return ops.get();
		else
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact>  ops = contactRepo.findById(contactId);
		if ( ops.isPresent())
		{
			Contact c = ops.get();
			c.setActiveSW("N");
			contactRepo.save(c);
			return true;
		
	}
		else
			return false;

}
}
