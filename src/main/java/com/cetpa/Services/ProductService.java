package com.cetpa.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.Model.Product;
import com.cetpa.Repositories.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	public void saveRecord(Product product) 
	{
		productRepository.save(product);
	}
	public Product getRecord(int pid) 
	{
		return productRepository.getRecord(pid);
	}
	public void DeleteRecord(Product product) 
	{
		productRepository.deleteRecord(product);
		
	}
	public List<Product> getList() {
		Map<Integer,Product> map=productRepository.getMap();
		Collection<Product> c=map.values();
		List<Product> list=new ArrayList<>(c);
		return list;
	}

}
