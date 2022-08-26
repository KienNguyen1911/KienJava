package Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.Bill;
import Entity.Product;
import Entity.Staff;
import Interface.IService;

public class BillManage implements IService<Bill, Product> {

    @Override
    public Bill add(ArrayList<Bill> list, ArrayList<Product> list2) {
        // TODO Auto-generated method stub
        Bill bill = new Bill();
        Scanner sc = new Scanner(System.in);
        char choice = '\0';
        Double totalPrice = 0.0d;
        Double overallPrice = 0.0d;

        System.out.println("Nhap ma hoa don: ");
        String idBill = sc.nextLine();
        idBill = sc.nextLine();
        // while (checkExist(list, idBill)) {
        //     System.out.println("Ma hoa don da ton tai, nhap lai: ");
        //     idBill = sc.nextLine();
        // }
        bill.setIdBill(idBill);
        // Them san pham trong bill
        ArrayList<Product> listProduct = new ArrayList<>();
        do {
            Product product = new Product();

            System.out.println("Nhap ma san pham: ");
            String id = sc.nextLine();
            Product temp = checkExist1(list2, id);
            while (temp == null) {
                System.out.println("Ma san pham khong ton tai, nhap lai: ");
                id = sc.nextLine();
            }
            product.setId(id);
            product.setPrice(temp.getPrice());
            product.setName(temp.getName());

            System.out.println("Ban da chon san pham: " + product.getName());
            System.out.println("Gia san pham: " + product.getPrice());

            // nhap so luong san pham trong bill 
            System.out.println("Nhap so luong: ");
            int quantity = sc.nextInt();
            product.setQuantity(quantity);
            listProduct.add(product);

            // ask for continue?
            System.out.print("Want to add more item? (y or n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
        // bill.setProduct(product);

        for (int i = 0; i < listProduct.size(); i++) {
            totalPrice = listProduct.get(i).getPrice() * listProduct.get(i).getQuantity();
            overallPrice += totalPrice;
        }
        bill.setProduct(listProduct);
        bill.setTotal(overallPrice);

        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.nextLine();
        bill.setCustomerName(customerName);

        System.out.println("Nhap ten chi nhanh: ");
        Staff branchName = new Staff();
        branchName.setBranch(sc.nextLine());
        bill.setBranch(branchName);

        Date date = new Date(new java.util.Date().getTime());
        bill.setSaledDate(date);
        System.out.println("Ngay ban: " + date);
        System.out.println("Tong tien: " + overallPrice);
        
        list.add(bill);
        return bill;

        // return null;
    }

    @Override
    public void viewAll(ArrayList<Bill> list) {
        // TODO Auto-generated method stub
        if (list.size() == 0) {
            System.out.println("Khong co hoa don nao");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("");
                System.out.println("========================================================================");
                System.out.println("Ma hoa don: " + list.get(i).getIdBill());
                System.out.println("Ten khach hang: " + list.get(i).getCustomerName());
                System.out.println("Ten chi nhanh: " + list.get(i).getBranch().getBranch());
                System.out.println("==============================");
                System.out.println("");
                System.out.println("Danh sach san pham: ");
                System.out.printf("%10s %20s %10s %10s" , "ID"  , "Name"  , "Price"  , "Quantity" );
                for (int j = 0; j < list.get(i).getProduct().size() ; j++) {
                    // listProducts = list.get(i).getProduct().get(j);
                    System.out.println("");
                    System.out.printf("%10s %20s %10s %10s" , 
                                         list.get(i).getProduct().get(j).getId() , 
                                         list.get(i).getProduct().get(j).getName() , 
                                         list.get(i).getProduct().get(j).getPrice() , 
                                         list.get(i).getProduct().get(j).getQuantity()  
                                         );
                    System.out.println("");
                }
                System.out.println("Ngay ban: " + list.get(i).getSaledDate());
                System.out.println("Tong tien: " + list.get(i).getTotal());

            }
        }
    }

    @Override
    public Product checkExist1(ArrayList<Product> list2, String id) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getId().equals(id)) {
                return list2.get(i);
            }
        }
        return null;
    }

    
    @Override
    public boolean checkExist(ArrayList<Bill> list, String id) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBill().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object add(ArrayList<Bill> list) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean edit(ArrayList<Bill> list) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ArrayList<Bill> list) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void searchById(ArrayList<Bill> list) {
        // TODO Auto-generated method stub
        
    }

}
