

import java.util.ArrayList;
import java.util.Scanner;

import Interface.IAction;

public class OfficerManage implements IAction<Officer> {

    @Override
    public Officer add(ArrayList<Officer> list) {
        // TODO Auto-generated method stub
        Officer officer = new Officer();
        Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma nhan vien: ");
            String id = sc.nextLine();
            while(checkExist(list, id)) {
                System.out.println("Ma nhan vien da ton tai, nhap lai: ");
                id = sc.nextLine();
            }
            officer.setId(id);
            System.out.println("Nhap ho ten nhan vien: ");
            String fullname = sc.nextLine();
            officer.setFullname(fullname);
            System.out.println("Nhap email nhan vien: ");
            String email = sc.nextLine();
            officer.setEmail(email);
            System.out.println("Nhap so dien thoai nhan vien: ");
            String phone = sc.nextLine();
            officer.setPhone(phone);
            System.out.println("Nhap dia chi nhan vien: ");
            String address = sc.nextLine();
            officer.setAddress(address);
            System.out.println("Nhap tuoi nhan vien: ");
            int age = sc.nextInt();
            officer.setAge(age);

            list.add(officer); 

            return officer;

    }

    @Override
    public boolean delete(ArrayList<Officer> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can xoa: ");
        String id = sc.next();
        Officer temp = chechExistById(list, id);
        while (temp == null) {
            System.out.println("Ma san pham khong ton tai, nhap lai: ");
            id = sc.next();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(ArrayList<Officer> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can sua: ");
        String id = sc.next();
        Officer temp = chechExistById(list, id);
        while (temp == null) {
            System.out.println("Ma san pham khong ton tai, nhap lai: ");
            id = sc.next();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("1. Sua ho ten nhan vien: ");
                System.out.println("2. Sua email nhan vien: ");
                System.out.println("3. Sua so dien thoai nhan vien: ");
                System.out.println("4. Sua dia chi nhan vien: ");
                System.out.println("5. Sua tuoi nhan vien: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:{
                        System.out.println("Nhap ho ten nhan vien: ");
                        String fullname = sc.next();
                        list.get(i).setFullname(fullname);
                        break;
                    }
                    case 2: {
                        System.out.println("Nhap email nhan vien: ");
                        String email = sc.next();
                        list.get(i).setEmail(email);
                        break;
                    }
                    case 3: {
                        System.out.println("Nhap so dien thoai nhan vien: ");
                        String phone = sc.next();
                        list.get(i).setPhone(phone);
                        break;
                    }
                    case 4: {
                        System.out.println("Nhap dia chi nhan vien: ");
                        String address = sc.next();
                        list.get(i).setAddress(address);
                        break;
                    }
                    case 5: {
                        System.out.println("Nhap tuoi nhan vien: ");
                        int age = sc.nextInt();
                        list.get(i).setAge(age);
                        break;
                    }
                    default: {
                        System.out.println("Nhap sai, nhap lai: ");
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public void searchById(ArrayList<Officer> list) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can tim: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.format("|%10s |%10s |%20s |%20s |%20s |%20s |%n", "Ma nhan vien", "Ho ten nhan vien", "Email nhan vien", "So dien thoai nhan vien", "Dia chi nhan vien", "Tuoi nhan vien");
                System.out.format("|%10s |%10s |%20s |%20s |%20s |%20s |%n", list.get(i).getId(),
                        list.get(i).getFullname(), list.get(i).getEmail(), list.get(i).getPhone(),
                        list.get(i).getAddress(), list.get(i).getAge());
                
            }
        }

    }
    @Override
    public void viewAll(ArrayList<Officer> list) {
        if (list.size() == 0) {
            System.out.println("Danh sach rong");
        } else {
            System.out.format("|%10s |%10s |%20s |%20s |%20s |%20s |%n", "Ma nhan vien", "Ho ten nhan vien", "Email nhan vien", "So dien thoai nhan vien", "Dia chi nhan vien", "Tuoi nhan vien");
            for (int i = 0; i < list.size(); i++) {
                System.out.format("%10s %20s %20s %20s %20s %20s %n", list.get(i).getId(),
                        list.get(i).getFullname(), list.get(i).getEmail(), list.get(i).getPhone(),
                        list.get(i).getAddress(), list.get(i).getAge());
            }
        }
    }
    @Override
    public boolean checkExist(ArrayList<Officer> list, String id) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    private Officer chechExistById(ArrayList<Officer> list, String id){
    	for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

}
