package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    List<String> param;
    boolean bool;

    public Value(List<String> list, boolean bool) {
        param = list;
        this.bool = bool;

    }

    public Value(String param, boolean bool) {
        List<String> list = new ArrayList<String>();
        list.add(param);
        this.param = list;
        this.bool = bool;
    }

    public List<String> getInputPattern() {
        return param;
    }

    public boolean getBool() {
        return bool;
    }
}