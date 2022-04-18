package com.optum.Ingredient;

import com.optum.Inventory.Inventory;

public class Ingredient {
    private int id;
    private String name;
    private String description;
    private String quantityType;
    private int quantity;

    public Ingredient() {
    }

    public Ingredient(int id, String name, String description, String quantityType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityType = quantityType;
        this.quantity = 0;
        save();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean create(int id, String name, String description, String quantityType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityType = quantityType;
        this.quantity = 0;
        return save();
    }

    public boolean update(String name, String description, String quantityType, int quantity) {
        this.name = name;
        this.description = description;
        this.quantityType = quantityType;
        this.quantity = quantity;
        return save();
    }

    private boolean save() {
        Inventory.saveIngredient(this);
        return Inventory.getInventoryMap().containsKey(this.id);
        //update method for failure? connect to db.
    }
}
