package com.ag.lld.patterns.factory.database;

import java.util.HashMap;
import java.util.Map;

public class QueryParam<k,v> {
    private final Map<k,v> params ;
    public QueryParam(){
        this.params = new HashMap<>();
    }

    public v add(k key, v value){
        return params.put(key, value);
    }


    @Override
    public String toString() {
        return "QueryParam{" +
                "params=" + params +
                '}';
    }
}
