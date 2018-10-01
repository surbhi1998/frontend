package com.PindPunjabi.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.PindPunjabi.Backend.dao.CategoryRepository;
import com.PindPunjabi.Backend.dao.ProductRepository;
import com.PindPunjabi.Backend.model.Category;
import com.PindPunjabi.Backend.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/product")
	public String productPage(Model model)
	{
		List<Product>AllProduct=productRepository.getAllProduct();
		List<Category> AllCategory= categoryRepository.getAllCategory();
		
		model.addAttribute("dat",new Product());
		model.addAttribute("productList",AllProduct);
		model.addAttribute("categoryList",AllCategory);
		
		return "Product";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	
		public String productAdd(@ModelAttribute("dat") Product product,HttpSession httpSession)
		{
			if(product.getProductId()==0)
				
			{

		    	if( productRepository.addProduct(product))
		    	{
		       MultipartFile file=product.getImage();
					
					ServletContext con=httpSession.getServletContext();
					String filelocation=con.getRealPath("/resources/images/");
					System.out.println(filelocation);
					String filename=filelocation+"\\"+product.getProductId()+".jpg";
					System.out.println(filename);
					
					try{
						byte b[]=file.getBytes();
						FileOutputStream fos=new FileOutputStream(filename);
						fos.write(b);
						fos.close();
				    	}
					catch(IOException ex){}
					catch(Exception e){}
						}	
			

		       if(productRepository.addProduct(product))
				{
					
				}
				
			}
			else
			{
					productRepository.updateProduct(product);
			}
				return "redirect:/Product";
		
		}

			@RequestMapping("/deleteProduct/{id}")
			public String productDelete(@PathVariable("id")int productId)
					{
						productRepository.deleteProduct(productId);
						return "redirect:/Product";
					}
				

							@RequestMapping("/editProduct/{id}")
							
							public String product(@PathVariable("id")int ProductId,Model model)
							{
								Product productData=productRepository.getProductId(ProductId);
								model.addAttribute("dat",productData);
								List<Product>allProduct=productRepository.getAllProduct();
								model.addAttribute("productList",allProduct);
								return "Product";
							}
							

}
