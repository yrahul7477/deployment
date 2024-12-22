package com.santu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder

@Entity
@Table(name = "pkg_entity") // Table name remains the same
public class PKGEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String retailPrice;  // Changed 'price' to 'retailPrice' in camelCase

    @NotNull
    private String sellingPrice;  // Added 'sellingPrice' field

    @NotNull
    @ElementCollection
    @CollectionTable(name = "pkg_entity_features", joinColumns = @JoinColumn(name = "pkg_entity_id")) // Updated collection table name and join column
    @Column(name = "feature")
    private List<String> features;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PKGEntity(Long id, String name, String retailPrice, String sellingPrice, List<String> features) {
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
        this.sellingPrice = sellingPrice;
        this.features = features;
    }

    public PKGEntity() {
    }

    @Override
    public String toString() {
        return "PKGEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                ", features=" + features +
                '}';
    }
}
