package Interface;

import java.util.ArrayList;

import Entity.Bill;

public interface IService<T, T1> extends IAction<T> {
    public Object add(ArrayList<T> list, ArrayList<T1> list2);
    public void viewAll(ArrayList<T> list);
    // public void viewAll1(ArrayList<T1> list);
    public Object checkExist1(ArrayList<T1> list2, String id);

}
