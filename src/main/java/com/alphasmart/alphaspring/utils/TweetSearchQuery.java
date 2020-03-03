package com.alphasmart.alphaspring.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TweetSearchQuery {

    private List<String> sourceList;

    public TweetSearchQuery() {
    }

    public void setSourceList(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public TweetSearchQuery(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public String getQueryString() {
        QueryBuilder builder = new QueryBuilder();
        return builder.buildQueryFromList(sourceList);
    }

    private static class QueryBuilder {

        private StringBuilder stringBuilder = new StringBuilder();

        public QueryBuilder withSource(String source) {
            String FROM_OPERATOR = "FROM:";
            String OR_OPERATOR = " OR ";
            stringBuilder.append(FROM_OPERATOR).append(source).append(OR_OPERATOR);
            return this;
        }

        public String build() {
            String extraOrOperatorQuery = stringBuilder.toString();
            return extraOrOperatorQuery.substring(0, extraOrOperatorQuery.length() - 4);
        }

        public String buildQueryFromList(List<String> sources) {
            sources.forEach(this::withSource);
            return build();
        }
    }
}
