package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    List<String> param;
    boolean bool;

    public Value(List<String> list) {
        param = list;
    }

    public Value(String param) {
        List<String> list = new ArrayList<String>();
        list.add(param);
        this.param = list;
    }

    public List<String> getInputPattern() {
        return param;
    }

    public void setBool(boolean parserInput) {
        if (parserInput) {
            this.bool = true;
        } else {
            this.bool = false;
        }
    }

    public boolean getBool() {
        return bool;
    }
}
