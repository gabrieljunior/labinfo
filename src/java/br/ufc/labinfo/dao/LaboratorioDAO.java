package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Laboratorio;
import java.util.ArrayList;

/**
 *
 * @author Reubber Sousa
 */

public interface LaboratorioDAO {
    public ArrayList<Laboratorio> getTodosLaboratorios();
    public Laboratorio getLaboratorio(int id);
    public void updateLaboratorio(Laboratorio laboratorio);
    public void deleteLaboratorio(int id);
    public void adicionarLaboratorio(Laboratorio laboratorio);
}