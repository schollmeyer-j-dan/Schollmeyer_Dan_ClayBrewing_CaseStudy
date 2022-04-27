package com.optum.quantity_type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class QuantityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @NotNull
    private String type;
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
