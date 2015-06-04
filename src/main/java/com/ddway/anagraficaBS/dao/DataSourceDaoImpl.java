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
	
	@Autowired
	private SessionFactory sessionFactoryInfap;
	
	@Autowired
	private SessionFactory sessionFactoryCommon;
	
	@Override
	public void insert(Object bean){		
		log.info("Start DataSourceDaoImpl.insert method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().save(bean);
	        log.info("DataSourceDaoImpl.insert successful");	        
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.insert failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	@Override
	public void insertOrUpdate(Object bean){		
		log.info("Start DataSourceDaoImpl.insert method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().saveOrUpdate(bean);
	        log.info("DataSourceDaoImpl.insert successful");	        
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.insert failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public void update(Object bean){
		log.info("Start DataSourceDaoImpl.update method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().update(bean);
	        log.info("DataSourceDaoImpl.update successful");	        
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.update failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public void delete(Object bean){
		log.info("Start DataSourceDaoImpl.delete method");
		try {						 				
			sessionFactoryAnagraficaBS.getCurrentSession().delete(bean);
	        log.info("DataSourceDaoImpl.delete successful");	        
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.delete failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@Override
	public int updateSql(String queryString, String[] parameters){
		log.info("Start DataSourceDaoImpl.updateSql method");
		
		int numRighe;
		
		try {
			Query query = sessionFactoryAnagraficaBS.getCurrentSession().createQuery(queryString);	
			
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i+1, parameters[i]);
			}
			numRighe = query.executeUpdate();
			log.info("DataSourceDaoImpl.updateSql successful");			
		}catch (RuntimeException re){
			log.error("DataSourceDaoImpl.updateSql failed", re);
			re.printStackTrace();
			throw re;
			}
		return numRighe;
	}
	
	@Override
	public Object findbyId(Class beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {		
		log.info("Start DataSourceDaoImpl.findbyId method");
		try {						
			Object tabellaCorrente =(Object) sessionFactoryAnagraficaBS.getCurrentSession().get(beanName, id);		
			
	        log.info("DataSourceDaoImpl.findbyId successful");
	        return tabellaCorrente;
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.findbyId failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
		
	@Override
	public Object findbyId(Object id) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {		
		log.info("Start DataSourceDaoImpl.findbyId method");
		try {						
			Object tabellaCorrente = (Object) Class.forName(id.getClass().getName().substring(0, id.getClass().getName().length()-2)).newInstance();		
			tabellaCorrente   = (Object) sessionFactoryAnagraficaBS.getCurrentSession().get(id.getClass().getName().substring(0, id.getClass().getName().length()-2),  (Serializable) id);			
	        log.info("DataSourceDaoImpl.findbyId successful");
	        return tabellaCorrente;
	        }catch (RuntimeException re) {
	        	log.error("DataSourceDaoImpl.findbyId failed", re);
	        	re.printStackTrace();
	        throw re;
	        }
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		log.info("Start DataSourceDaoImpl.findAll method");
		try {							
			List<Object> list = sessionFactoryAnagraficaBS.getCurrentSession().createQuery("from "+beanName).list();
			log.info("DataSourceDaoImpl.findAll successful");
			return list;
			}catch (RuntimeException re){
				log.error("DataSourceDaoImpl.findAll failed", re);
				re.printStackTrace();
				throw re;
				}
		}	
	
	@Override
	public List<Object> genericquery(String queryString){
		log.info("Start DataSourceDaoImpl.genericquery method");
		try {
			Query query = sessionFactoryAnagraficaBS.getCurrentSession().createQuery(queryString);				
			log.info("DataSourceDaoImpl.genericquery successful");
			return query.list();
		}catch (RuntimeException re){
			log.error("DataSourceDaoImpl.genericquery failed", re);
			re.printStackTrace();
			throw re;
			}
	}
	
	@Override
	public List<Object> genericqueryInfap(String queryString){
		log.info("Start DataSourceDaoImpl.genericqueryInfap method");
		try {
			Query query = sessionFactoryInfap.getCurrentSession().createQuery(queryString);				
			log.info("DataSourceDaoImpl.genericqueryInfap successful");
			return query.list();
		}catch (RuntimeException re){
			log.error("DataSourceDaoImpl.genericqueryInfap failed", re);
			re.printStackTrace();
			throw re;
			}
	}
	
	@Override
	public List<Object> genericqueryCommon(String queryString){
		log.info("Start DataSourceDaoImpl.genericqueryCommon method");
		try {
			Query query = sessionFactoryCommon.getCurrentSession().createQuery(queryString);				
			log.info("DataSourceDaoImpl.genericqueryCommon successful");
			return query.list();
		}catch (RuntimeException re){
			log.error("DataSourceDaoImpl.genericqueryCommon failed", re);
			re.printStackTrace();
			throw re;
			}
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByCriteria(Object oggettoDb, Hashtable params,String orderField) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		log.info("Start DataSourceDaoImpl.findByCriteria method");
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
			log.info("DataSourceDaoImpl.findByCriteria successful");
			return criteria.list();
			}catch (RuntimeException re){
				log.error("DataSourceDaoImpl.findByCriteria failed", re);
				re.printStackTrace();
				throw re;
				}
		}	

	
	@Override
	public List<Object> findByCriteriaDistinct(Object classe, String distinctList[],List<Restriction> restrictions){
		log.info("Start DataSourceDaoImpl.findByCriteriaDistinct method");
		
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
			log.info("DataSourceDaoImpl.findByCriteriaDistinct success");
			return 	resultList;	   
		}catch (RuntimeException re){
			log.error("DataSourceDaoImpl.findByCriteriaDistinct failed", re);
			re.printStackTrace();
			throw re;
			}
	}
}

