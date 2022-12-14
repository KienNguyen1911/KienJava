import Entity.*;
import Interface.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.security.auth.callback.ChoiceCallback;

import Controller.BillManage;
import Controller.OfficerManage;
import Controller.ProductManage;

public class Main {

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Officer> listOfficers = new ArrayList<Officer>();
        OfficerManage officerManage = new OfficerManage();

        ArrayList<Product> listProducts = new ArrayList<Product>();
        ProductManage productManage = new ProductManage();

        ArrayList<Bill> listBills = new ArrayList<Bill>();
        BillManage billManage = new BillManage();

        Product p1 = new Product();
        p1.setId("a1");
        // Date date1 = parseDate("2019-01-01");
        p1.setDayInsert(null);
        p1.setName("milk");
        p1.setQuantity(2);
        p1.setExprivate(null);
        p1.setPrice(10000.0);
        p1.setCategory("food");
        listProducts.add(p1);

        Product p2 = new Product();
        p2.setId("a2");
        // Date date1 = parseDate("2019-01-01");
        p2.setDayInsert(null);
        p2.setName("pizza");
        p2.setQuantity(4);
        p2.setExprivate(null);
        p2.setPrice(50000.0);
        p2.setCategory("food");
        listProducts.add(p2);

        Officer o1 = new Officer();
        o1.setId("b1");
        o1.setFullname("Nguyen Van A");
        o1.setAge(20);
        o1.setAddress("Ha Noi");
        o1.setPhone("0123456789");
        o1.setEmail("a@123");
        listOfficers.add(o1);
        
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
                // ??o???n n??y l?? khai b??o c??c h??m c???a OfficerManage
                case 1: {
                    boolean check = true; // boolen ????? ki???m tra bi???n n???u false th?? break
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
                                break;
                            }
                            case 2: {
                                officerManage.edit(listOfficers);
                                break;
                            }
                            case 3: {
                                officerManage.delete(listOfficers);
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
                    boolean check = true; // boolen ????? ki???m tra bi???n n???u false th?? break
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
                                break;
                            }
                            case 2: {
                                productManage.edit(listProducts);
                                break;
                            }
                            case 3: {
                                productManage.delete(listProducts);
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
                                // System.exit(0);
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
                    boolean check = true; // boolen ????? ki???m tra bi???n n???u false th?? break
                    int choiceBill = 0;
                    while (true) {
                        System.out.println("============ Bill Manage =============");
                        System.out.println("1. Add Bill");
                        System.out.println("2. View ALL Bill");
                        System.out.println("3. Search Bill");
                        System.out.println("4. Back to main menu");
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
                                billManage.viewAll(listBills);
                                break;
                            }
                            case 3:
                                billManage.searchById(listBills);
                                break;
                            case 4:
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
                    }
                    break;
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
