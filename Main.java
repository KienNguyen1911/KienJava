import Entity.*;
import Interface.*;
import java.util.*;

import javax.security.auth.callback.ChoiceCallback;

import Controller.BillManage;
import Controller.OfficerManage;
import Controller.ProductManage;

public class Main {

    public static void main(String[] args) {
        ArrayList<Officer> listOfficers = new ArrayList<Officer>();
        OfficerManage officerManage = new OfficerManage();

        ArrayList<Product> listProducts = new ArrayList<Product>();
        ProductManage productManage = new ProductManage();

        ArrayList<Bill> listBills = new ArrayList<Bill>();
        BillManage billManage = new BillManage();

        while (true) {
            System.out.println("============ Main Menu Function =============");
            System.out.println("1. Officer Manage");
            // System.out.println("2. Staff Manage");
            System.out.println("2. Product Manage");
            System.out.println("3. Bill Manage");
            System.out.println("4. Exit");
            System.out.println("=======================================");
            System.out.println("Nhap vao lua chon cua ban: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                // Function Officer Manage
                // Đoạn này là khai báo các hàm của OfficerManage
                case 1: {
                    boolean check = true; // boolen đẻ kiểm tra biến nếu false thì break
                    int choiceOfficer = 0;
                    while (true) {
                        System.out.println("============ Officer Manage =============");
                        System.out.println("1. Add Officer");
                        System.out.println("2. Edit Officer");
                        System.out.println("3. Delete Officer");
                        System.out.println("4. Search Officer");
                        System.out.println("5. View All");
                        System.out.println("6. Back to main menu");
                        System.out.println("=======================================");
                        System.out.println("Nhap vao lua chon cua ban: ");
                        choiceOfficer = sc.nextInt();
                        switch (choiceOfficer) {
                            case 1: {
                                officerManage.add(listOfficers);
                                System.out.println("Them nhan vien thanh cong !!!");
                                break;
                            }
                            case 2: {
                                officerManage.edit(listOfficers);
                                System.out.println("Sua nhan vien thanh cong !!!");
                                break;
                            }
                            case 3: {
                                officerManage.delete(listOfficers);
                                System.out.println("Xoa nhan vien thanh cong !!!");
                                break;
                            }
                            case 4: {
                                officerManage.searchById(listOfficers);
                                break;
                            }
                            case 5: {
                                officerManage.viewAll(listOfficers);
                                break;
                            }
                            case 6:
                                check = false;
                                break;
                            default: {
                                System.out.println("Nhap sai, nhap lai: ");
                                break;
                            }
                        }
                        if (check == false) {
                            break;
                        }
                        // break;
                    } // end while
                    break;
                }
                // break;
                // Function Product Manage
                case 2: {
                    boolean check = true; // boolen đẻ kiểm tra biến nếu false thì break
                    int choiceProduct = 0;
                    while (true) {
                        System.out.println("============ Product Manage =============");
                        System.out.println("1. Add Product");
                        System.out.println("2. Edit Product");
                        System.out.println("3. Delete Product");
                        System.out.println("4. Search Product");
                        System.out.println("5. View All");
                        System.out.println("6. Back to main menu");
                        System.out.println("=======================================");
                        System.out.println("Nhap vao lua chon cua ban: ");
                        choiceProduct = sc.nextInt();
                        switch (choiceProduct) {
                            case 1: {
                                productManage.add(listProducts);
                                System.out.println("Them san pham thanh cong !!!");
                                break;
                            }
                            case 2: {
                                productManage.edit(listProducts);
                                System.out.println("Sua san pham thanh cong !!!");
                                break;
                            }
                            case 3: {
                                productManage.delete(listProducts);
                                System.out.println("Xoa san pham thanh cong !!!");
                                break;
                            }
                            case 4: {
                                productManage.searchById(listProducts);
                                break;
                            }
                            case 5: {
                                productManage.viewAll(listProducts);
                                break;
                            }
                            case 6:
                                check = false;
                                break;
                            default: {
                                System.out.println("Nhap sai, nhap lai: ");
                                break;
                            }
                        }
                        if (check == false) {
                            break;
                        }
                        // break;
                    } // end while
                    break;
                }
                // break;
                // Function Bill Manage
                case 3: {
                    boolean check = true; // boolen đẻ kiểm tra biến nếu false thì break
                    int choiceBill = 0;
                    while (true) {
                        System.out.println("============ Bill Manage =============");
                        System.out.println("1. Add Bill");
                        System.out.println("2. View ALL Bill");
                        System.out.println("3. Back to main menu");
                        System.out.println("=======================================");
                        System.out.println("Nhap vao lua chon cua ban: ");
                        choiceBill = sc.nextInt();
                        switch (choiceBill) {
                            case 1: {
                                billManage.add(listBills, listProducts);
                                System.out.println("Them hoa don thanh cong !!!");
                                break;
                            }
                            case 2: {
                                billManage.viewAll(listBills, listProducts);
                                break;
                            }
                            case 3:
                                check = false;
                                break;
                            default: {
                                System.out.println("Nhap sai, nhap lai: ");
                                break;
                            }
                        }
                        break;
                    }
                }
                // Function Exit
                case 4: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Nhap sai, nhap lai: ");
                    break;
                }

            }

        } // end while;
    }

}
