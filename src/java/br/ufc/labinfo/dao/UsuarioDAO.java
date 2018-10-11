package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reubber Sousa
 */

public interface UsuarioDAO {
    public ArrayList<Usuario> getTodosUsuarios();
    public Usuario getUsuario(int codigo);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void adicionarUsuario(Usuario usuario);
}
