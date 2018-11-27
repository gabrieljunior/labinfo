/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.labinfo.commands;

import br.ufc.labinfo.dao.LaboratorioDAO;
import br.ufc.labinfo.dao.LaboratorioDAOImpl;
import br.ufc.labinfo.dao.UsuarioDAO;
import br.ufc.labinfo.dao.UsuarioDAOImpl;
import br.ufc.labinfo.model.Laboratorio;
import br.ufc.labinfo.model.Reserva;
import br.ufc.labinfo.model.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Júnior
 */
public class ReservarLaboratorio implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        //Recuperando os paremetros recebidos na requisição
        String descricao = request.getParameter("descricao");
        String data = request.getParameter("data");
        String horaInicio = "20:00";
        String horaFim = "21:00";
        
        //Formatando a data em LocalDate
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();
        date.setTime((Date) formatter1.parse(data));
        System.out.print(date.toString());
        
        //Formatando horas em LocalTime
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        Calendar horaIni = Calendar.getInstance();
        horaIni.setTime((Date) formatter2.parse(horaInicio));
        Calendar horaFi = Calendar.getInstance();
        horaFi.setTime((Date) formatter2.parse(horaFim));
        UsuarioDAO usuarios = new UsuarioDAOImpl();
        Usuario usuario = usuarios.getUsuario(379059);
        LaboratorioDAO lab = new LaboratorioDAOImpl();
        Laboratorio laboratorio = (Laboratorio) lab.getLaboratorio(1);
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setLaboratorio(laboratorio);
        reserva.setDescricao(descricao);
        reserva.setDataReservada(date);
        reserva.setHoraInicio(horaIni);
        reserva.setHoraFim(horaFi);
        reserva.setStatus("Aguardando confirmação");
        
        if(reserva.reservar() == true){
            try {
                String url = "/sucesso.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String url = "/reservar_laboratorio.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
}

