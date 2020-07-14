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

/**
 * Servlet implementation class EditDepartment
 */
@WebServlet("/editdepartment")
public class EditDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptId= Integer.parseInt(request.getParameter("depId"));
		HttpSession cvb=request.getSession();
		DeptEmpService edf = new DeptEmpServImpl();
		List<Department> ldpl = edf.readAllDeptServ();
		Department dt =edf.showDeptServ(deptId);
		
		//request.setAttribute("deptvalid", "editdept");
		request.setAttribute("deptva",dt);
		request.setAttribute("hoser", "hseval");
		request.setAttribute("deptlv", ldpl);
		cvb.setAttribute("sdt", deptId);
		RequestDispatcher rf = request.getRequestDispatcher("home3.jsp");
		rf.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
