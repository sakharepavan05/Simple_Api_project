package BO;

public class AddClients_BO {
 private String Id;
 private String Name;
 private String User_ID;
 private String Company;
 private String Email;
 private String phone;
 private String createdAt;
 private String updatedAt;
 private String deletedAt;
 private Boolean Active;
 



public AddClients_BO(String id, String name, String user_ID, String company, String email, String phone,
		String createdAt, String updatedAt, String deletedAt, Boolean active) {
	super();
	Id = id;
	Name = name;
	User_ID = user_ID;
	Company = company;
	Email = email;
	this.phone = phone;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.deletedAt = deletedAt;
	Active = active;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}

public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public String getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}
public String getDeletedAt() {
	return deletedAt;
}
public void setDeletedAt(String deletedAt) {
	this.deletedAt = deletedAt;
}
public Boolean getActive() {
	return Active;
}
public void setActive(Boolean active) {
	Active = active;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getUser_ID() {
	return User_ID;
}
public void setUser_ID(String user_ID) {
	User_ID = user_ID;
}
public String getCompany() {
	return Company;
}
public void setCompany(String company) {
	Company = company;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public AddClients_BO(String name, String user_ID, String company, String email, String phone) {
	super();
	Name = name;
	User_ID = user_ID;
	Company = company;
	Email = email;
	this.phone = phone;
}
public AddClients_BO() {
	// TODO Auto-generated constructor stub
}

  
}
