package com.santu.dto.response;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PKGEntityResponse {

    private Long id;  // Include the ID for response

    private String name;

    private String retailPrice;  // Changed 'price' to 'retailPrice' in camelCase

    private String sellingPrice;  // Added 'sellingPrice' field

    private List<String> features;

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

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public PKGEntityResponse() {
    }

    public PKGEntityResponse(Long id, String name, String retailPrice, String sellingPrice, List<String> features) {
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
        this.sellingPrice = sellingPrice;
        this.features = features;
    }
}
