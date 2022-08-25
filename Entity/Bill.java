package Entity;

import java.text.SimpleDateFormat;
import java.util.List;

public class Bill {
    private String idBill;
	private Double total;
	private String customerName;
	private String phone;
	private SimpleDateFormat saledDate;
	private Staff branch;
	private List<Product> product;
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
    public SimpleDateFormat getSaledDate() {
        return saledDate;
    }
    public void setSaledDate(SimpleDateFormat saledDate) {
        this.saledDate = saledDate;
    }
    public Staff getBranch() {
        return branch;
    }
    public void setBranch(Staff branch) {
        this.branch = branch;
    }
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }
    public Bill() {
        this.idBill = idBill;
        this.total = total;
        this.customerName = customerName;
        this.phone = phone;
        this.saledDate = saledDate;
        this.branch = branch;
        this.product = product;
    }

}
