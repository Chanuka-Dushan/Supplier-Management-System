package com.techZoneSupplierManage.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/techzone_suppliers")
	private DataSource dataSourse;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set prinwriter
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/plain");
		
		//get connection
		
		Connection con=null;
		Statement mystmt=null;
		ResultSet myrs=null;
		
		try {
			//sql query
			con=dataSourse.getConnection();
			String sql="Select * from suppliers";
			mystmt= con.createStatement();
			
			//excecute query
			myrs=mystmt.executeQuery(sql);
			
			//get output
			while(myrs.next()) {
				String name=myrs.getString("Sname");
				out.println(name);			}
		}catch(Exception e) {
			e.printStackTrace();
		};
	}

}
