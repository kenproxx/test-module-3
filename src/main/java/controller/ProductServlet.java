package controller;

import model.Product;
import service.ProductService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
   ProductService productService = new ProductService();
    private String message;
    List<Product> list;
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //action
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "findByName":
                findByName(request, response);
                break;
            case "findByPrice":
                findByPrice(request, response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }

    private void findByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int priceStart = Integer.parseInt(request.getParameter("priceStart"));
        int priceEnd = Integer.parseInt(request.getParameter("priceEnd"));
        list = productService.findByPrice(priceStart,priceEnd);
        request.setAttribute("list", list);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = productService.showAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");
        list = productService.findByName(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }




 public void destroy() {
    }
}