package com.techZoneSupplierManage.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SupplierDBUtil {
	
	@Resource(name = "jdbc/techzone_suppliers")
	private DataSource dataSource;

    public SupplierDBUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }
	
	public List<Supplier> getSuppliers() throws Exception{
		
		List<Supplier> suppliers = new ArrayList<>();
		
		Connection con=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try{
			//get connection
			con=dataSource.getConnection();
		
		//create sql statement
			String sql="select * from suppliers order by Sid";
			
			myStmt=con.createStatement();		
			//excecute
			myRs=myStmt.executeQuery(sql);
			
		//process result
			while(myRs.next()) {
				int Sid=myRs.getInt("Sid");
				String Sname=myRs.getString("Sname");
				String Pcategory=myRs.getString("Pcategory");
				int Jyear=myRs.getInt("Jyear");
				int Minorder=myRs.getInt("Minorder");
				int MaxOrder=myRs.getInt("MaxOrder");
				String Details=myRs.getString("Details");
				
				
				Supplier tempSupplier =new Supplier(Sid,Sname,Pcategory,Jyear,Minorder,MaxOrder,Details);
				
				suppliers.add(tempSupplier);
				
				
			}
			
			
		//close jdbc object
			return suppliers;
		}
		finally {
			close(con,myStmt,myRs);
			
		}
		 
	}

	private static void close(Connection con, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs !=null) {
				myRs.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(con!=null) {
				con.close();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addSupplier(Supplier theSupplier) throws Exception {
        Connection myCon = null;
        PreparedStatement myStmt = null;

        try {
            myCon = dataSource.getConnection();
            String sql = "INSERT INTO suppliers (Sname, Pcategory, Jyear, Minorder, MaxOrder, Details) VALUES (?, ?, ?, ?, ?, ?)";
            myStmt = myCon.prepareStatement(sql);

            myStmt.setString(1, theSupplier.getSname());
            myStmt.setString(2, theSupplier.getPcategory());
            myStmt.setInt(3, theSupplier.getJyear());
            myStmt.setInt(4, theSupplier.getMinorder());
            myStmt.setInt(5, theSupplier.getMaxOrder());
            myStmt.setString(6, theSupplier.getDetails());

            myStmt.execute();
        } finally {
            close(myCon, myStmt, null);
        }
    }

	public void updateSupplier(Supplier theSupplier) throws Exception {
	    Connection myCon = null;
	    PreparedStatement myStmt = null;

	    try {
	        myCon = dataSource.getConnection();
	        // Set auto-commit to false to manage transactions manually
	        myCon.setAutoCommit(false);

	        String sql = "UPDATE suppliers SET Sname=?, Pcategory=?, Jyear=?, Minorder=?, MaxOrder=?, Details=? WHERE Sid=?";
	        myStmt = myCon.prepareStatement(sql);

	        myStmt.setString(1, theSupplier.getSname());
	        myStmt.setString(2, theSupplier.getPcategory());
	        myStmt.setInt(3, theSupplier.getJyear());
	        myStmt.setInt(4, theSupplier.getMinorder());
	        myStmt.setInt(5, theSupplier.getMaxOrder());
	        myStmt.setString(6, theSupplier.getDetails());
	        myStmt.setInt(7, theSupplier.getSid());

	        myStmt.execute();

	        // Commit the transaction
	        myCon.commit();
	    } catch (Exception e) {
	        // Handle exceptions
	        myCon.rollback(); // Roll back the transaction if there's an exception
	        throw e;
	    } finally {
	        close(myCon, myStmt, null);
	    }
	}

	public void deleteSupplier(int Sid) throws Exception {
	    Connection myCon = null;
	    PreparedStatement myStmt = null;

	    try {
	        myCon = dataSource.getConnection();
	        // Set auto-commit to false to manage transactions manually
	        myCon.setAutoCommit(false);

	        String sql = "DELETE FROM suppliers WHERE Sid=?";
	        myStmt = myCon.prepareStatement(sql);

	        myStmt.setInt(1, Sid);

	        myStmt.execute();
	        myCon.commit();

	    } catch (Exception e) {
	        // Handle exceptions
	        myCon.rollback(); // Roll back the transaction if there's an exception
	        throw e;
	    } finally {
	        close(myCon, myStmt, null);
	    }
	}
    public Supplier getSupplier(String supplierId) throws Exception {
        Supplier theSupplier = null;
        Connection myCon = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            int supplierId1 = Integer.parseInt(supplierId); // Corrected variable declaration
            myCon = dataSource.getConnection();
            String sql = "select * from suppliers where Sid=?";
            myStmt = myCon.prepareStatement(sql);
            myStmt.setInt(1, supplierId1); // Updated parameter type
            myRs = myStmt.executeQuery();
            if (myRs.next()) {
                String Sname = myRs.getString("Sname");
                String Pcategory = myRs.getString("Pcategory");
                int Jyear = myRs.getInt("Jyear");
                int Minorder = myRs.getInt("Minorder");
                int MaxOrder = myRs.getInt("MaxOrder");
                String Details = myRs.getString("Details");

                theSupplier = new Supplier(supplierId1, Sname, Pcategory, Jyear, Minorder, MaxOrder, Details);
            } else {
                throw new Exception("Could not find Supplier id: " + supplierId1);
            }

            return theSupplier;
        } finally {
            close(myCon, myStmt, myRs);
        }
    }
}

