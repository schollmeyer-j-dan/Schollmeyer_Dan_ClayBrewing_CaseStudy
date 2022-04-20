package com.optum.Ingredient;

import com.optum.Inventory.Inventory;
import com.sun.istack.NotNull;

import javax.persistence.*;
// import javax.validation.contstraints.Size;
import java.util.Objects;

@Entity
@Table(name="Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //TODO: add dependency for validation.  @Size(min=2, max = 30)

    private String name;

    private String description;

    private int quantity;

    private String quantityType;


/*
    public Ingredient(int id, String name, String description, String quantityType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityType = quantityType;
        this.quantity = 0;
        save();
    }
*/




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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredient = (Ingredient) o;
        return id == ingredient.id
                && Objects.equals(name, ingredient.name)
                && Objects.equals(quantity, ingredient.quantity)
                && Objects.equals(quantityType, ingredient.quantityType)
                && Objects.equals(description, ingredient.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, description,quantity,quantityType);
    }

}
