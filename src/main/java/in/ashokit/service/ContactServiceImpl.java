package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.ContactForm;
import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
    
	@Autowired
	private ContactRepository contactRepo;
	//implementation class will be injected
	
	@Override
	public String contactSave(ContactForm form) {
		
		//we have recevied form ,binding object  as parameter
		//Repository interfce , save entity method excepting entity object
		//so copy the data from binding object to entity object
		Contact entity = new Contact();
		
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSwitch("Y");
		entity=contactRepo.save(entity);
		if(entity.getContactId()!=null)
		{
			System.out.println(entity);
			return "Success";
		}
		
		
		return "Failed";
	}

	@Override
	public List<ContactForm> viewAllContacts() {
		
		List<ContactForm> dataList = new ArrayList();
		List<Contact> findAll=contactRepo.findAll();
		for(Contact entity : findAll)
		{
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
			
			
		}
		
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		 Optional<Contact>  findById= contactRepo.findById(contactId);
		 if(findById.isPresent())
		 {
			 Contact entity = findById.get();
			 ContactForm form = new ContactForm();
			 BeanUtils.copyProperties(entity, form);
			 return form;
		 }
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		return viewAllContacts();
	}

}
