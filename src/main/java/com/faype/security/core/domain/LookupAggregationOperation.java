package com.faype.security.core.domain;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

/**
 * Created by wmfsystem on 5/28/17.
 */
public class LookupAggregationOperation implements AggregationOperation {

    private DBObject operation;

    public LookupAggregationOperation(String from, String localField,
                                      String foreignField, String as) {
        this.operation = new BasicDBObject("$lookup",
                new BasicDBObject("from", from)
                        .append("localField", localField)
                        .append("foreignField", foreignField)
                        .append("as", as));
    }

    @Override
    public DBObject toDBObject(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}