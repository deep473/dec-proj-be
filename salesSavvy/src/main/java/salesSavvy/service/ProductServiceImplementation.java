package salesSavvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesSavvy.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{

	@Autowired
	ProductRepository repo;
}
