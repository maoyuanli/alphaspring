package com.alphasmart.alphaspring.components;

import java.util.List;

public class TweetSearchQueryBuilder {
    private final String FROM_OPERATOR = "FROM:";
    private final String OR_OPERATOR = " OR ";

    private StringBuilder stringBuilder = new StringBuilder();

    public TweetSearchQueryBuilder withSource(String source){
        stringBuilder = stringBuilder.append(FROM_OPERATOR).append(source).append(OR_OPERATOR);
        return this;
    }
    public String build(){
        String extraOrOperatorQuery = stringBuilder.toString();
        return extraOrOperatorQuery.substring(0,extraOrOperatorQuery.length()-4);
    }

    public String buildQueryFromList(List<String> sources){
        sources.forEach(source->withSource(source));
        return build();
    }
}
