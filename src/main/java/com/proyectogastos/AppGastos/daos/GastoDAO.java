package com.proyectogastos.AppGastos.daos;

import java.util.List;
import com.proyectogastos.AppGastos.models.Gasto;
public interface GastoDAO {

    public List<Gasto> getGastos();
    public void eliminarGasto(int id);
    public void registrar(Gasto gasto);
}
