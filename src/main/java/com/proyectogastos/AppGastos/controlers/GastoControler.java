package com.proyectogastos.AppGastos.controlers;

import com.proyectogastos.AppGastos.daos.GastoDAO;
import com.proyectogastos.AppGastos.models.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class GastoControler {

    @Autowired
    private GastoDAO gastoDAO;

    @RequestMapping(value = "api/gasto/{id}", method = RequestMethod.GET )
    public Gasto getGasto( @PathVariable Long id)
    {
        Gasto gasto = new Gasto();
     //   gasto.setIdGasto(id);
        gasto.setMonto(2000);
        gasto.setDescripcion("Me comi una hamburguesa");
       // gasto.setCategoria();
    //  Date firstDate = new Date();
        gasto.setFecha(new Date());
        return gasto;
    }

    @RequestMapping(value = "api/gastos" ,  method = RequestMethod.GET  )
    public List<Gasto> getListGasto()
    {
        return gastoDAO.getGastos();
    }

@RequestMapping(value="api/gastos" , method = RequestMethod.POST )
public void registrarGasto( @RequestBody Gasto gasto)
{
     gastoDAO.registrar(gasto);
}


    @RequestMapping(value = "api/gastos/{id}", method = RequestMethod.DELETE)
    public void eliminarGasto(@PathVariable int id)
    {
         gastoDAO.eliminarGasto(id);
    }

    @RequestMapping(value = "gasto789")
    public Gasto buscarGasto()
    {
        Gasto gasto = new Gasto();

        return gasto;
    }

}
