package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Usuario;
import br.ufc.labinfo.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Reubber Sousa
 */

public class UsuarioDAOImpl implements UsuarioDAO{
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session se = sf.openSession();

    
    @Override
    public ArrayList<Usuario> getTodosUsuarios() {
        ArrayList<Usuario>usuarios = new ArrayList<Usuario>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
          trns = session.beginTransaction();
          Criteria crit = session.createCriteria(Usuario.class);
          usuarios = (ArrayList<Usuario>) crit.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return usuarios;

    }

    @Override
    public Usuario getUsuario(int id) {
        Usuario usuario = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //String queryString = "from User where id = :id";
           // Query query = session.createQuery(queryString);
           // usuario = (Usuario) query.uniqueResult();
           usuario = (Usuario) session.get(Usuario.class, id);
                    
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return usuario;

    }

    @Override
    public void updateUsuario(Usuario usuario) {
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
          //  session.flush();
            session.close();
        }
 
    }

    @Override
    public void deleteUsuario(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario usuario = (Usuario) session.load(Usuario.class, new Integer(id));
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
    }
    
    @Override
    public void adicionarUsuario(Usuario usuario){
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{ 
        trans = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
       }catch(RuntimeException e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
       }
        finally {
           // se.flush();
            se.close();
        }


    }
}
