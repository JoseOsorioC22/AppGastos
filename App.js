const form = document.getElementById("formGastos");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log(e);
  // obtenemos toda la data del form
  let transactionFormData = new FormData(form);

  insertRowTransactionTable(transactionFormData);
});

const insertRowTransactionTable = (transactionFormData) => {
  // obtenemos la tabla gastos
  let tablaGastos = document.getElementById("tablaGastos");
  // insertamos una fila en dicha tabla
  // (pero solo está la fila sin las celdas)
  let newTransactionRow = tablaGastos.insertRow(-1);

  let newTypeCellRef = newTransactionRow.insertCell(0); // Y luego acá insertamos las celdas.


  newTypeCellRef.textContent = transactionFormData.get("tipoGasto");

  newTypeCellRef = newTransactionRow.insertCell(1);

  newTypeCellRef.textContent = transactionFormData.get("descripcion");

  newTypeCellRef = newTransactionRow.insertCell(2);

  newTypeCellRef.textContent = transactionFormData.get("monto");

  newTypeCellRef = newTransactionRow.insertCell(3);

  newTypeCellRef.textContent = transactionFormData.get("categoria");

  newTypeCellRef = newTransactionRow.insertCell(4);

  newTypeCellRef.textContent = new Date().toLocaleDateString();
};
