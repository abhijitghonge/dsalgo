package com.ag.lld.patterns.factory.database.db2;

import com.ag.lld.patterns.factory.database.Connection;
import com.ag.lld.patterns.factory.database.Query;
import com.ag.lld.patterns.factory.database.QueryParam;

public class SqlQuery implements Query {

    private final String queryString;
    private final QueryParam<String, Integer> queryParams;

    private SqlQuery(String queryString, QueryParam<String, Integer> queryParams) {
        this.queryString = queryString;
        this.queryParams = queryParams;
    }


    @Override
    public boolean execute(Connection conn) {

        System.out.printf("Executed Sql Query:%s using connection %s with params:%n", this.queryString, conn.getName());
        System.out.println( queryParams);
        return true;
    }

    public static SqlQueryBuilder builder(){
        return new SqlQueryBuilder();
    }

    public static class SqlQueryBuilder {
        private String queryString;
        private QueryParam<String, Integer> queryParams;


        public SqlQueryBuilder setQueryString(String queryString) {
            this.queryString = queryString;
            return this;
        }

        public SqlQueryBuilder setQueryParams(QueryParam<String, Integer> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public SqlQuery build(){
            return new SqlQuery(this.queryString, this.queryParams);
        }
    }
}
