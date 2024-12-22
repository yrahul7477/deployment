package com.santu.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Data

public class PKGEntityRequest {

    @NotNull
    private String name;

    @NotNull
    private String retailPrice;  // Changed 'price' to 'retailPrice' in camelCase

    @NotNull
    private String sellingPrice;  // Added 'sellingPrice' field

    @NotNull
    private List<String> features;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(@NotNull String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public @NotNull String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(@NotNull String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public @NotNull List<String> getFeatures() {
        return features;
    }

    public void setFeatures(@NotNull List<String> features) {
        this.features = features;
    }

    public PKGEntityRequest(String name, String retailPrice, String sellingPrice, List<String> features) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.sellingPrice = sellingPrice;
        this.features = features;
    }

    public PKGEntityRequest() {

    }

    @Override
    public String toString() {
        return "PKGEntityRequest{" +
                "name='" + name + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                ", features=" + features +
                '}';
    }
}
