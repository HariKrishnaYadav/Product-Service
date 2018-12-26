package com.hk.productservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hk.productservice.service.ApplicationService;
import com.hk.productservice.validation.ProductValidation;

@RestController
public class ProductServiceRestController {
	@Autowired
	ApplicationService applicationService;
	@Autowired
	ProductValidation productValidation;
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceRestController.class);
	
}
