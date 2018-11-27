/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.labinfo.commands;

import br.ufc.labinfo.dao.UsuarioDAO;
import br.ufc.labinfo.dao.UsuarioDAOImpl;
import br.ufc.labinfo.model.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class NewClass {
    public static void main(String[] args) {
        String data = "2018-02-05";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(data,formatter1);
        System.out.print(date.toString());
        UsuarioDAO usuarios = new UsuarioDAOImpl();
        Usuario usuario = usuarios.getUsuario(379059);
        
        System.out.print(usuario.getNome());
        
    }
}
