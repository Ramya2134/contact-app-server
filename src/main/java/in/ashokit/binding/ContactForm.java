package in.ashokit.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class ContactForm {
	private Integer contactId;
	private String  contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSwitch;
	
	private LocalDate createData;
	
	private LocalDate updateData;
	//In java we follow single responsable principle means one class should perform one operation 
   //this bindhing class is perform frontend part
}
