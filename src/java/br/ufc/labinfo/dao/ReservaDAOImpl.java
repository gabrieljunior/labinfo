package br.ufc.labinfo.dao;

import br.ufc.labinfo.model.Reserva;
import br.ufc.labinfo.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReservaDAOImpl implements ReservaDAO{
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session se = sf.openSession();

    
    @Override
    public ArrayList<Reserva> getTodosReservas() {
        ArrayList<Reserva>reservas = new ArrayList<Reserva>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
          trns = session.beginTransaction();
          Criteria crit = session.createCriteria(Reserva.class);
          reservas = (ArrayList<Reserva>) crit.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return reservas;

    }

    @Override
    public Reserva getReserva(int id) {
        Reserva reserva = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //String queryString = "from User where id = :id";
           // Query query = session.createQuery(queryString);
           // reserva = (Reserva) query.uniqueResult();
           reserva = (Reserva) session.get(Reserva.class, id);
                    
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
        return reserva;

    }

    @Override
    public void updateReserva(Reserva reserva) {
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(reserva);
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
    public void deleteReserva(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Reserva reserva = (Reserva) session.load(Reserva.class, new Integer(id));
            session.delete(reserva);
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
    public void adicionarReserva(Reserva reserva){
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{ 
        trans = session.beginTransaction();
            session.save(reserva);
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
