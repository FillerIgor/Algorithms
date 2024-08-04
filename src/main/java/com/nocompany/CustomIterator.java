package com.nocompany;

import java.util.Iterator;
import java.util.List;

//todo finish implementation
public class CustomIterator implements Iterator<String> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
