package Entity;

public class Officer {
    private String id;
	private int age;
	private String fullname;
	private String email;
	private String phone;
	private String address;

    public Officer() {
           
    }
    public Officer(String id, int age, String fullname, String email, String phone, String address) {
        this.id = id;
        this.age = age;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
