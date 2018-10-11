package br.ufc.labinfo.model;

import br.ufc.labinfo.dao.UsuarioDAO;
import br.ufc.labinfo.dao.UsuarioDAOImpl;
import br.ufc.labinfo.util.Erro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel Júnior
 */

@Entity
@Table
public class Usuario implements Serializable{
    @Id
    private int siape;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private int nivelAcesso;
    @OneToMany(mappedBy = "usuario", 
            targetEntity = Reserva.class, 
            fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL) 
    private List<Reserva> reserva;

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
   
    public boolean autenticar(HttpServletRequest request){
        Erro erros = new Erro();
        String codigo = request.getParameter("codigo");
        String senha = request.getParameter("senha");
        if(codigo != null && codigo.isEmpty() != true){
            if(senha != null && senha.isEmpty() != true){
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
                
                Usuario usuario = usuarioDAO.getUsuario(Integer.parseInt(codigo));
                
                if(usuario != null){
                    if(usuario.getSenha().equals(senha)){
                        //Cria a sessão
                        HttpSession sessao = request.getSession();
                        /*Verificação nível de acesso e coloca na sessão
                        sessao.setAttribute("tipo", usuario.getNivelAcesso());*/
                        sessao.setAttribute("usuario", usuario);
                        return true;
                    }else{
                        erros.add("Senha incorreta!");
                    }
                }else{
                    erros.add("Usuario não cadastrado!");
                }
            }else{
                erros.add("Senha não informada!");
            }
        }else{
            erros.add("Código não informado!");
        }
        
        request.getSession().invalidate();
        
        request.setAttribute("mensagens", erros);
        
        return false;  
    }
    
    public boolean cadastrar(String nome, String codigo, String email, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        
        if(usuarioDAO.getUsuario(Integer.parseInt(codigo))== null){
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setSiape(Integer.parseInt(codigo));
            usuario.setEmail(email);
            usuario.setSenha(senha);
            //Tem que mudar
            usuario.setNivelAcesso(1);
            
            usuarioDAO.adicionarUsuario(usuario);
            return true;
        }
        return false;
    }

    public void logouf() {

    }
}
