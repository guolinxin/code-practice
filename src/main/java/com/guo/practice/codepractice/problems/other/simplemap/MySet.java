package com.guo.practice.codepractice.problems.other.simplemap;

import java.util.ArrayList;
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
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
