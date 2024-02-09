package com.techZoneSupplierManage.jdbc;

public class Supplier {
	
	private int Sid;
	private String Sname;
	private String Pcategory;
	private int Jyear;
	private int Minorder;
	private int MaxOrder;
	private String Details;
	
	public Supplier(String sname, String pcategory, int jyear, int minorder, int maxOrder, String details) {
		super();
		Sname = sname;
		Pcategory = pcategory;
		Jyear = jyear;
		Minorder = minorder;
		MaxOrder = maxOrder;
		Details = details;
	}

	public Supplier(int sid, String sname, String pcategory, int jyear, int minorder, int maxOrder, String details) {
		super();
		Sid = sid;
		Sname = sname;
		Pcategory = pcategory;
		Jyear = jyear;
		Minorder = minorder;
		MaxOrder = maxOrder;
		Details = details;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	 public String getPcategory() {
	        return Pcategory;
	    }

	    public void setPcategory(String pcategory) {
	        Pcategory = pcategory;
	    }

	    public int getJyear() {
	        return Jyear;
	    }

	    public void setJyear(int jyear) {
	        Jyear = jyear;
	    }

	public int getMinorder() {
		return Minorder;
	}

	public void setMinorder(int minorder) {
		Minorder = minorder;
	}

	public int getMaxOrder() {
		return MaxOrder;
	}

	public void setMaxOrder(int maxOrder) {
		MaxOrder = maxOrder;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	@Override
	public String toString() {
		return "Supplier [Sid=" + Sid + ", Sname=" + Sname + ", Pcategory=" + Pcategory + ", Jyear=" + Jyear
				+ ", Minorder=" + Minorder + ", MaxOrder=" + MaxOrder + ", Details=" + Details + "]";
	}
	
}
