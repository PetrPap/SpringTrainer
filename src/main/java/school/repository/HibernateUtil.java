
package school.repository;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil<E> {
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    protected Session getSession() {
       session = sessionFactory.getCurrentSession();//One for each connection to DB
        return session;
    }
    
    //Methods for CRUD operations
    protected List<E> findAll(String query){
        getSession();
        Query myQuery = session.createNamedQuery(query);
        List<E> list = myQuery.getResultList();
        return list;
    }
    
    protected E save(E entity){
        //save object in DB
       session = getSession();
       session.saveOrUpdate(entity);
        
        return entity;
    }
    
    protected E find(Class<E> type, int id){  //find by ID
    session = getSession();
     E e =session.find(type, id);
     
     return e;
 }
    
    public void delete(Class<E> type, int id){
    session = getSession();
     E e =session.find(type, id);
    session.remove(e);
     
  }
    
    
}
