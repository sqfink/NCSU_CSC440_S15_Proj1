package daos;

import dbms.DatabaseManager;
import dbms.beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Dao {	
	
	/**
	 * Checks the given uid and password against id and password of the users table
	 * @param uid
	 * @param password
	 * @return True if the uid and password match a record. False if not
	 */
	public boolean loginUser(LoginStudentBean lsb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT id FROM users WHERE id=? AND password=?");
			ps.setLong(0, lsb.id);
			ps.setString(1, lsb.password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void newUser(LoginStudentBean lsb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (id,password) VALUES(?,?)");
			ps.setLong(0, lsb.id);
			ps.setString(1, lsb.password);
			ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
	}
	
	public int newStudent(StudentBean sb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO student (firstname,lastname,leasenumber,parkingnumber,dob,phone,alternatephone,nationality,address,city,state,country,zip,year,specialneeds,comments,sex,smoker,guest) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(0, sb.firstname);
			ps.setString(1, sb.lastname);
			ps.setLong(2, sb.leasenumber);
			ps.setLong(3, sb.parkingnumber);
			ps.setString(4, sb.dob);
			ps.setString(5, sb.phone);
			ps.setString(6, sb.alternatephone);
			ps.setString(7, sb.nationality);
			ps.setString(8, sb.address);
			ps.setString(9, sb.city);
			ps.setString(10, sb.state);
			ps.setString(11, sb.country);
			ps.setString(12, sb.zip);
			String year = sb.year.toLowerCase();
			if(year.equals("freshman")) {
				ps.setInt(13, 0);
			} else if(year.equals("sophomore")) {
				ps.setInt(13, 1);
			} else if(year.equals("junior")) {
				ps.setInt(13, 2);
			} else if(year.equals("senior")) {
				ps.setInt(13, 3);
			} else if(year.equals("graduate")) {
				ps.setInt(13, 4);
			} else {
				ps.setInt(13,-1);
			}

			ps.setString(14, sb.specialneeds);
			ps.setString(15, sb.comments);
			ps.setString(16, sb.sex);
			ps.setString(17, sb.smoker);
			if(sb.guest) {
				ps.setInt(18, 1);
			} else {
				ps.setInt(18, 0);
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return -1;
		
	}

	/**
	 * Insert new record into staff with the given values
	 * @param attributes
	 * @return The staffnumber of the new record
	 */
	public int newStaff(StaffBean sb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO staff (firstname,lastname,department,position,dob,address,city,state,zip,country,sex) VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(0, sb.firstname);
			ps.setString(1, sb.lastname);
			ps.setString(2, sb.department);
			ps.setString(3, sb.position);
			ps.setString(4, sb.dob);
			ps.setString(5, sb.address);
			ps.setString(6, sb.city);
			ps.setString(7, sb.state);
			ps.setString(8, sb.zip);
			ps.setString(9, sb.country);
			ps.setString(10, sb.sex);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	/**
	 * Gets available Residence Hall rooms
	 * @return A results set containing hall name and room number records
	 */
	public List<AvailableHousingBean> getAvailableResidence() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT HD.name,HR.roomnum FROM hallrooms HR, housingdetails HD WHERE HR.housingDetailsLocation=HD.housingDetailsLocation AND HR.snumber=-1");
			ResultSet rs =  ps.executeQuery();
			ArrayList<AvailableHousingBean> ret = new ArrayList<AvailableHousingBean>();
			AvailableHousingBean ahb;
			if(rs != null) {
				while(rs.next()) {
					ahb = new AvailableHousingBean();
					ahb.name = rs.getString("name");
					ahb.roomnum = rs.getLong("roomnum");
				}
			}
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Gets available Residence Hall rooms
	 * @return A results set containing apartment name and room number records
	 */
	public List<AvailableHousingBean> getAvailableApartment() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT HD.name,AR.roomnum FROM appartments A, appartmentrooms AR, housingdetails HD WHERE A.aptnum=AR.aptnum AND AR.housingDetailsLocation=HD.housingDetailsLocation AND HR.snumber=-1");
			ResultSet rs =  ps.executeQuery();
			ArrayList<AvailableHousingBean> ret = new ArrayList<AvailableHousingBean>();
			AvailableHousingBean ahb;
			if(rs != null) {
				while(rs.next()) {
					ahb = new AvailableHousingBean();
					ahb.name = rs.getString("name");
					ahb.roomnum = rs.getLong("roomnum");
				}
			}
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Get a list of Invoices for this user
	 * @param uid The id of the user signed in
	 * @return
	 */
	public List<InvoiceBean> viewInvoices(long snumber) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM invoices WHERE snumber=?");
			ps.setLong(0, snumber);
	//		return ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public long generateInvoice(long uid) {
		return 0;
	}
	
	/**
	 * Creates a new invoice for a given user. The invoice will include the monthly rent and parking fee.
	 * @param uid
	 */
	public void generateMonthlyInvoice(long uid) {
		long invoiceID = generateInvoice(uid);
		Connection conn = DatabaseManager.getConnection();
		try {
			// Get the users placenumber from Lease
			PreparedStatement ps = conn.prepareStatement("SELECT placenumber FROM lease WHERE snumber=?");
			ps.setLong(0, uid);
			ResultSet rs =  ps.executeQuery();
			long pnum = 0;
			if(rs != null && rs.next()) {
				pnum = rs.getLong("placenumber");
			}
			
			// Try looking in ResidenceHall for the placenumber
			ps = conn.prepareStatement("SELECT rate FROM residencehall WHERE placenumber=?");
			ps.setLong(0, pnum);
			rs = ps.executeQuery();
			// If the result is empty
			if(rs == null || !rs.next()) {
				// It should be in the StudentFlat
				ps = conn.prepareStatement("SELECT rate FROM studentflat WHERE placenumber=?");
				ps.setLong(0, pnum);
				rs = ps.executeQuery();
				// Advance the ResultSet to the first column so that both paths of this if will have rs pointing to the first record
				if(rs != null) {
					rs.next();
				}
			}
			addLineItem(invoiceID, rs.getInt("rate"), "Monthly Rent");
			
			// Look in the Student table for the uid
			ps = conn.prepareStatement("SELECT parkingnumber FROM student WHERE snumber=?");
			ps.setLong(0, uid);
			rs = ps.executeQuery();
			// If the result is empty
			if(rs == null || !rs.next()) {
				// Then look in the Guest table
				ps = conn.prepareStatement("SELECT parkingnumber FROM guest WHERE snumber=?");
				ps.setLong(0, uid);
				rs = ps.executeQuery();
				// Advance the ResultSet to the first column so that both paths of this if will have rs pointing to the first record
				if(rs  != null) {
					rs.next();
				}
			}			
			ps = conn.prepareStatement("SELECT rate FROM parkingspots PS, parkingclassification PC WHERE PC.classificationtype = PS.classification && PS.spotnumber=?");
			ps.setLong(0, rs.getLong("parkingnumber"));
			rs = ps.executeQuery();
			if(rs != null && rs.next()) {
				addLineItem(invoiceID, rs.getInt("rate"), "Parking Fee");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Get the line items associated with an invoice
	 * @param invoicenumber
	 */
	public ResultSet getLineItems(long invoicenumber) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT fee,itemtype FROM lineitems WHERE invoicenumber=?");
			ps.setLong(0, invoicenumber);
			return ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Adds a new item to the LineItems table and updates the paymentdue attribute of the appropriate record in Invoices
	 * @param invoicenumber
	 * @param fee
	 * @param itemtype
	 */
	public void addLineItem(long invoicenumber, int fee, String itemtype) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO lineitems fee,itemtype,invoicenumber VALUES(?,?,?)");
			ps.setInt(0, fee);
			ps.setString(1, itemtype);
			ps.setLong(2, invoicenumber);
			ps.executeUpdate();
			ps = conn.prepareStatement("UPDATE invoices SET paymentdue=paymentdue+?");
			ps.setInt(0, fee);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * Get the set of Leases associated with the given user
	 * @param uid
	 * @return
	 */
	public ResultSet viewLeases(long uid) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT FROM lease WHERE snumber=?");
			ps.setLong(0, uid);
			return ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Gets a set of parking lot numbers that are nearby to a specified place of residence
	 * @param placenumber
	 * @return
	 */
	public List<Long> getNearbyLots(long placenumber) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT parkingnumber FROM nearby WHERE pacenumber=?");
			ps.setLong(0, placenumber);
			ResultSet rs =  ps.executeQuery();
			ArrayList<Long> ret = new ArrayList<Long>();
			while(rs.next()) {
				ret.add(rs.getLong("parkingnumber"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * Gets an available parking spot in a specified lot. -1 if there are no available lots
	 * @param parkingnumber
	 * @return The spotnumber of the newly alloted parking spot. Will be -1 if the lot is full.
	 */
	public long getAvailableSpot(long parkingnumber, String classification) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT lotsavailable FROM parking WHERE parkingnumber=?", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(0, parkingnumber);
			ResultSet rs =  ps.executeQuery();
			rs.next();
			if(rs.getLong("parkingnumber") == 0) {
				return -1;
			}
			ps = conn.prepareStatement("INSERT INTO ParkingSpots (lotnumber,classification) VALUES(?,?)");
			ps.setLong(0, parkingnumber);
			ps.setString(1, classification);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getLong(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	/**
	 * Gets a list of all lots that are not full.
	 * @return A list of all lots that are not full.
	 */
	public List<Long> getAvailableParking() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT parkingnumber FROM parking WHERE lotsavailable>0");
			ResultSet rs =  ps.executeQuery();
			ArrayList<Long> ret = new ArrayList<Long>();
			while(rs.next()) {
				ret.add(rs.getLong("parkingnumber"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void AddHousingDetail() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT parkingnumber FROM parking WHERE lotsavailable>0");
			ResultSet rs =  ps.executeQuery();
			ArrayList<Long> ret = new ArrayList<Long>();
			while(rs.next()) {
				ret.add(rs.getLong("parkingnumber"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				System.err.println("Error closing connections");
				e.printStackTrace();
			}
		}
	}
}
