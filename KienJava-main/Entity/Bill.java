

import java.sql.Date;
import java.util.*;

public class Bill {
    private String idBill;
	private Double total;
	private String customerName;
	private String phone;
	private Date saledDate;
	private Staff branch;
	private ArrayList<Product> product;

    public Bill(String idBill, Double total, String customerName, String phone, Date saledDate, Staff branch,
            ArrayList<Product> product) {
        this.idBill = idBill;
        this.total = total;
        this.customerName = customerName;
        this.phone = phone;
        this.saledDate = saledDate;
        this.branch = branch;
        this.product = product;
    }

    public String getIdBill() {
        return idBill;
    }
    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getSaledDate() {
        return saledDate;
    }
    public void setSaledDate(Date saledDate) {
        this.saledDate = saledDate;
    }
    public Staff getBranch() {
        return branch;
    }
    public void setBranch(Staff branch) {
        this.branch = branch;
    }
    public ArrayList<Product> getProduct() {
        return product;
    }
    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
    public Bill() {

    }
    
}
