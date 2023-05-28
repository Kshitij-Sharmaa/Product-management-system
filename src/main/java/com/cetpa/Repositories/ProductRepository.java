package com.cetpa.Repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cetpa.Model.Product;

@Repository
public class ProductRepository {

	private Map<Integer,Product> map=new HashMap<>();
	public void save(Product product) 
	{
		map.put(product.getPid(), product);
	}
	public Product getRecord(int pid) 
	{
		return map.get(pid);
	}
	public void deleteRecord(Product product) 
	{
		map.remove(product.getPid());
	}
	public Map<Integer, Product>getMap()
	{
		return map;
	}

}
