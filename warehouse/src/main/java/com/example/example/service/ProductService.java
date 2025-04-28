package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Product;
import com.example.example.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

	public Object getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Object findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Product findById(Long productId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}

