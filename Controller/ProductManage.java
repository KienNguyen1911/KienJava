package Controller;

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
        System.out.println("Nhap ngay nhap san pham: ");
        SimpleDateFormat dayInsert = new SimpleDateFormat("dd/MM/yyyy");
        product.setDayInsert(dayInsert);
        System.out.println("Nhap ngay het han san pham: ");
        SimpleDateFormat exprivate = new SimpleDateFormat("dd/MM/yyyy");
        product.setExprivate(exprivate);
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
                System.out.println("Nhap ngay nhap san pham: ");
                SimpleDateFormat dayInsert = new SimpleDateFormat("dd/MM/yyyy");
                list.get(i).setDayInsert(dayInsert);
                System.out.println("Nhap ngay het han san pham: ");
                SimpleDateFormat exprivate = new SimpleDateFormat("dd/MM/yyyy");
                list.get(i).setExprivate(exprivate);
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

    @Override
    public boolean delete(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can xoa: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                return true;
            } else {
                // System.out.println("Ma san pham khong ton tai");
                return false;
            }
            // return false;
        }
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
            } else {
                // System.out.println("Ma san pham khong ton tai");
                return;
            }
        }
        // return;

    }

    @Override
    public void viewAll(ArrayList<Product> list) {
        // TODO Auto-generated method stub
        if(list.size() == 0){
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
