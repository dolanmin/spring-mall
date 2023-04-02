package com.binglin.springbootmall.service;

import com.binglin.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId); // 會根據 productId去查詢這個商品的數據出來

}
