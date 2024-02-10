package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.BookService;

@WebServlet("/admin/new_book")
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService bookService = new BookService();
		List<Category> categoryList = bookService.getCategory();
		
		request.getSession().setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
	}

}
