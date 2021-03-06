package master.models;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = 112234557l;
    protected String clientPhoneNumber;
    
    @Id
    protected String clientEmail;
    
	protected String clientPassword;
    
	protected String clientName;
    
	protected String clientLastName;


	public Client() {
		super();
	}


	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}


	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}


	public String getClientEmail() {
		return clientEmail;
	}


	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}


	public String getClientPassword() {
		return clientPassword;
	}


	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getClientLastName() {
		return clientLastName;
	}


	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}



}
