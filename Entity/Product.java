package Entity;

import java.text.SimpleDateFormat;

public class Product {
    private String id;
	private SimpleDateFormat dayInsert;
	private String name;
	private int quantity;
	private SimpleDateFormat exprivate;
	private Double price;
	private String category;

    public Product() {
    
    }
    public Product(String id, SimpleDateFormat dayInsert, String name, int quantity, SimpleDateFormat exprivate,
            Double price, String category) {
        this.id = id;
        this.dayInsert = dayInsert;
        this.name = name;
        this.quantity = quantity;
        this.exprivate = exprivate;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public SimpleDateFormat getDayInsert() {
        return dayInsert;
    }
    public void setDayInsert(SimpleDateFormat dayInsert) {
        this.dayInsert = dayInsert;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public SimpleDateFormat getExprivate() {
        return exprivate;
    }
    public void setExprivate(SimpleDateFormat exprivate) {
        this.exprivate = exprivate;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
