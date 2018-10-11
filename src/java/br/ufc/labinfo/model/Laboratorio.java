package br.ufc.labinfo.model;

import br.ufc.labinfo.dao.LaboratorioDAO;
import br.ufc.labinfo.dao.LaboratorioDAOImpl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Júnior
 */

@Entity
@Table
public class Laboratorio implements Serializable{
    @Id
    @GeneratedValue
    private int codigo;
    @Column
    private String numero;
    @Column
    private int qtd_pcs;
    @Column
    private int capacidade;
    @OneToMany(mappedBy = "laboratorio", 
            targetEntity = Reserva.class, 
            fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL) 
    private List<Reserva> reserva;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    public int getQtd_pcs() {
        return qtd_pcs;
    }

    public void setQtd_pcs(int qtd_pcs) {
        this.qtd_pcs = qtd_pcs;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public boolean cadastrar(String numero, String qtd_pcs, String capacidade) {
        if(numero != null && numero.isEmpty() != true){
             if(qtd_pcs!= null && qtd_pcs.isEmpty() != true){
                 if(capacidade != null && capacidade.isEmpty() != true){
                     LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
                     //Verificar se já existe um outro laboratorio com o mesmo numero
                     Laboratorio lab = new Laboratorio();
                     lab.setNumero(numero);
                     lab.setQtd_pcs(Integer.parseInt(qtd_pcs));
                     lab.setCapacidade(Integer.parseInt(capacidade));
                     laboratorioDAO.adicionarLaboratorio(lab);
                     return true;
                 }
                 return false;
             }
             return false;
         }
        return false;
    }

    public void pesquisar() {

    }

    public void editar() {

    }

    public void excluir() {

    }
}
