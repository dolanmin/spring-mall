package com.binglin.springbootmall.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.binglin.springbootmall.dao.ProductDao;
import com.binglin.springbootmall.model.Product;
import com.binglin.springbootmall.rowmapper.ProductRowMapper;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;// 注入NamedParameterJdbcTemplate 這個 bean

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>(); // new 一個新的 map 出來
        map.put("productId", productId); // 將這個 sql 中的參數 productId 給傳進去

        /*
         * 使用 namedParameterJdbcTemplate的 query 方法去執行這個 SELECT 的 sql 語法
         * 去查詢這一筆商品的數據出來第一個參數就填 sql 的變數第二個參數是 map 的變數那 query 方法要傳三個參數進來
         * 最後一個參數就是轉換數據的 RowMapper，要再去寫一個 product 的 RowMapper
         * 出來那才可以將我們從資料庫中所查詢出來的商品數據去轉換成是 Java object
         */
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0); // 取得第一個 product 的值傳回去
        } else {
            return null; // productList是空的話回傳一個 null 回去
        }

    }

}
