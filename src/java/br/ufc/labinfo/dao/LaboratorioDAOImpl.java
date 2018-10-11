package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Laboratorio;
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

public class LaboratorioDAOImpl implements LaboratorioDAO{
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session se = sf.openSession();

    
    @Override
    public ArrayList<Laboratorio> getTodosLaboratorios() {
        ArrayList<Laboratorio>laboratorios = new ArrayList<Laboratorio>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
          trns = session.beginTransaction();
          Criteria crit = session.createCriteria(Laboratorio.class);
          laboratorios = (ArrayList<Laboratorio>) crit.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return laboratorios;

    }

    @Override
    public Laboratorio getLaboratorio(int id) {
        Laboratorio laboratorio = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //String queryString = "from User where id = :id";
           // Query query = session.createQuery(queryString);
           // laboratorio = (Laboratorio) query.uniqueResult();
           laboratorio = (Laboratorio) session.get(Laboratorio.class, id);
                    
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return laboratorio;

    }

    @Override
    public void updateLaboratorio(Laboratorio laboratorio) {
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(laboratorio);
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
    public void deleteLaboratorio(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Laboratorio laboratorio = (Laboratorio) session.load(Laboratorio.class, new Integer(id));
            session.delete(laboratorio);
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
    public void adicionarLaboratorio(Laboratorio laboratorio){
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{ 
        trans = session.beginTransaction();
            session.save(laboratorio);
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
