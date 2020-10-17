package com.guo.practice.codepractice.problems.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Document {

    public void save(){
        updateTimeStamp();
        saveContents();
//        notifyCollaberators();
    }

    private void saveContents() {
    }

    private void updateTimeStamp() {
    }

    //Other methods
}
class BackedUpDocument implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}