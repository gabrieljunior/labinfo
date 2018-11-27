package br.ufc.labinfo.model;

import br.ufc.labinfo.dao.LaboratorioDAO;
import br.ufc.labinfo.dao.LaboratorioDAOImpl;
import br.ufc.labinfo.dao.ReservaDAO;
import br.ufc.labinfo.dao.ReservaDAOImpl;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.DATE)
    private Date dataReservada;
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    private Date horaFim;
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

    public Date getDataReservada() {
        return dataReservada;
    }

    public void setDataReservada(Date dataReservada) {
        this.dataReservada = dataReservada;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean reservar(){
        ReservaDAO reserva = new ReservaDAOImpl();
        reserva.adicionarReserva(this);
        return true;
    }
}
