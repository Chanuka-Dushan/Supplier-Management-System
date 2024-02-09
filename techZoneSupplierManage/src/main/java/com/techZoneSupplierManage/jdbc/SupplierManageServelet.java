package com.techZoneSupplierManage.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SupplierManageServelet
 */
@WebServlet("/SupplierManageServelet")
public class SupplierManageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SupplierDBUtil supplierDBUtil;
	
	@Resource(name="jdbc/techzone_suppliers")
	private DataSource dataSourse;
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		try {
			supplierDBUtil = new SupplierDBUtil(dataSourse);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}



	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            String theCommand = request.getParameter("command");

	            if (theCommand == null) {
	                theCommand = "LIST";
	            }

	            switch (theCommand) {
	                case "LIST":
	                    listSuppliers(request, response);
	                    break;
	                case "ADD":
	                    addSupplier(request, response);
	                    break;
	                case "LOAD":
	                    loadSupplier(request, response);
	                    break;
	                case "UPDATE":
	                    updateSupplier(request, response);
	                    break;
	                case "DELETE":
	                    deleteSupplier(request, response);
	                    break;
	                default:
	                    listSuppliers(request, response);
	            }
	        } catch (Exception exc) {
	            throw new ServletException(exc);
	        }
	    }



	 private void loadSupplier(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    String theSupplierId = request.getParameter("Sid");

		    if (theSupplierId != null && !theSupplierId.isEmpty()) {
		        try {
		            int supplierId = Integer.parseInt(theSupplierId);

		            // Convert the supplierId to a String
		            String supplierIdStr = Integer.toString(supplierId);

		            Supplier theSupplier = supplierDBUtil.getSupplier(supplierIdStr);

		            if (theSupplier != null) {
		                request.setAttribute("The_Supplier", theSupplier);
		                RequestDispatcher dispatcher = request.getRequestDispatcher("/update_supplier.jsp");
		                dispatcher.forward(request, response);
		            } else {
		                response.getWriter().println("Supplier not found.");
		            }
		        } catch (NumberFormatException e) {
		            // Handle the case when the "Sid" parameter is not a valid integer
		            response.getWriter().println("Invalid Supplier ID.");
		        }
		    } else {
		        // Handle the case when "Sid" parameter is missing
		        response.getWriter().println("Supplier ID is missing.");
		    }
		}


	 private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    // Retrieve the updated data from the form
		    int Sid = Integer.parseInt(request.getParameter("Sid"));
		    String Sname = request.getParameter("Sname");
		    String Pcategory = request.getParameter("Pcategory");
		    int Jyear = Integer.parseInt(request.getParameter("Jyear"));
		    int Minorder = Integer.parseInt(request.getParameter("Minorder"));
		    int MaxOrder = Integer.parseInt(request.getParameter("MaxOrder"));
		    String Details = request.getParameter("Details");

		    // Create a Supplier object with the updated data
		    Supplier updatedSupplier = new Supplier(Sid, Sname, Pcategory, Jyear, Minorder, MaxOrder, Details);

		    // Update the supplier in the database
		    supplierDBUtil.updateSupplier(updatedSupplier);

		    // Redirect to the list of suppliers after updating
		    listSuppliers(request, response);
		}

	 private void addSupplier(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String Sname = request.getParameter("Sname");
	        String Pcategory = request.getParameter("Pcategory");
	        int Jyear = Integer.parseInt(request.getParameter("Jyear"));
	        int Minorder = Integer.parseInt(request.getParameter("Minorder"));
	        int MaxOrder = Integer.parseInt(request.getParameter("MaxOrder"));
	        String Details = request.getParameter("Details");

	        Supplier theSupplier = new Supplier(Sname, Pcategory, Jyear, Minorder, MaxOrder, Details);

	        supplierDBUtil.addSupplier(theSupplier);

	        listSuppliers(request, response);
	    }

	 private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int Sid = Integer.parseInt(request.getParameter("Sid"));
	        supplierDBUtil.deleteSupplier(Sid);
	        listSuppliers(request, response);
	    }




	private void listSuppliers(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		//get studentfrom db
		List<Supplier> suppliers=supplierDBUtil.getSuppliers();
		//add student request
		request.setAttribute("Suppliers_List", suppliers);
		//send to jso page
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list_supplier.jsp");
		dispatcher.forward(request, response);
		
	}

}