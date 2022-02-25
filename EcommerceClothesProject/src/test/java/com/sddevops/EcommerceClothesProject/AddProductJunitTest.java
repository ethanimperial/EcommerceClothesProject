package com.sddevops.EcommerceClothesProject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class AddProductJunitTest {
	
	private ProductServletJunit servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
	     servlet = new ProductServletJunit();
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	  @Test
	    public void testAddServlet() throws ServletException, IOException {


	        request.addParameter("name", "testname");
	        request.addParameter("image","testimage");
	        request.addParameter("price", "49.99");
	        request.addParameter("category", "testcategory");
	       
	        servlet.doPost(request, response);
	        assertEquals("text/html", response.getContentType());

	    }

}



