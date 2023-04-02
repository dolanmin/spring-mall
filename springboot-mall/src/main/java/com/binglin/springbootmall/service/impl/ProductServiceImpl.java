package com.binglin.springbootmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binglin.springbootmall.dao.ProductDao;
import com.binglin.springbootmall.model.Product;
import com.binglin.springbootmall.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

}
