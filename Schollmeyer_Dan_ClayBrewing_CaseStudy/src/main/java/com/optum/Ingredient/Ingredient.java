package com.optum.Ingredient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    @Size(min=2, max = 30)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    private int quantity;
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotNull
    private String quantityType;
    public String getQuantityType() {
        return quantityType;
    }
    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

/*
    public Ingredient (){}
    public Ingredient(int id, String name, String description, String quantityType, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityType = quantityType;
        this.quantity = quantity;
    }
*/

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredient = (Ingredient) o;
        return Objects.equals(id,ingredient.id)
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
