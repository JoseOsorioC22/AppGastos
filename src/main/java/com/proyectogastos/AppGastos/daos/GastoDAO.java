package com.proyectogastos.AppGastos.daos;

import java.util.List;

public interface GastoDAO <T,K>{

    public List<K> getGastos();

}
