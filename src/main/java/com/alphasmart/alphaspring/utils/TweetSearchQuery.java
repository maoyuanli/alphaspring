package com.alphasmart.alphaspring.utils;

import java.util.List;

public class TweetSearchQuery {
    private List<String> sourceList;

    public TweetSearchQuery(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public String getQueryString(){
        QueryBuilder builder = new QueryBuilder();
        return builder.buildQueryFromList(sourceList);
    }

    private static class QueryBuilder{
        private final String FROM_OPERATOR = "FROM:";
        private final String OR_OPERATOR = " OR ";

        private StringBuilder stringBuilder = new StringBuilder();

        public QueryBuilder withSource(String source){
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
}
