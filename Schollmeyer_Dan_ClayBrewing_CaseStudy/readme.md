Schollmeyer_Dan_ClayBrewing_CaseStudy
Clay Brewing Management System Objective: Inventory management system for a brewery

[Case Study Rubric](https://docs.google.com/document/d/1O7AGv8L45iEWtyzFRXaKQKXdCE8jD0ci3aecPGFQt-0/edit)
Estimated completion: 80%

TODO::User Stories.

Stories:
[] As a user I would like to be able to reduce inventory amounts so that our inventory is up-to-date.
[] As a user I would like to be able to increase inventory so that our inventory is up-to-date.
[] As a user I would like to be able to review inventory so that I know which beer we have supplies on hand for.
[] As a user I would like to review inventory so that I know when to re-order supplies.

Daily Progress:
    todo for today:
        [x] get update fixed
        [x] navbar
        [x] validation
        [] add quantityType model and remap to front end options
        [] add recipe model, would need to be many to many on ingredient list...
        [] Schema Diagram
        [] Tech Stack Diagram
        [] Wireframe (draw.io)
        [] update rubric to determine remaining priorities
        [] test rest controller
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




Stretch Goals:
    separate package or project to manage recipes
        check for available supplies and/or put in reorder requests for upcoming batches
        update quantity on appropriate items when producing given recipe
        possibly add friends/user communication portal for sharing recipes



