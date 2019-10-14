package com.alphasmart.alphaspring;

import com.alphasmart.alphaspring.Dataset;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private Dataset dataset;

    public Quote() {

    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "dataset=" + dataset +
                '}';
    }
}
