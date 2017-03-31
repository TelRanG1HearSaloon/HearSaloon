package client.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"clientEmail", "clientPassword","clientPhoneNumber","clientName","clientLastName" })
@XmlRootElement(name = "ClientType")
public class ClientType {
	@XmlElement(required = true)
    protected String clientPhoneNumber; 
	@XmlElement(required = true)
    protected String clientEmail;    
	@XmlElement(required = true)
	protected String clientPassword;    
	@XmlElement(required = true)
	protected String clientName;    
	@XmlElement(required = true)
	protected String clientLastName;
	
	public ClientType() {
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
