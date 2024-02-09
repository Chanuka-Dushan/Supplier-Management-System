<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.techZoneSupplierManage.jdbc.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Supplier</title>
</head>
<link type="text/css" rel="stylesheet" href="css/styles.css">
<link type="text/css" rel="stylesheet" href="css/add_supplier.css">
<body>
    <div class="container">
        <h2>Update Supplier</h2>
        <form action="SupplierManageServelet" method="GET">
            <input type="hidden" name="command" value="UPDATE"/>
            <input type="hidden" name="Sid" value="${The_Supplier.sid}"/>
            <div class="form-group">
                <label for="Sname">Supplier Name:</label>
                <input type="text" id="Sname" name="Sname" value="${The_Supplier.sname}" required>
            </div>
            <div class="form-group">
                <label for="Pcategory">Product Category:</label>
                <input type="text" id="Pcategory" name="Pcategory" value="${The_Supplier.pcategory}" required>
            </div>
            <div class="form-group">
                <label for="Jyear">Joined Year:</label>
                <input type="text" id="Jyear" name="Jyear" value="${The_Supplier.jyear}" required>
            </div>
            <div class="form-group">
                <label for="Minorder">Minimum Order Quantity:</label>
                <input type="number" id="Minorder" name="Minorder" value="${The_Supplier.minorder}" required>
            </div>
            <div class="form-group">
                <label for="MaxOrder">Maximum Order Quantity:</label>
                <input type="number" id="MaxOrder" name="MaxOrder" value="${The_Supplier.maxOrder}" required>
            </div>
            <div class="form-group">
                <label for="Details">Other Details:</label>
                <textarea id="Details" name="Details" rows="5" required>${The_Supplier.details}</textarea>
            </div>
            <button type="submit">Update</button>
        </form>
    </div>
    <div style="clear:both;"></div>
    <p>
        <a href="SupplierManageServelet?command=LIST">Back to List of Suppliers</a>
    </p>
</body>
</html>
