package salesSavvy.service;

import java.util.List;

import salesSavvy.entity.Product;

public interface ProductService {

	String addProduct(Product prod);
	List<Product> getAllProducts();
}
