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
import com.deptemphiberannoh2dbapp.model.Employee;
import com.deptemphiberannoh2dbapp.service.DeptEmpServImpl;
import com.deptemphiberannoh2dbapp.service.DeptEmpService;

@WebServlet("/saveemployee")
public class SaveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	DeptEmpDao edo = new DeptEmpDaoImpl();
		Employee eml = new Employee();
		
		//int empId = request.getParameter("empId");
		String name = request.getParameter("empName");
		String mailId = request.getParameter("mailId");
		String dob = request.getParameter("dob");
		long mob = Long.parseLong(request.getParameter("mobileNo"));
		float sal = Float.parseFloat(request.getParameter("salary"));
		String comName = request.getParameter("companyName");
		String deptempName =request.getParameter("deptEmpNa");
List<Department> lsv = edo.readAllDept();
		
		int studeptid = 0;
		for (Department department : lsv) {
			if(department.getDeptName().equals(deptempName))
			{
				studeptid= department.getDeptId();
			}
		}
		
		System.out.println("dept id"+studeptid);
		DeptEmpService ded = new DeptEmpServImpl();
		Department dep = new Department();
		dep.setDeptId(studeptid);
		//eml.setEmpId(0);
		eml.setEmpName(name);
		eml.setMailId(mailId);
		eml.setDateOfBirth(dob);
		eml.setDepartment(dep);
		eml.setCompanyName(comName);
		eml.setMobileNo(mob);
		eml.setSalary(sal);
		System.out.println("values from save employee"+name);
		ded.createEmpServ(eml);
		HttpSession sem = request.getSession();
		sem.setAttribute("submitDoneEmp","done");
		response.sendRedirect("listEmp?deptId="+studeptid);
		
	}

}
