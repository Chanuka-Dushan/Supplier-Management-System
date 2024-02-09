<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.techZoneSupplierManage.jdbc.*" %>

<!DOCTYPE html>
<html>

<head>
	<title>TechZone Supplier Manage System</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<% List<Supplier> theSuppliers=(List<Supplier>) request.getAttribute("Suppliers_List");
%>
<body>



	<div id="wrapper">
		<div id="header">
			<h2>Tech Zone</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
				<input type="button" value="Add Supplier"
				onclick="window.location.href='add_supplier.jsp';return false;"
				class="add_supplier"/>
			<table>
			
				<tr>
					<th>ID</th>
					<th>Supplier Name</th>
					<th>Product Category</th>
					<th>Joined Year</th>
					<th>Minimum Order Qty</th>
					<th>Maximum Order Qty</th>
					<th>Other Details</th>
					<th>Action</th>
				</tr>
				
	<c:forEach var="tempSupplier" items="${Suppliers_List}">
    <c:url var="templink" value="SupplierManageServelet">
        <c:param name="command" value="LOAD" />
        <c:param name="Sid" value="${tempSupplier.getSid()}" />
    </c:url>
   
    

    <tr>
        <td>${tempSupplier.getSid()}</td>
        <td>${tempSupplier.getSname()}</td>
        <td>${tempSupplier.getPcategory()}</td>
        <td>${tempSupplier.getJyear()}</td>
        <td>${tempSupplier.getMinorder()}</td>
        <td>${tempSupplier.getMaxOrder()}</td>
        <td>${tempSupplier.getDetails()}</td>
        <td><a href="${templink}">Update</a></td>
        <td><a href="SupplierManageServelet?command=DELETE&Sid=${tempSupplier.getSid()}">Delete</a></td>
    </tr>
</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








