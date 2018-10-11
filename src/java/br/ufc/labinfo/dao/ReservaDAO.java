package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Reserva;
import java.util.ArrayList;
import java.util.List;

public interface ReservaDAO {
    public ArrayList<Reserva> getTodosReservas();
    public Reserva getReserva(int codigo);
    public void updateReserva(Reserva reserva);
    public void deleteReserva(int id);
    public void adicionarReserva(Reserva reserva);
}
