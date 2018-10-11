package br.ufc.labinfo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Júnior
 */

@Entity
@Table
public class Reserva implements Serializable{
    @Id
    @GeneratedValue
    private int cod;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="cod_laboratorio")
    private Laboratorio laboratorio;
    @Column
    private String descricao;
    @Column
    private LocalDate dataReservada;
    @Column
    private LocalTime horaInicio;
    @Column
    private LocalTime horaFim;
    @Column
    private String status;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataReservada() {
        return dataReservada;
    }

    public void setDataReservada(LocalDate dataReservada) {
        this.dataReservada = dataReservada;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
