/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.labinfo.commands;

import br.ufc.labinfo.model.Laboratorio;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Júnior
 */
public class AdicionaLaboratorio implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String numero = request.getParameter("numero");
        String qtd_pcs = request.getParameter("qtd_pcs");
        String  capacidade = request.getParameter("capacidade");
        Laboratorio laboratorio = new Laboratorio();
        if(laboratorio.cadastrar(numero, qtd_pcs, capacidade) == true){
            try {
                String url = "/sucesso.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String url = "/adcionar_laboratorio.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
    
}
