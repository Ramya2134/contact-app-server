package in.ashokit.service;

import java.util.List;


import in.ashokit.binding.ContactForm;

public interface ContactService {
	public String contactSave(ContactForm form);

	public List<ContactForm> viewAllContacts();

	public ContactForm editContact(Integer contactId);

	public List<ContactForm> deleteContact(Integer contactId);

}
