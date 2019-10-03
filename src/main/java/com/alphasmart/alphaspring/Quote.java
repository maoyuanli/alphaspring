package com.alphasmart.alphaspring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private Long id;
    private String name;
    private String dataset_code;
    private Date newest_available_date;
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataset_code() {
        return dataset_code;
    }

    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    public Date getNewest_available_date() {
        return newest_available_date;
    }

    public void setNewest_available_date(Date newest_available_date) {
        this.newest_available_date = newest_available_date;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataset_code='" + dataset_code + '\'' +
                ", newest_available_date=" + newest_available_date +
                ", data='" + data + '\'' +
                '}';
    }
}
