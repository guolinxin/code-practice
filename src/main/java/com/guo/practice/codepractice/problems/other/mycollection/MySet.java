package com.guo.practice.codepractice.problems.other.mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySet<T> {
    private List<T> list = new ArrayList<>();

    public MySet(List<T> list) {
        this.list = list;
    }

    public void add(T element){
        if(getList().contains(element)){
           int index = list.indexOf(element);
           list.add(index, element);
        }
    };

    public List<T> getList() {
        if(list == null){
            return Collections.emptyList();
        }
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
