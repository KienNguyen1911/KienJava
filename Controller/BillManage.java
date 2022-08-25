package Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.Bill;
import Entity.Product;
import Entity.Staff;
import Interface.IAction;
import Interface.IService;

public class BillManage implements IService<Bill, Product> {

    /*
     * (non-Javadoc)
     * 
     * @see Interface.IAction#add(java.util.ArrayList)
     */
    /*
     * (non-Javadoc)
     * 
     * @see Interface.IAction#add(java.util.ArrayList)
     */
    /*
     * (non-Javadoc)
     * 
     * @see Interface.IAction#add(java.util.ArrayList)
     */
    /*
     * (non-Javadoc)
     * 
     * @see Interface.IAction#add(java.util.ArrayList)
     */
    /*
     * (non-Javadoc)
     * 
     * @see Interface.IService#add(java.util.ArrayList, java.util.ArrayList)
     */
    /*
     * (non-Javadoc)
     * 
     * @see Interface.IService#add(java.util.ArrayList, java.util.ArrayList)
     */
    @Override
    public Bill add(ArrayList<Bill> list, ArrayList<Product> list2) {
        // TODO Auto-generated method stub
        Product product = new Product();
        Bill bill = new Bill();
        char choice = '\0';
        Double totalPrice = 0.0d;
        Double overallPrice = 0.0d;

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ma hoa don: ");
        String idBill = sc.nextLine();
        while (checkExist(list, idBill)) {
            System.out.println("Ma hoa don da ton tai, nhap lai: ");
            idBill = sc.nextLine();
        }
        bill.setIdBill(idBill);
        // Them san pham trong bill
        do {
            System.out.println("Nhap ma san pham: ");
            String id = sc.nextLine();
            while (checkExist(list, id)) {
                System.out.println("Ma san pham da ton tai, nhap lai: ");
                id = sc.nextLine();
            }
            product.setId(id);
            System.out.println("Nhap ten san pham: ");
            String name = sc.nextLine();
            product.setName(name);
            System.out.println("Nhap gia san pham: ");
            Double price = sc.nextDouble();
            product.setPrice(price);
            System.out.println("Nhap so luong san pham: ");
            int quantity = sc.nextInt();
            product.setQuantity(quantity);

            System.out.println("Nhap ngay nhap san pham: ");
            String dayInsert = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // SimpleDateFormat.parse(dayInsert);
            Date time1 = null;
            try {
                time1 = new Date(dateFormat.parse(dayInsert).getTime());
            } catch (Exception e) {}
            product.setDayInsert(time1);

            System.out.println("Nhap ngay het han san pham: ");
            String exprivate = sc.nextLine();
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            Date time2 = null;
            try {
                time2 = new Date(dateFormat2.parse(exprivate).getTime());
            } catch (Exception e) {}
            product.setExprivate(time2);

            System.out.println("Nhap the loai: ");
            String category = sc.nextLine();
            product.setCategory(category);

            list2.add(product);
            totalPrice = price * quantity;
            overallPrice += totalPrice;
            // ask for continue?
            System.out.print("Want to add more item? (y or n): ");
            choice = sc.next().charAt(0);

            // read remaining characters, don't store (no use)
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
        // bill.setProduct(product);
        bill.setProduct(list2);
        bill.setTotal(overallPrice);
        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.nextLine();
        bill.setCustomerName(customerName);
        System.out.println("Nhap ten chi nhanh: ");
        Staff branchName = new Staff();
        branchName.setBranch(sc.nextLine());
        bill.setBranch(branchName);

        System.out.println("Tong tien: " + overallPrice);
        return bill;

        // return null;
    }

    @Override
    public boolean checkExist(ArrayList<Bill> list, String id) {
        // TODO Auto-generated method stub
        for (Bill bill : list) {
            if (bill.getIdBill().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void viewAll(ArrayList<Bill> list, ArrayList<Product> list2) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list.size(); i++) {
            System.out.println("");
            System.out.println("==============================");
            System.out.println("Ma hoa don: " + list.get(i).getIdBill());
            System.out.println("Ten khach hang: " + list.get(i).getCustomerName());
            System.out.println("Ten chi nhanh: " + list.get(i).getBranch().getBranch());
            System.out.println("Tong tien: " + list.get(i).getTotal());
            System.out.println("==============================");
            System.out.println("");
            System.out.println("Danh sach san pham: ");
            for (int j = 0; j < list.get(i).getProduct().size(); j++) {
                    System.out.println("Ma san pham: " + list.get(i).getProduct().get(j).getId());
                    System.out.println("Ten san pham: " + list.get(i).getProduct().get(j).getName());
                    System.out.println("Gia san pham: " + list.get(i).getProduct().get(j).getPrice());
                    System.out.println("So luong san pham: " + list.get(i).getProduct().get(j).getQuantity());
                    System.out.println("Ngay nhap san pham: " + list.get(i).getProduct().get(j).getDayInsert());
                    System.out.println("Ngay het han san pham: " + list.get(i).getProduct().get(j).getExprivate());
                    System.out.println("The loai: " + list.get(i).getProduct().get(j).getCategory());
                    System.out.println("==============================");
                    System.out.println("");
            }
        }
    }

}
