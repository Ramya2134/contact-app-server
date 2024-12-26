package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;



@Entity

@Data
public class Contact {
	
	@Id
	@GeneratedValue
	private Integer contactId;
	private String  contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSwitch;
	@CreationTimestamp
	private LocalDate createData;
	@UpdateTimestamp
	private LocalDate updateData;
	
	

}
