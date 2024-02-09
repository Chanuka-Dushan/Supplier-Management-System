<!DOCTYPE html>
<html>
<head>Add Suppliers</head>
<link type="text/css" rel="stylesheet" href="css/styles.css">
<link type="text/css"  rel="stylesheet" href="css/add_supplier.css">

<body>
    <div class="container">
        <h2>Add a New Supplier</h2>
        <form action="SupplierManageServelet" method="GET">
        <input type="hidden" name="command" value="ADD"/>
            <div class="form-group">
                <label for="Sname">Supplier Name:</label>
                <input type="text" id="Sname" name="Sname" required>
            </div>
            <div class="form-group">
                <label for="Pcategory">Product Category:</label>
                <input type="text" id="Pcategory" name="Pcategory" required>
            </div>
            <div class="form-group">
                <label for="Jyear">Joined Year:</label>
                <input type="text" id="Jyear" name="Jyear" required>
            </div>
            <div class="form-group">
                <label for="Minorder">Minimum Order Quantity:</label>
                <input type="number" id="Minorder" name="Minorder" required>
            </div>
            <div class="form-group">
                <label for="MaxOrder">Maximum Order Quantity:</label>
                <input type="number" id="MaxOrder" name="MaxOrder" required>
            </div>
            <div class="form-group">
                <label for="Details">Other Details:</label>
                <textarea id="Details" name="Details" rows="5"></textarea>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
    <div style="clear:both;"></div>
    <p>
    <a href="SupplierManageServelet">Back to List of Suppliers</a>
    </p>
</body>

</html>