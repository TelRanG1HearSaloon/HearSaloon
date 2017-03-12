package master.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;


@Entity
public class Master implements Serializable{
	private static final long serialVersionUID = 112234556l;
    @Id
    String phoneNumber;
    
    
    
    String email;
    
    
    String password;
    
    
    String name;
    
    
    String lastName;
    
    
    String info;
    
    

    /*@OneToMany
    ArrayList<Service> services;
    ArrayList<String> arrLocations;
    ArrayList<String> languages;*/

    public Master() {
        /*this.services = new ArrayList<Service>();
        this.arrLocations = new ArrayList<String>();*/
    }

    public Master(String phoneNumber, String email, String password, String name, String lastName ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        /*this.services = new ArrayList<Service>();
        this.arrLocations = new ArrayList<String>();*/
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /*public ArrayList<Service> getServices() {
        return services;
    }
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    public ArrayList<String> getArrLocations() {
        return arrLocations;
    }
    public void setArrLocations(ArrayList<String> arrLocations) {
        this.arrLocations = arrLocations;
    }
    public ArrayList<String> getLanguages() {
        return languages;
    }
    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }*/

/*public void addLocation (String location){
        arrLocations.add(location);
    }
    public  void addServices(Service service){
        services.add(service);
    }
    public void removeServices (Service service){
        services.remove(service);
    }
    public void changesServices (int index, Service service){
        services.remove(index);
        services.add(service);
    }*/

    /*public void changesServices (ArrayList<Service> tempService){
    }*/

}
