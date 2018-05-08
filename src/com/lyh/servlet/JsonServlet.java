package com.lyh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lyh.model.Animal;
import com.lyh.model.Book;
import com.lyh.model.User;

public class JsonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public JsonServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String a = request.getParameter("name");
		Enumeration<String> c = request.getAttributeNames();
		Enumeration<String> b = request.getParameterNames();
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		Animal animalDog2 = new Animal();
		animalDog2.setAnimalName("豆豆3");
		
		Animal animalDog1 = new Animal();
		animalDog1.setAnimalName("豆豆1");
		user.getAnimals().add(animalDog1);
		user.getAnimals().add(animalDog2);
		
		Book book = new Book();
		user.getBooks().add(book);
		JSONObject jo = new JSONObject();
		jo.put("user", user);
		out = response.getWriter();
		out.println(jo);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object a = request.getParameter("name");
		Object b = request.getParameter("address");
		Object c = request.getParameter("bookname");
		/*Enumeration<String> c = request.getAttributeNames();
		Enumeration<String> b = request.getParameterNames();*/
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		Animal animalDog2 = new Animal();
		animalDog2.setAnimalName("豆豆3");
		
		Animal animalDog1 = new Animal();
		animalDog1.setAnimalName("豆豆1");
		user.getAnimals().add(animalDog1);
		user.getAnimals().add(animalDog2);
		
		Book book = new Book();
		user.getBooks().add(book);
		JSONObject jo = new JSONObject();
		jo.put("user", user);
		out = response.getWriter();
		out.println(jo);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
