package Interface;

import java.util.ArrayList;

import Entity.Bill;

public interface IService<T, T1> {
    public Object add(ArrayList<T> list, ArrayList<T1> list2);
    public void viewAll(ArrayList<T> list, ArrayList<T1> list2);
    // public boolean checkExist(ArrayList<T> list, String id);
    public boolean checkExist(ArrayList<T> list, String id);
}
