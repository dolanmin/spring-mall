package com.binglin.springbootmall.dao;

import com.binglin.springbootmall.dto.ProductRequest;
import com.binglin.springbootmall.model.Product;

public interface ProductDao {

    /*
     * 這個方法的返回類型是 Proudct 類型的
     * 這個方法的名稱叫做getProductById參數是傳一個Integer類型的productId進來
     */
    Product getProductById(Integer productId); // 會根據 productId去查詢這個商品的數據出來

    Integer createProduct(ProductRequest productRequest);

    void updatedProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
