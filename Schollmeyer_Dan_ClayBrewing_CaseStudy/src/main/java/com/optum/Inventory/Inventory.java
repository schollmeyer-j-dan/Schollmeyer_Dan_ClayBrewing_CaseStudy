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
    }

    public static void saveIngredient(Ingredient ingredient) {
        inventoryMap.put(ingredient.getId(),ingredient);
    }

}