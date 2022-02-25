package com.sddevops.EcommerceClothesProject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class EditandDeleteProductJunitTest {
	
	private ProductDetailsServletJunit servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
	     servlet = new ProductDetailsServletJunit();
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	  @Test
	    public void testGetServlet() throws ServletException, IOException, SQLException {
	       
	       ProductDetailsServletJunit.listProducts(request,response);
	   

	    }


	  @Test
	    public void testUpdateServlet() throws ServletException, IOException {


	        request.addParameter("name", "testupdatename");
	        request.addParameter("image","testupdateimage");
	        request.addParameter("price", "29.99");
	        request.addParameter("category", "testupdatecategory");
	       
	        servlet.doPost(request, response);
	       

	    }
	  
	  @Test
	    public void testDeleteServlet() throws ServletException, IOException, SQLException {
	        request.addParameter("name");
	       ProductDetailsServletJunit.deleteProduct(request,response);

	    }
	  

}
