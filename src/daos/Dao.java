package daos;

import dbms.DatabaseManager;

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
	 * Checks the given uid and password against snumber and password of the Student table
	 * @param uid
	 * @param password
	 * @return True if the uid and password match a record. False if not
	 */
	public boolean loginStudent(long uid, String password) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT uid FROM Student WHERE snumber=? AND password=?");
			ps.setLong(0, uid);
			ps.setString(1, password);
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
	
	/**
	 * Checks the given uid and password against staffnumber and password of the Staff table
	 * @param uid
	 * @param password
	 * @return True if the uid and password match a record. False if not
	 */
	public boolean loginStaff(long uid, String password) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT staffnumber FROM Staff WHERE staffnumber=? AND password=?");
			ps.setLong(0, uid);
			ps.setString(1, password);
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
	
	/**
	 * Checks the given uid and password against approvalid and password of the Guest table
	 * @param uid
	 * @param password
	 * @return True if the uid and password match a record. False if not
	 */
	public boolean loginGuest(long uid, String password) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT approvalid FROM Guest WHERE approvalid=? AND password=?");
			ps.setLong(0, uid);
			ps.setString(1, password);
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
	
	public void newStudent(Map<String, String> attributes, int year, int phonenumber, int altphone, Long parkingnumber, boolean smoker) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Student (sex,comments,specialneeds,year,address,nationality,phonenumber,alternatephone,dob,parkingnumber,rentalstatus,smoker,name,password) VALUES(??????????????)");
			ps.setString(0, attributes.get("sex"));
			ps.setString(1, attributes.get("comments"));
			ps.setString(2, attributes.get("specialneeds"));
			ps.setInt(3, year);
			ps.setString(4, attributes.get("address"));
			ps.setString(5, attributes.get("nationality"));
			ps.setInt(6, phonenumber);
			ps.setInt(7, altphone);
			ps.setString(8, attributes.get("dob"));
			ps.setLong(9, parkingnumber);
			ps.setString(10, attributes.get("rentalstatus"));
			ps.setBoolean(11, smoker);
			ps.setString(12, attributes.get("name"));
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
	
	public void newGuest(Map<String, String> attributes, int year, int phonenumber, int altphone, Long parkingnumber, boolean smoker) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Guest (sex,comments,specialneeds,year,address,nationality,phonenumber,alternatephone,dob,parkingnumber,rentalstatus,smoker,name,password) VALUES(??????????????)");
			ps.setString(0, attributes.get("sex"));
			ps.setString(1, attributes.get("comments"));
			ps.setString(2, attributes.get("specialneeds"));
			ps.setInt(3, year);
			ps.setString(4, attributes.get("address"));
			ps.setString(5, attributes.get("nationality"));
			ps.setInt(6, phonenumber);
			ps.setInt(7, altphone);
			ps.setString(8, attributes.get("dob"));
			ps.setLong(9, parkingnumber);
			ps.setString(10, attributes.get("rentalstatus"));
			ps.setBoolean(11, smoker);
			ps.setString(12, attributes.get("name"));
			ps.setString(13, attributes.get("password"));
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
	
	public long newStaff(Map<String, String> attributes) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (location,staffname,address,dob,sex,position,department,password) VALUES(???????)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(0, attributes.get("location"));
			ps.setString(1, attributes.get("staffname"));
			ps.setString(2, attributes.get("address"));
			ps.setString(3, attributes.get("dob"));
			ps.setString(4, attributes.get("sex"));
			ps.setString(5, attributes.get("position"));
			ps.setString(6, attributes.get("department"));
			ps.setString(6, attributes.get("password"));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
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
	
	
	public ResultSet getAvailableResidence() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT placenumber,residencename FROM ResidenceHall WHERE NOT EXISTS (SELECT placenumber FROM rents) GOUP BY residencename");
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
	
	public ResultSet getAvailableApartment() {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT placenumber FROM StudentFlat WHERE NOT EXISTS (SELECT placenumber FROM rents)");
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
	 * Get a list of Invoices for this user
	 * @param uid The id of the user signed in
	 * @return
	 */
	public ResultSet viewInvoices(long uid) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Invoices WHERE snumber=?");
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
			PreparedStatement ps = conn.prepareStatement("SELECT placenumber FROM Lease WHERE snumber=?");
			ps.setLong(0, uid);
			ResultSet rs =  ps.executeQuery();
			long pnum = 0;
			if(rs != null && rs.next()) {
				pnum = rs.getLong("placenumber");
			}
			
			// Try looking in ResidenceHall for the placenumber
			ps = conn.prepareStatement("SELECT rate FROM ResidenceHall WHERE placenumber=?");
			ps.setLong(0, pnum);
			rs = ps.executeQuery();
			// If the result is empty
			if(rs == null || !rs.next()) {
				// It should be in the StudentFlat
				ps = conn.prepareStatement("SELECT rate FROM StudentFlat WHERE placenumber=?");
				ps.setLong(0, pnum);
				rs = ps.executeQuery();
				// Advance the ResultSet to the first column so that both paths of this if will have rs pointing to the first record
				if(rs != null) {
					rs.next();
				}
			}
			addLineItem(invoiceID, rs.getInt("rate"), "Monthly Rent");
			
			// Look in the Student table for the uid
			ps = conn.prepareStatement("SELECT parkingnumber FROM Student WHERE snumber=?");
			ps.setLong(0, uid);
			rs = ps.executeQuery();
			// If the result is empty
			if(rs == null || !rs.next()) {
				// Then look in the Guest table
				ps = conn.prepareStatement("SELECT parkingnumber FROM Guest WHERE snumber=?");
				ps.setLong(0, uid);
				rs = ps.executeQuery();
				// Advance the ResultSet to the first column so that both paths of this if will have rs pointing to the first record
				if(rs  != null) {
					rs.next();
				}
			}			
			ps = conn.prepareStatement("SELECT rate FROM ParkingSpots PS, ParkingClassification PC WHERE PC.classificationtype = PS.classification && PS.spotnumber=?");
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
			PreparedStatement ps = conn.prepareStatement("SELECT fee,itemtype FROM LineItems WHERE invoicenumber=?");
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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO LineItems fee,itemtype,invoicenumber VALUES(???)");
			ps.setInt(0, fee);
			ps.setString(1, itemtype);
			ps.setLong(2, invoicenumber);
			ps.executeUpdate();
			ps = conn.prepareStatement("UPDATE Invoices SET paymentdue=paymentdue+?");
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
	
	public void viewLeases(long invoicenumber) {
		
	}
	
	/**
	 * Gets a set of parking lot numbers that are nearby to a specified place of residence
	 * @param placenumber
	 * @return
	 */
	public List<Long> getNearbyLots(long placenumber) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT parkingnumber FROM Nearby WHERE pacenumber=?");
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
			PreparedStatement ps = conn.prepareStatement("SELECT lotsavailable FROM Parking WHERE parkingnumber=?", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(0, parkingnumber);
			ResultSet rs =  ps.executeQuery();
			rs.next();
			if(rs.getLong("parkingnumber") == 0) {
				return -1;
			}
			ps = conn.prepareStatement("INSERT INTO ParkingSpots (lotnumber,classification) VALUES(??)");
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
			PreparedStatement ps = conn.prepareStatement("SELECT parkingnumber FROM Parking WHERE lotsavailable>0");
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
}