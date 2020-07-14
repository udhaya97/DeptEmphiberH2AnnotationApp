package com.deptemphiberannoh2dbapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deptemphiberannoh2dbapp.dao.DeptEmpDao;
import com.deptemphiberannoh2dbapp.dao.DeptEmpDaoImpl;
import com.deptemphiberannoh2dbapp.model.Department;
import com.deptemphiberannoh2dbapp.service.DeptEmpServImpl;
import com.deptemphiberannoh2dbapp.service.DeptEmpService;

@WebServlet("/regDept")
public class RegDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sed = request.getSession();
		DeptEmpService dedu = new DeptEmpServImpl();
		List<Department> ldepty = dedu.readAllDeptServ();
		request.setAttribute("adddept", "regdept");
		request.setAttribute("deptlv", ldepty);
		request.setAttribute("hoser", "hseval");
		RequestDispatcher rdf = request.getRequestDispatcher("home3.jsp");
		rdf.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
