package eg.edu.alexu.csd.oop;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterator implements Iterator {
    private ArrayList myArraylist;
    private int i;
    public ArrayListIterator(ArrayList x){
        myArraylist = x;
        i = 0;
    }
    @Override
    public boolean hasNext() {
        if(myArraylist.size() == i) return false;
        return true;
    }

    @Override
    public Object next() {
        return myArraylist.get(i++);
    }
}
