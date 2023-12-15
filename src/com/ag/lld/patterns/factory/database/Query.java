package com.ag.lld.patterns.factory.database;

public interface Query {

    public boolean execute(Connection conn);


}
