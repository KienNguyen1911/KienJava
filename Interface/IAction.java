package Interface;

import java.util.ArrayList;

public interface IAction<T> {
    public Object add(ArrayList<T> list);
    // public Object add2(ArrayList<T> list, ArrayList<T> list2);
	public boolean edit(ArrayList<T> list);
	public boolean delete(ArrayList<T> list);
	public void searchById(ArrayList<T> list);
	public void viewAll(ArrayList<T> list);
    public boolean checkExist(ArrayList<T> list, String id);
}
