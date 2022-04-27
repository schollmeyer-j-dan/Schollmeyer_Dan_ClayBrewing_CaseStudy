INSERT INTO quantity_type (id,type) VALUES (1,"Pounds");
INSERT INTO quantity_type (id,type) VALUES (2,"Ounces");
INSERT INTO quantity_type (id,type) VALUES (3,"Grams");
INSERT INTO quantity_type (id,type) VALUES (4,"Teaspoons");
INSERT INTO quantity_type (id,type) VALUES (5,"Packets");
INSERT INTO quantity_type (id,type) VALUES (6,"Items");

INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (1,'Dry Wheat Malt',1,3.25);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (2,'Wheat Malt',1,2);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (3,'Pilsner Malt',1,1);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (4,'Hallertau hops',2,1.3);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (5,'Irish moss',4,1);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (6,'Yellow Grapefruit (Zested)',6,3);
INSERT INTO ingredients (id,name,quantity_type_id,quantity) VALUES (7,'Corn sugar',2,5);

INSERT INTO recipes (id,name) VALUES (1,"My First Recipe");

INSERT INTO recipes_ingredients (recipe_id,ingredient_id) VALUES (1,1);
INSERT INTO recipes_ingredients (recipe_id,ingredient_id) VALUES (1,2);
INSERT INTO recipes_ingredients (recipe_id,ingredient_id) VALUES (1,3);
INSERT INTO recipes_ingredients (recipe_id,ingredient_id) VALUES (1,4);