package com.hk.productservice.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hk.productservice.model.Product;

@Repository
public class ProductServiceDAOImpl implements ProductServiceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String PRODUCT_INSERT_SQL = "insert into products (name,sku,price,qty,createddate,createdby,lastupdateddate,lastupdatedby) values (?,?,?,?,?,?,?,?)";
	private static final String PRODUCT_SQL_QUERY = "select id, name, sku, price, qty, createddate, createdby, lastupdateddate, lastupdatedby from products";
	private static final String PRODUCT_DELETE_QUERY = "delete from products where id=?";
	private static final String PRODUCT_UPDATE_QUERY = "update products set name=?, sku=?, price=?, qty=?, lastupdateddate=?,lastupdatedby=? where id=?";
	private static final String SKU_EXISTS_SQL_QUERY = "select count(sku) from products where sku=?";
	private static final String PRODUCT_ID_EXISTS_SQL_QUERY = "select count(id) from products where id=?";
	private static final String SELECT_PRODUCT_BY_ID_SQL = PRODUCT_SQL_QUERY + " where id=?";
	private static final String INITIAL_RECORD = "intial-record";
	private static final String CREATED_BY = "createdby";
	private static final String CREATED_DATE = "createddate";
	private static final String LAST_UPDATED_BY = "lastupdatedby";
	private static final String LAST_UPDATED_DATE = "lastupdateddate";
	private static final String PRODUCT_ID = "id";
	private static final String PRODUCT_NAME = "name";
	private static final String PRODUCT_QTY = "qty";
	private static final String PRODUCT_SKU = "sku";
	private static final String PRODUCT_PRICE = "price";

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceDAOImpl.class);

	@Override
	public void createProduct(Product product) {

		logger.info("create product sql:" + PRODUCT_INSERT_SQL);
		jdbcTemplate.update(PRODUCT_INSERT_SQL,
				new Object[] { product.getName(), product.getSku(), product.getPrice(), product.getQty(),
						(System.currentTimeMillis() / 1000), INITIAL_RECORD, (System.currentTimeMillis() / 1000),
						INITIAL_RECORD });

	}

	@Override
	public List<Product> getProducts() {

		logger.info("get product sql:"+PRODUCT_SQL_QUERY);

		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(PRODUCT_SQL_QUERY);

		return null;
	}

	@Override
	public void deleteProduct(String id) {

	}

	@Override
	public void updateProduct(Product product, String id) {

	}

	@Override
	public boolean isSkuExists(String sku) {

		return false;
	}

	@Override
	public boolean isProductExists(String id) {

		return false;
	}

	@Override
	public Product getProductById(String id) {

		return null;
	}

}
