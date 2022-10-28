package com.reserved.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservas_clientes")
public class ReservasCliente {
    @EmbeddedId
    private ReservasClientePK id;

    @Column(name = "medio_pago")
    private String medioPago;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "id_reserva", insertable = false, updatable = false)
    private Reserva reserva;

    @ManyToOne

    @JoinColumn(name = "id_Cliente", insertable = false, updatable = false)
    private Cliente cliente;

}
