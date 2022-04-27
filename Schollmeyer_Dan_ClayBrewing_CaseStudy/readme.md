Schollmeyer_Dan_ClayBrewing_CaseStudy
Clay Brewing Management System Objective: Inventory management system for a brewery

[Tech Stack Diagram](TechStack.png)
[Schema Diagram](schemaDiagram.pdf)

[Case Study Rubric](https://docs.google.com/document/d/1O7AGv8L45iEWtyzFRXaKQKXdCE8jD0ci3aecPGFQt-0/edit)

Stories:
[] As a user I would like to be able to increase/reduce inventory amounts so that our inventory is up-to-date.
[] As a user I would like to be able to review inventory so that I know which beer we have supplies on hand for.
[] As a user I would like to review inventory so that I know when to re-order supplies.
[] As a user I would like to be able to add a new Ingredient to our inventory.
[] As a user I would like to be able to remove an Ingredient from our inventory.
[] As a user I would like to be able to view our recipes.

4/26:
    Added view for recipe list and added the view to navbar
    Added a recipe to data.sql
    Added Recipe Model and repo/service/controller
    Added Tech Stack diagram
    Added Schema diagram 
    Created model for QuantityType
    Implemented repo and service for QuantityType
    Connected Ingredient display/create/update with QuantityType model
4/25:
    Implemented Update for Ingredient
    Implemented Navbar on all pages (replaced existing buttons)
    Updated styling to use bootstrap
    Added validation on Entity model
    Implemented testing for IngredientServiceImpl
    Added REST Controller for Ingredient
4/24:
    Implemented Create/Delete for Ingredient.
    Began implementation of update, currently adding new item rather than updating current item
4/22:
    Got data.dql working on initial run (was previously only working after second run)
4/20:
    Updated model (column name issue) to get table create working in database
    Updated HTML pages/buttons for navigation (should be moved to navbar in future)
    Added data.sql to populate ingredients table
    Added thymeleaf to DisplayInventory, successfully reading/displaying from database
4/19:
    Set up service/repo/controller for ingredients
    CRUD operations moved from model to controller. Not working with front end yet
4/18:
    Readme formatting updated.
    Not feeling well, very little progress made
4/15/22:
    Created new gitHub repository
    Added newly created project to gitHub


What I learned:
    The area in which I feel I learned the most was working with Spring JPA.
        I had to do some research to get the bindings working correctly and populating the database,
        as well as getting the foreign key / join table to work.
    


Future Goals:
    [] Would like to add ordering info such as vendor/item#
    [] Add package for managing recipes
        Ability to add recipe from provided ingredient in inventory
        check for available supplies and/or put in reorder requests for upcoming batches
        update quantity on appropriate items when producing given recipe
        possibly add friends/user communication portal for sharing recipes
    



