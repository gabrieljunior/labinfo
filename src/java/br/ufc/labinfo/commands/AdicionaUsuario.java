/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.labinfo.commands;

import br.ufc.labinfo.model.Laboratorio;
import br.ufc.labinfo.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Júnior
 */
public class AdicionaUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String codigo = request.getParameter("codigo");
        String  email = request.getParameter("email");
        String  senha = request.getParameter("senha");
        Usuario usuario = new Usuario();
        if(usuario.cadastrar(nome, codigo, email, senha) == true){
            try {
                String url = "/sucesso.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String url = "/adicionar_usuario.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
    
}
