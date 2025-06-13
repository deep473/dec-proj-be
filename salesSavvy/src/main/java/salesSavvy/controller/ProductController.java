package salesSavvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import salesSavvy.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
}
