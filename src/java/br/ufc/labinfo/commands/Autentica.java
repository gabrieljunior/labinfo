package br.ufc.labinfo.commands;

import br.ufc.labinfo.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reubber Sousa
 */

public class Autentica implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        Usuario usuario = new Usuario();
        
        if(usuario.autenticar(request) == true){
            RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
            try {
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            try {
                rd.forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
