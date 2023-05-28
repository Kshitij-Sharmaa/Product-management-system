package com.cetpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.Model.Product;
import com.cetpa.Services.ProductService;

@Controller
public class ProductController
{
	@Autowired
	private ProductService productService;
	@RequestMapping("home")
	public String getHomeView()
	{
		return "home";
	}
	
	@RequestMapping("insert-record")
	public String getInsertView()
	{
		return "insert";
	}
	@RequestMapping("save-record")
	public String getSaveView(Product product)
	{
		productService.saveRecord(product);
		return "save";
	}
	@RequestMapping("search-record")
	public String getListView()
	{
		return "search";
	}
	
	@RequestMapping("show-record")
	public String getRecord(int pid,Model model)
	{
		Product product=productService.getRecord(pid);
		if (product==null) 
		{
			model.addAttribute("msg", "Product with id "+pid+" not found !!");
			return "search";
		}
		model.addAttribute("product", product);
		return "search-record";
	}
	
	@RequestMapping("delete-record")
	public String getDeleteView()
	{
		return "delete";
	}
	
	@RequestMapping("confirm-delete")
	public String ConfirmDelete(int pid,Model model)
	{
		Product product=productService.getRecord(pid);
		if (product==null) 
		{
			model.addAttribute("msg", "Product with id "+pid+" not Exist !!");
			return "delete";
		}
		model.addAttribute("product", product);
		return "confirm-delete";
	}
	
	@RequestMapping("delete-product-record")
	public String deleteRecord(Product product)
	{
		productService.DeleteRecord(product);
		return "deletemsg";
	}
	
	@RequestMapping("list")
	public String getList(Model model)
	{
		List<Product> plist=productService.getList();
		model.addAttribute("plist", plist);
		return "product-list";
	}
	
	@RequestMapping("edit-record")
	public String getUpdateView()
	{
		return "edit";
	}
	
	@RequestMapping("get-record")
	public String getUpdateRecord(int pid,Model model)
	{
		Product product=productService.getRecord(pid);
		if (product==null) 
		{
			model.addAttribute("msg", "Product with id "+pid+" not exist !!");
			return "edit";
		}
		model.addAttribute("product", product);
		return "show-record";
	}
	@RequestMapping("update-record")
	public String updateRecord(Product product,Model model)
	{
		productService.saveRecord(product);
		model.addAttribute("msg","Product with id "+product.getPid()+" has been updated");
		return "edit";
	}
}
