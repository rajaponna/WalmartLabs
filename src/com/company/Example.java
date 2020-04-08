package com.company;

import java.util.*;

public class Example implements Set {

    private List dataList = new ArrayList<Object>();



    @Override
    public int size() {
        return dataList.size();
    }

    @Override
    public boolean isEmpty() {
        return dataList.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object data : dataList) {
            if (data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[dataList.size()];
        for (int i =0; i < dataList.size(); i++) {
            array[i] = dataList.get(i);
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        if (!dataList.contains(o)) {
            return dataList.add(o);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i =0; i<dataList.size(); i++) {
            if (dataList.get(i).equals(o)) {
                dataList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        for (Object obj: collection) {
            if (!dataList.contains(obj)) {
                dataList.add(obj);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        dataList.clear();
    }

    @Override
    public boolean removeAll(Collection collection) {
        return dataList.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        for(Object obj : dataList) {
            if (!collection.contains(obj)) {
                dataList.remove(obj);
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!dataList.contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        /*for (Object obj: obj) {
            if (!dataList.contains(obj)) {
                dataList.add(obj);
            }
        }*/
        return objects;
    }
}
