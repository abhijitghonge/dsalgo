package com.ag.lld.patterns.factory.database.db2;

import com.ag.lld.patterns.factory.database.Query;
import com.ag.lld.patterns.factory.database.QueryFactory;
import com.ag.lld.patterns.factory.database.QueryParam;

public class SqlQueryFactory implements QueryFactory {
    @Override
    public Query createQuery(String queryString, QueryParam<String, Integer> params) {
        return SqlQuery.builder()
                .setQueryString(queryString)
                .setQueryParams(params)
                .build();
    }
}
