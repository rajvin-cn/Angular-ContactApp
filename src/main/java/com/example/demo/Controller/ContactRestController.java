package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApplicationProperties;
import com.example.demo.Service.ContactService;
import com.example.demo.entity.Contact;

@RestController 
@CrossOrigin
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@Autowired
	private ApplicationProperties apropos;
	
    @PostMapping("/contact")
	public String saveContact( @RequestBody Contact contact)
	{
		if( service.saveContact(contact))
			return  apropos.getMessages().get("ContactSaveSucc");
		else
			return apropos.getMessages().get("ContactSaveFail");
	}
	
    @GetMapping("/contacts")
    public List<Contact> getAllContacts()
    {
    	return service.getAllContacts();
    }

    
    @GetMapping("/contact/{cid}")
    public Contact editContact(@PathVariable("cid") Integer contactId)
    {
    	return service.getContactById(contactId);
    }
    
    @DeleteMapping("/contact/{cid}")
    public String deleteContactInteger (@PathVariable("cid") Integer contactId) {
    	
    	if (service.deleteContactById(contactId))
    	{
    		return  apropos.getMessages().get("ContactDelSucc");
    	}
    	else 
    		return apropos.getMessages().get("ContactDelFail");
    	
    }
}
