package com.ddway.anagraficaBS.dao;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ddway.anagraficaBS.model.bean.Restriction;

@Service
public class DataSourceDaoImpl implements IDataSourceDao {
	
private static final Logger log = LoggerFactory.getLogger(DataSourceDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactoryAnagraficaBS;
	
	@Override
	public void insert(Object bean){		
		log.debug("Start WriteDaoImpl.insert method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().save(bean);
	        log.debug("WriteDaoImpl.insert successful");	        
	        }catch (RuntimeException re) {
	        	log.error("WriteDaoImpl.insert failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	@Override
	public void insertOrUpdate(Object bean){		
		log.debug("Start WriteDaoImpl.insert method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().saveOrUpdate(bean);
	        log.debug("WriteDaoImpl.insert successful");	        
	        }catch (RuntimeException re) {
	        	log.error("WriteDaoImpl.insert failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public void update(Object bean){
		log.debug("Start WriteDaoImpl.update method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().update(bean);
	        log.debug("WriteDaoImpl.update successful");	        
	        }catch (RuntimeException re) {
	        	log.error("WriteDaoImpl.update failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public void delete(Object bean){
		log.debug("Start WriteDaoImpl.update method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().delete(bean);
	        log.debug("WriteDaoImpl.update successful");	        
	        }catch (RuntimeException re) {
	        	log.error("WriteDaoImpl.update failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public void updateSql(String queryString){
		log.debug("Start WriteDaoImpl.update method");
		try {
			Query query = sessionFactoryAnagraficaBS.getCurrentSession().createQuery(queryString);				
			log.debug("WriteDaoImpl.updateSql successful");			
		}catch (RuntimeException re){
			log.error("WriteDaoImpl.updateSql failed", re);
			re.printStackTrace();
			throw re;
			}
	}
	
	@Override
	public Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {		
		log.debug("Start ReadDaoImpl.findbyId method");
		try {						
			Object tabellaCorrente = (Object) Class.forName(beanName).newInstance();		
			tabellaCorrente   = (Object) sessionFactoryAnagraficaBS.getCurrentSession().get(tabellaCorrente.getClass(), id);
	        log.debug("ReadDaoImpl.findbyId successful");
	        return tabellaCorrente;
	        }catch (RuntimeException re) {
	        	log.error("ReadDaoImpl.findbyId failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
		
	@Override
	public Object findbyId(Object id) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {		
		log.debug("Start ReadDaoImpl.findbyId method");
		try {						
			Object tabellaCorrente = (Object) Class.forName(id.getClass().getName().substring(0, id.getClass().getName().length()-2)).newInstance();		
			tabellaCorrente   = (Object) sessionFactoryAnagraficaBS.getCurrentSession().get(id.getClass().getName().substring(0, id.getClass().getName().length()-2),  (Serializable) id);			
	        log.debug("ReadDaoImpl.findbyId successful");
	        return tabellaCorrente;
	        }catch (RuntimeException re) {
	        	log.error("ReadDaoImpl.findbyId failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		log.debug("Start ReadDaoImpl.findAll method");
		try {							
			List<Object> list = sessionFactoryAnagraficaBS.getCurrentSession().createQuery("from "+beanName).list();
			log.debug("ReadDaoImpl.findAll successful");
			return list;
			}catch (RuntimeException re){
				log.error("ReadDaoImpl.findAll failed", re);
				re.printStackTrace();
				throw re;
				}
		}	
	
	@Override
	public List<Object> genericquery(String queryString){
		log.debug("Start ReadDaoImpl.genericquery method");
		try {
			Query query = sessionFactoryAnagraficaBS.getCurrentSession().createQuery(queryString);				
			log.debug("ReadDaoImpl.genericquery successful");
			return query.list();
		}catch (RuntimeException re){
			log.error("ReadDaoImpl.genericquery failed", re);
			re.printStackTrace();
			throw re;
			}
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByCriteria(Object oggettoDb, Hashtable params,String orderField) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		log.debug("Start ReadDaoImpl.findAllonwrite method");
		try {							
				
			Criteria criteria = sessionFactoryAnagraficaBS.getCurrentSession().createCriteria(oggettoDb.getClass());
			//.add(Restrictions.eq("id.codLocaleProg", codLocaleProgetto));
			
			Enumeration chiavi = params.keys();
			 while(	chiavi.hasMoreElements()){
				String chiave =(String)  chiavi.nextElement();
				criteria.add(Restrictions.eq(chiave, params.get(chiave)));
				if(orderField != null && !orderField.equalsIgnoreCase(""))
					criteria.addOrder(Order.asc(orderField));
			 }
			
				
			log.debug("findAllonwrite successful");
			return criteria.list();
			}catch (RuntimeException re){
				log.error("findAllonwrite failed", re);
				re.printStackTrace();				throw re;
				}
		}	

	
	@Override
	public List<Object> findByCriteriaDistinct(Object classe, String distinctList[],List<Restriction> restrictions){
		log.debug("Start ReadDaoImpl.findByCriteriaDistinct method");
		
		ProjectionList projList = Projections.projectionList();
		try {
			Criteria criteria = sessionFactoryAnagraficaBS.getCurrentSession().createCriteria(classe.getClass());
			if(distinctList != null){
			for(int i=0; i < distinctList.length; i++){
				 projList.add(Projections.property(distinctList[i]));
			}
			criteria.setProjection(Projections.distinct(projList));
			criteria.addOrder(Order.asc(distinctList[0]));
			}
			if(restrictions != null){
				for(int i=0; i < restrictions.size(); i++){
					criteria.add(Restrictions.eq(restrictions.get(i).getPropertyName(), restrictions.get(i).getValue()));
				}
			}
			List<Object> resultList =  criteria.list();
			log.debug("ReadDaoImpl.findByCriteriaDistinct success");
			return 	resultList;	   
		}catch (RuntimeException re){
			log.error("ReadDaoImpl.findByCriteriaDistinct failed", re);
			re.printStackTrace();
			throw re;
			}
	}
}

