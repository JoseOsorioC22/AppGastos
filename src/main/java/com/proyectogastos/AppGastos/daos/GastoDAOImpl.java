package com.proyectogastos.AppGastos.daos;

import com.proyectogastos.AppGastos.models.Gasto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import  javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Repository

@Transactional

public class GastoDAOImpl implements GastoDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Gasto> getGastos() {
        String query = "FROM Gasto";
        List<Gasto> ListaGastos = entityManager.createQuery(query).getResultList();
        return ListaGastos;
    }

    @Override
    public void eliminarGasto(int id)
    {
        Gasto gasto = entityManager.getReference(Gasto.class,id);
        entityManager.remove(gasto);
    }

    @Override
    public void registrar(Gasto gasto)
    {
        entityManager.merge(gasto);
    }


}
