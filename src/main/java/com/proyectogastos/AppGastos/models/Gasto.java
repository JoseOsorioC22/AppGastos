package com.proyectogastos.AppGastos.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="gasto")
@ToString
public class Gasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_gasto")
    private int idGasto;

    @Getter @Setter @Column(name = "tipo")
    private String tipo;

    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;

    @Getter @Setter @Column(name = "fecha")
    private Date Fecha;

    @Getter @Setter @Column(name = "monto")
    private double monto;

    @Getter @Setter
    private String categoria;



}
