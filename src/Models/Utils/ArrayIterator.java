package Models.Utils;

import java.util.Iterator;

public class ArrayIterator implements Iterator {
    private Object[] array;
    private int i;
    public ArrayIterator(Object[] x){
        array = x;
        i = 0;
    }
    @Override
    public boolean hasNext() {
        if (i == array.length) return false;
        return true;
    }

    @Override
    public Object next() {
        return array[i++];
    }
}
