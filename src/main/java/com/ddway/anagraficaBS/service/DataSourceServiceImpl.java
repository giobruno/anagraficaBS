package com.ddway.anagraficaBS.service;

import java.util.Hashtable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ddway.anagraficaBS.dao.IDataSourceDao;
import com.ddway.anagraficaBS.model.bean.Restriction;

@Service
public class DataSourceServiceImpl implements IDataSourceService {

	@Autowired
    private IDataSourceDao iDataSourceDao;

	@Transactional
	public void insert(Object bean){	
		iDataSourceDao.insert(bean);
	}
	
	@Transactional
	public void insertOrUpdate(Object bean){	
		iDataSourceDao.insertOrUpdate(bean);
	}
	
	@Transactional
	public void update(Object bean){
		iDataSourceDao.update(bean);
	}
	
	@Transactional
	public void delete(Object bean){
		iDataSourceDao.delete(bean);
	}
	
	@Transactional
	public int updateSql(String queryString, String[] parameters){
		return iDataSourceDao.updateSql(queryString,parameters);
	}
	
	@Transactional
	public Object findbyId(String bean,int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{	
		return iDataSourceDao.findbyId(bean,id);
	}
	
	@Transactional
	public Object findbyId(Object id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{	
		return iDataSourceDao.findbyId(id);
	}
	
	@Transactional
	public List<Object> findAll(String bean) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return iDataSourceDao.findAll(bean);
	}
	
	@Transactional
	public Object genericquery(String query){
		return iDataSourceDao.genericquery(query);
	}	
	
	@Transactional
	public List<Object> findByCriteriaDistinct(Object classe, String distinctList[], List<Restriction> restrictions){
		return iDataSourceDao.findByCriteriaDistinct(classe,distinctList, restrictions);
	}
	
	@Transactional
	public Object findByCriteria(Object oggettoDb,Hashtable params,String orderField) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return iDataSourceDao.findByCriteria(oggettoDb,params,orderField);
	}
}
