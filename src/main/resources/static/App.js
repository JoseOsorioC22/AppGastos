const form = document.getElementById("formGastos");


form.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log(e);
  // obtenemos toda la data del form
  let transactionFormData = new FormData(form);
  let transactionObject = convertFormDataToOjectTransaction(transactionFormData);
  saveGastoObject(transactionObject);
  insertRowTransactionTable(transactionObject);
  form.reset();
});

function convertFormDataToOjectTransaction(transactionFormData) {

  let tipo = transactionFormData.get("tipoGasto");
  let descripcion = transactionFormData.get("descripcion");
  let monto = transactionFormData.get("monto");
  let categoria = transactionFormData.get("categoria");
  let fecha = new Date(); 

  return {
    tipo: tipo,
    descripcion: descripcion,
    monto: monto,
    categoria: categoria,
    fecha: fecha,
  };
}

const insertRowTransactionTable = (transactionObject) => {
  // obtenemos la tabla gastos
  console.log(transactionObject);
  let tablaGastos = document.getElementById("tablaGastos");

  let fila = document.createElement("tr");
  fila.innerHTML = `<td>${transactionObject.tipo}</td> 
  <td>${transactionObject.descripcion}</td>
  <td>${transactionObject.monto}</td> 
  <td>${transactionObject.categoria}</td>
  <td>${transactionObject.fecha}</td>
  <td><a href= "#" name= "editar"  class="btn btn-info">Editar</a>
  <a href= "#" name= "eliminar" onclick="deleteGasto(${transactionObject.idGasto})" class="btn btn-danger">
  Eliminar</a></td>`;
  tablaGastos.appendChild(fila);
};


// POST (make a save)
const  saveGastoObject = async  (transactionObject) => {
  const request = await fetch("api/gastos", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(transactionObject)
  });
}


// GET ALL GASTOS
document.addEventListener("DOMContentLoaded", async function () {
  const request = await fetch("api/gastos", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  const gastos = await request.json();

  gastos.forEach((gasto) => {
    insertRowTransactionTable(gasto);
  });
});





// DELETE 
 const deleteGasto = async (id) =>
{
  if(confirm("¿Deseas eliminar este gasto?"))
  {
    const request = await fetch("api/gastos/"+id, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    location.reload(); 
  }
  

  
  
}