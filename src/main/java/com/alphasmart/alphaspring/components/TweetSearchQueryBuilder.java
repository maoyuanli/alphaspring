package com.alphasmart.alphaspring.components;

public class TweetSearchQueryBuilder {
    private final String FROM_OPERATOR = "FROM:";
    private final String OR_OPERATOR = " OR ";

    private StringBuilder stringBuilder;

    public TweetSearchQueryBuilder withSource(String source){
        stringBuilder.append(FROM_OPERATOR).append(source).append(OR_OPERATOR);
        return this;
    }
    public String build(){
        String extraOrOperatorQuery = stringBuilder.toString();
        return extraOrOperatorQuery.substring(0,extraOrOperatorQuery.length()-4);
    }
}
