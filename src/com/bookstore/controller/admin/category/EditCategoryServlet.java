package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;


@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));

		CategoryService categoryService = new CategoryService();
		Category category = categoryService.getCategory(categoryId);
		
		if(category!=null) {
			request.setAttribute("category", category);
			request.getRequestDispatcher("category_form.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Could not find category with ID "+categoryId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		
	}

}