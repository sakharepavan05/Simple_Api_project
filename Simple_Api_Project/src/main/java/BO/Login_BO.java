package BO;

public class Login_BO {
   private String ID;
   private String Password;
   private int key;
   private String  Date;
   

public int getKey() {
	return key;
}
public void setKey(int key) {
	this.key = key;
}
public String getID() {
	return ID;

}
public void setID(String iD) {
	ID = iD;
}

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}

@Override
public String toString() {
	return "Login_BO [ID=" + ID + ", Password=" + Password + "]";
}
public Login_BO(String iD, String password) {
	super();
	ID = iD;
	Password = password;
}
public Login_BO() {
	// TODO Auto-generated constructor stub
}
public Login_BO(String iD, String password, int key, String created_at) {
	super();
	ID = iD;
	Password = password;
	this.key = key;
	this.Date = created_at;
}

   
}
