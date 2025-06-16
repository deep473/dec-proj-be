package salesSavvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesSavvy.entity.Product;
import salesSavvy.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{

	@Autowired
	ProductRepository repo;

	@Override
	public String addProduct(Product prod) {
		repo.save(prod);
		return "success";
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
}
