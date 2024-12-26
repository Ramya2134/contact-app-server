package in.ashokit.restcontoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.ContactForm;
import in.ashokit.service.ContactService;


@RestController
public class ContactRestContoller {
	
	@Autowired
	private ContactService service;
	
	//RequestBody is used to read data in requestbody
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form)
	{
		String status = service.contactSave(form);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContactInfo()
	{
	  System.out.println("**viewAllContact() method called **");
		return service.viewAllContacts();
		
	}
	
	
	@GetMapping("/edit/{id}")
	public ContactForm editContact(@PathVariable Integer id)
	{
		return service.editContact(id);
		
	}
	//pathvaraible is used the read the data from the url
	
	@DeleteMapping("/delete/{id}")
	public List<ContactForm> deleteConatctById(@PathVariable Integer id)
	{
		return service.deleteContact(id);
		
	}

}
