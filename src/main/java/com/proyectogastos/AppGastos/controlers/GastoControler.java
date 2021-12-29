package com.proyectogastos.AppGastos.controlers;

import com.proyectogastos.AppGastos.models.Gasto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class GastoControler {

    @RequestMapping(value = "gasto/{id}")
    public Gasto getGasto( @PathVariable Long id)
    {
        Gasto gasto = new Gasto();
        gasto.setIdGasto(id);
        gasto.setMonto(2000);
        gasto.setDescripcion("Me comi una hamburguesa");
        gasto.setCategoria("Comida");
    //  Date firstDate = new Date();
        gasto.setFecha(new Date());
        return gasto;
    }

    @RequestMapping(value = "gastos")
    public List<Gasto> getListGasto()
    {
        List<Gasto> gastos = new ArrayList<>();

        Gasto gasto1 = new Gasto();
        gasto1.setIdGasto(230L);
        gasto1.setMonto(2000);
        gasto1.setDescripcion("Me comi una hamburguesa");
        gasto1.setCategoria("Comida");
        gasto1.setTipo("Egreso");
        //  Date firstDate = new Date();
        gasto1.setFecha(new Date());

        Gasto gasto2 = new Gasto();
        gasto2.setIdGasto(78L);
        gasto2.setMonto(500);
        gasto2.setDescripcion("Me comi un pan ");
        gasto2.setCategoria("Comida");
        gasto2.setTipo("Egreso");
        //  Date firstDate = new Date();
        gasto2.setFecha(new Date());

        Gasto gasto3 = new Gasto();
        gasto3.setIdGasto(524L);
        gasto3.setMonto(2000);
        gasto3.setDescripcion("Me comi una hamburguesa");
        gasto3.setCategoria("Comida");
        gasto3.setTipo("Egreso");
        //  Date firstDate = new Date();
        gasto3.setFecha(new Date());

        gastos.add(gasto1);
        gastos.add(gasto2);
        gastos.add(gasto3);

        return gastos;
    }



    @RequestMapping(value = "gasto123")
    public Gasto editarGasto()
    {
        Gasto gasto = new Gasto();

        return gasto;
    }


    @RequestMapping(value = "gasto456")
    public Gasto eliminarGasto()
    {
        Gasto gasto = new Gasto();

        return gasto;
    }

    @RequestMapping(value = "gasto789")
    public Gasto buscarGasto()
    {
        Gasto gasto = new Gasto();

        return gasto;
    }

}
