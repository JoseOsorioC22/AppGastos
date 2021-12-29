const form = document.getElementById("formGastos");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log(e);
  // obtenemos toda la data del form
  let transactionFormData = new FormData(form);
  let transactionObject = convertFormDataToOjectTransaction(transactionFormData);
  saveTransactionObject(transactionObject)
  insertRowTransactionTable(transactionObject);
  form.reset();  
});

function convertFormDataToOjectTransaction(transactionFormData) {
  let tipoGasto = transactionFormData.get("tipoGasto");
  let descripcion = transactionFormData.get("descripcion");
  let monto = transactionFormData.get("monto");
  let categoria = transactionFormData.get("categoria");

  return {
    "tipoGasto": tipoGasto,
    "descripcion": descripcion,
    "monto": monto,
    "categoria": categoria,
  };
}

const insertRowTransactionTable = (transactionObject) => {
  // obtenemos la tabla gastos
  console.log(transactionObject) 
  let tablaGastos = document.getElementById("tablaGastos");
  // insertamos una fila en dicha tabla
  // (pero solo está la fila sin las celdas)
  let newTransactionRow = tablaGastos.insertRow(-1);

  // Y luego acá insertamos las celdas.
  let newTypeCellRef = newTransactionRow.insertCell(0); 
  newTypeCellRef.textContent = transactionObject.tipoGasto; 

  newTypeCellRef = newTransactionRow.insertCell(1);
  newTypeCellRef.textContent = transactionObject.descripcion; 
 
  newTypeCellRef = newTransactionRow.insertCell(2);
  newTypeCellRef.textContent = transactionObject.monto; 

  newTypeCellRef = newTransactionRow.insertCell(3);
  newTypeCellRef.textContent = transactionObject.categoria; 

  newTypeCellRef = newTransactionRow.insertCell(4);
  newTypeCellRef.textContent = new Date().toLocaleDateString();

  let deleteCell = newTransactionRow.insertCell(5); 
  let deleteButton = document.createElement("button"); 
  deleteButton.textContent = "Eliminar"; 
  
  let editButton =  document.createElement("button"); 
  editButton.textContent = "Editar"; 
 
 deleteCell.appendChild(deleteButton); 
 deleteCell.appendChild(editButton); 

};
   // 
function saveTransactionObject(transactionObject)
{
  let myTransactionArray = JSON.parse(localStorage.getItem("TransactionData")) || []; 
  myTransactionArray.push(transactionObject); 

  // convierto mi array de transaction a json
  let transactionObjectToJson = JSON.stringify(myTransactionArray);
  // Guardo mi array de transaction en el LocalStorage 
  localStorage.setItem("TransactionData", transactionObjectToJson); 
}

  document.addEventListener("DOMContentLoaded", async function(){
     const request = await fetch('gastos', {
       method: 'GET',
       headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
       },
     });
     const gastos = await request.json();
    
     gastos.forEach(gasto => {
       insertRowTransactionTable(gasto); 
     });
})