package com.ddway.anagraficaBS.dao;

import java.util.Hashtable;
import java.util.List;
import com.ddway.anagraficaBS.model.bean.Restriction;

public interface IDataSourceDao {
	
	public void insert(Object bean);
	public void delete(Object bean);
	public void insertOrUpdate(Object bean);
	public void update(Object beanName);
	public void updateSql(String queryString);
	public Object genericquery(String query);
	public Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Object findbyId(Object id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	public List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException;	
	public Object findByCriteria(Object oggettoDb,Hashtable params,String orderField) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	public List<Object> findByCriteriaDistinct(Object classe, String distinctList[],List<Restriction> restrictions);
}
