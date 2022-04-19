package com.optum.Inventory;

import com.optum.Ingredient.Ingredient;

import java.util.HashMap;

public class Inventory {
    private static HashMap<Integer, Ingredient> inventoryMap;

    public static HashMap<Integer, Ingredient> getInventoryMap() {
        return inventoryMap;
    }
    public static void setInventoryMap(HashMap<Integer, Ingredient> inventoryMap) {
        Inventory.inventoryMap = inventoryMap;
    }

    public Inventory() {
        inventoryMap = new HashMap<>();
        // TODO: populateInventoryFromDB();
        addTestIngredient();
    }

    public static void saveIngredient(Ingredient ingredient) {
        inventoryMap.put(ingredient.getId(),ingredient);
    }

    //this code to be moved to test class once test is created
    private void addTestIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(999);
        ingredient.setName("test ingredient");
        ingredient.setDescription("a test ingredient");
        ingredient.setQuantityType("pounds?");
        ingredient.setQuantity(1);
        inventoryMap.put(ingredient.getId(), ingredient);
    }
}