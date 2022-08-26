package Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.IAction;
import Entity.Product;

public class ProductManage implements IAction<Product> {

    @Override
    public Product add(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        Product product = new Product();

        Scanner sc = new Scanner(System.in);

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
        
        sc.nextLine();
        System.out.println("Nhap ngay nhap san pham: ");
        String dayInsert = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date time1 = null;
        try {
            time1 = new Date(dateFormat.parse(dayInsert).getTime());
        } catch (Exception e) {
        }
        product.setDayInsert(time1);

        System.out.println("Nhap ngay het han san pham: ");
        String exprivate = sc.nextLine();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        Date time2 = null;
        try {
            time2 = new Date(dateFormat2.parse(exprivate).getTime());
        } catch (Exception e) {
        }
        product.setExprivate(time2);

        System.out.println("Nhap the loai: ");
        String category = sc.nextLine();
        product.setCategory(category);

        list.add(product);
        return product;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Interface.IAction#edit(java.util.ArrayList)
     */
    @Override
    public boolean edit(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can sua: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("Nhap ten san pham: ");
                String name = sc.nextLine();
                list.get(i).setName(name);
                System.out.println("Nhap gia san pham: ");
                Double price = sc.nextDouble();
                list.get(i).setPrice(price);
                System.out.println("Nhap so luong san pham: ");
                int quantity = sc.nextInt();
                list.get(i).setQuantity(quantity);

                sc.nextLine();
                System.out.println("Nhap ngay nhap san pham: ");
                String dayInsert = sc.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // SimpleDateFormat.parse(dayInsert);
                Date time1 = null;
                try {
                    time1 = new Date(dateFormat.parse(dayInsert).getTime());
                } catch (Exception e) {
                }
                list.get(i).setDayInsert(time1);
                // System.out.println("Nhap ngay het han san pham: ");
                
                System.out.println("Nhap ngay het han san pham: ");
                String exprivate = sc.nextLine();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
                Date time2 = null;
                try {
                    time2 = new Date(dateFormat2.parse(exprivate).getTime());
                } catch (Exception e) {}
                list.get(i).setExprivate(time2);

                System.out.println("Nhap the loai: ");
                String category = sc.nextLine();
                list.get(i).setCategory(category);

                return true;
            } else {
                // System.out.println("Ma san pham khong ton tai");
                return false;
            }
        }
        // return false;
        return false;
    }

    // List<Product> products = new ArrayList<Product>();
    @Override
    public boolean delete(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can xoa: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("Xoa thanh cong");
                return true;
            }
        }
        System.out.println("Ma san pham khong ton tai");
        return false;
    }

    @Override
    public void searchById(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can tim: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("Ten san pham: " + list.get(i).getName());
                System.out.println("Gia san pham: " + list.get(i).getPrice());
                System.out.println("So luong san pham: " + list.get(i).getQuantity());
                System.out.println("Ngay nhap san pham: " + list.get(i).getDayInsert());
                System.out.println("Ngay het han san pham: " + list.get(i).getExprivate());
                System.out.println("The loai: " + list.get(i).getCategory());
                return;
            } 
        }

    }

    @Override
    public void viewAll(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        if (list.size() == 0) {
            System.out.println("Danh sach san pham trong");
        } else {
            System.out.format("|%10s |%10s |%20s |%20s |%20s |%20s |%n",
                    "Ma san pham ", "Ten san pham ", "Gia san pham ", "So luong san pham ",
                    "Ngay nhap san pham ", "Ngay het han san", "The loai");
            for (int i = 0; i < list.size(); i++) {
                System.out.format("|%10s |%10s |%20s |%20s |%20s |%20s |%n",
                        list.get(i).getId(), list.get(i).getName(), list.get(i).getPrice(),
                        list.get(i).getQuantity(), list.get(i).getDayInsert(),
                        list.get(i).getExprivate(), list.get(i).getCategory());
            }
        }

    }

    @Override
    public boolean checkExist(ArrayList<Product> list, String id) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

}
