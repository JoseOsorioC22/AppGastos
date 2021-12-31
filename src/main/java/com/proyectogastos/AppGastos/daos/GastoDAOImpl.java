package com.proyectogastos.AppGastos.daos;

import com.proyectogastos.AppGastos.models.Gasto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import  javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

@Transactional

public class GastoDAOImpl implements  GastoDAO<Long,Gasto>{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Gasto> getGastos() {
        String query = "FROM gastos";
        List<Gasto> ListaGastos = entityManager.createQuery(query).getResultList();
        return ListaGastos;
    }

}
