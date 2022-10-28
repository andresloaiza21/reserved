package com.reserved.persistence.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "id_restaurante")
    private Integer idRestaurante;

    @Column(name = "numero_comensales")
    private Integer numeroComensales;

    private Date fecha;
    //private Time time;
    private String decoracion;
    private String nota;

    @ManyToOne
    @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", insertable = false, updatable = false)
    private Restaurante restaurante;

    @OneToMany(mappedBy = "reserva", cascade = {CascadeType.ALL})
    private List<ReservasCliente> reservas;

    public List<ReservasCliente> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservasCliente> reservas) {
        this.reservas = reservas;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Integer getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(Integer numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

  /*  public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }*/

    public String getDecoracion() {
        return decoracion;
    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
