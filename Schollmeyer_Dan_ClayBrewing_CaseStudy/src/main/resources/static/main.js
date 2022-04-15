var name;
var quantityType;
var createNewIngredientButton = document.querySelector('#createSubmit');
createNewIngredientButton.addEventListener('click',createNewIngredient);


function createNewIngredient(event){
event.preventDefault();
name = document.querySelector("#ingredientName").value;
quantityType = document.querySelector("#ingredientQuantityType").value;
itemCreatedTable();
}

function itemCreatedTable(){
let inventoryTable = document.querySelector("#itemCreatedTable");
inventoryTable.innerHTML += '<tr><th align="left">Name</th><th align="left">Quantity Type</th><th align="left">Quantity</th></tr><tr><td>' +
                        name +
                        '</td><td>' +
                        quantityType +
                        '</td><td>0</td></tr>';
name = "";
quantityType = "";

}
