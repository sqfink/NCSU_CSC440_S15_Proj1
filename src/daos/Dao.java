package daos;

import dbms.DatabaseManager;
import dbms.beans.*;
import dbms.beans.tmpstore.StaffLeaseTerminationStorBean;

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
			ps.setLong(1, lsb.id);
			ps.setString(2, lsb.password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void newUser(LoginStudentBean lsb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (id,password) VALUES(?,?)");
			ps.setLong(1, lsb.id);
			ps.setString(2, lsb.password);
			ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int newStudent(StudentBean sb) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO student (firstname,lastname,dob,phone,alternatephone,nationality,address,city,state,country,zip,year,specialneeds,comments,sex,smoker,guest) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, sb.firstname);
			ps.setString(2, sb.lastname);
			ps.setString(3, sb.dob);
			ps.setString(4, sb.phone);
			ps.setString(5, sb.alternatephone);
			ps.setString(6, sb.nationality);
			ps.setString(7, sb.address);
			ps.setString(8, sb.city);
			ps.setString(9, sb.state);
			ps.setString(10, sb.country);
			ps.setString(11, sb.zip);
			String year = sb.year.toString();
			if(year.equals("freshman")) {
				ps.setInt(12, 0);
			} else if(year.equals("sophomore")) {
				ps.setInt(12, 1);
			} else if(year.equals("junior")) {
				ps.setInt(12, 2);
			} else if(year.equals("senior")) {
				ps.setInt(12, 3);
			} else if(year.equals("graduate")) {
				ps.setInt(12, 4);
			} else {
				ps.setInt(12,-1);
			}

			ps.setString(13, sb.specialneeds);
			ps.setString(14, sb.comments);
			ps.setString(15, sb.sex);
			ps.setString(16, sb.smoker);
			if(sb.guest) {
				ps.setInt(17, 1);
			} else {
				ps.setInt(17, 0);
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
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
						
			ps.setString(1, sb.firstname);
			ps.setString(2, sb.lastname);
			ps.setString(3, sb.department);
			ps.setString(4, sb.position);
			ps.setString(5, sb.dob);
			ps.setString(6, sb.address);
			ps.setString(7, sb.city);
			ps.setString(8, sb.state);
			ps.setString(9, sb.zip);
			ps.setString(10, sb.country);
			ps.setString(11, sb.sex);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
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
					ret.add(ahb);
				}
			}
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
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
					ret.add(ahb);
				}
			}
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
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
			ResultSet rs =  ps.executeQuery();
			ArrayList<InvoiceBean> ret = new ArrayList<InvoiceBean>();
			InvoiceBean ib;
			if(rs != null) {
				while(rs.next()) {
					ib = new InvoiceBean();
					ib.leasenumber = rs.getLong("leasenumber");
					ib.duedate = rs.getString("duedate");
					ib.paiddate = rs.getString("paiddate");
					ib.paymentdue = rs.getLong("paymentdue");
					ib.paymenttype = rs.getString("paymenttype");
					ret.add(ib);
				}
			}
			return ret;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addInvoice(InvoiceBean ib) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO invoices (snumber,staffnumber,leasenumber,duedate,paiddate,paymentdue,paymenttype) Values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, ib.snumber);
			ps.setString(2, ib.staffnumber);
			ps.setLong(6, ib.leasenumber);
			ps.setString(7, ib.duedate);
			ps.setString(8, ib.paiddate);
			ps.setLong(9, ib.paymentdue);
			ps.setString(10, ib.paymenttype);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a list of current invoices
	 * @param invoicenumber
	 * @return
	 * @throws SQLException
	 */
	public List<InvoiceBean> viewCurrentInvoicesBySnumber(Long snumber) throws SQLException {
		String query = "SELECT * FROM invoices WHERE paiddate='null' AND snumber=" + snumber + ";";
		List<InvoiceBean> ib = DatabaseManager.executeBeanQuery(query, InvoiceBean.class);
		return ib;
	}
	
	/**
	 * Gets a list of former invoices
	 * @param invoicenumber
	 * @return
	 * @throws SQLException
	 */
	public List<InvoiceBean> viewFormerInvoicesBySnumber(Long snumber) throws SQLException {
		String query = "SELECT * FROM invoices WHERE NOT paiddate='null' AND snumber=" + snumber + ";";
		List<InvoiceBean> ib = DatabaseManager.executeBeanQuery(query, InvoiceBean.class);
		return ib;
	}
	
	
	public List<InvoiceBean> getInvoice(Long invoicenumber) throws SQLException {
		String query = "SELECT * FROM invoices WHERE invoicenumber=" + invoicenumber + ";";
		List<InvoiceBean> ib = DatabaseManager.executeBeanQuery(query, InvoiceBean.class);
		return ib;
	}
	
	/**
	 * Creates a new invoice for a given user. The invoice will include the monthly rent and parking fee.
	 * @param uid
	 
	public void generateMonthlyInvoice(long snumber) {
		long invoiceID = generateInvoice(snumber);
		Connection conn = DatabaseManager.getConnection();
		try {
			// Get the users placenumber from Lease
			PreparedStatement ps = conn.prepareStatement("SELECT placenumber FROM lease WHERE snumber=?");
			ps.setLong(0, snumber);
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
			ps.setLong(0, snumber);
			rs = ps.executeQuery();
			// If the result is empty
			if(rs == null || !rs.next()) {
				// Then look in the Guest table
				ps = conn.prepareStatement("SELECT parkingnumber FROM guest WHERE snumber=?");
				ps.setLong(0, snumber);
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
	*/
	
	/**
	 * Get the line items associated with an invoice
	 * @param invoicenumber
	 */
	public ResultSet getLineItems(long invoicenumber) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT fee,itemtype FROM lineitems WHERE invoicenumber=?");
			ps.setLong(1, invoicenumber);
			return ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
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
			ps.setInt(1, fee);
			ps.setString(2, itemtype);
			ps.setLong(3, invoicenumber);
			ps.executeUpdate();
			ps = conn.prepareStatement("UPDATE invoices SET paymentdue=paymentdue+?");
			ps.setInt(1, fee);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Get the set of Leases associated with the given user
	 * @param uid
	 * @return
	 */
	public List<LeaseBean> viewALLeasesBySnumber(Long snumber) throws SQLException {
		String query = "SELECT * FROM lease WHERE snumber=" + snumber + ";";
		List<LeaseBean> ret = DatabaseManager.executeBeanQuery(query, LeaseBean.class);
		return ret;
	}
	
	/**
	 * Get the user's current Lease
	 * @param uid
	 * @return
	 */
	public List<LeaseBean> viewCurrentLeaseBySnumber(Long snumber) throws SQLException {
		String query = "SELECT * FROM lease WHERE active=1 AND snumber=" + snumber + ";";
		List<LeaseBean> ret = DatabaseManager.executeBeanQuery(query, LeaseBean.class);
		return ret;
	}
	
	/**
	 * Get the user's former Leases
	 * @param uid
	 * @return
	 */
	public List<LeaseBean> viewFormerLeasesBySnumber(Long snumber) throws SQLException {
		String query = "SELECT * FROM lease WHERE ended=1 AND snumber=" + snumber + ";";
		List<LeaseBean> ret = DatabaseManager.executeBeanQuery(query, LeaseBean.class);
		return ret;
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
			ps.setLong(1, placenumber);
			ResultSet rs =  ps.executeQuery();
			ArrayList<Long> ret = new ArrayList<Long>();
			while(rs.next()) {
				ret.add(rs.getLong("parkingnumber"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ParkingSpaceBean> getAvailibleParking(long housingLocation, boolean remoteAllowed) {
		String sql;
		if (remoteAllowed) {
			sql = "SELECT * FROM `parkingspots` WHERE `lotnumber` IN (" +
				  "	SELECT `lotnumber` FROM `parkinglotsnear` WHERE `near` = " + housingLocation +
				  ") AND `snumber` IS NULL;";
		} else {
			sql = "SELECT * FROM " + 
			"(SELECT * FROM `parkingspots` WHERE `lotnumber` IN  (" + 
			"	SELECT `lotnumber` FROM `parkinglots` WHERE `lotnumber` NOT IN (" +
			"		SELECT `lotnumber` FROM `parkinglotsnear`" +
			"	)" + 
			") AND `snumber` IS NULL) AS A" + 
			"UNION" +
			"(SELECT * FROM `parkingspots` WHERE `lotnumber` IN (" +
			"	SELECT `lotnumber` FROM `parkinglotsnear` WHERE `near` = " + housingLocation +
			") AND `snumber` IS NULL);";
		}

		try {
			return DatabaseManager.executeBeanQuery(sql, ParkingSpaceBean.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
			ps.setLong(1, parkingnumber);
			ResultSet rs =  ps.executeQuery();
			rs.next();
			if(rs.getLong("parkingnumber") == 0) {
				return -1;
			}
			ps = conn.prepareStatement("INSERT INTO ParkingSpots (lotnumber,classification) VALUES(?,?)");
			ps.setLong(1, parkingnumber);
			ps.setString(2, classification);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()) {
				return rs.getLong(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
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
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the available apartments
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public List<ApartmentBean> getAllAvailableApartments() throws SQLException {
			String getAllAvailabelApartmentsQuery = "SELECT * FROM appartments" + ";";
			List<ApartmentBean> availableApartments = DatabaseManager.executeBeanQuery(getAllAvailabelApartmentsQuery, ApartmentBean.class);
			return availableApartments;
	}

	/**
	 * Adds to the appartment table
	 * 
	 * @param rent
	 * @param deposit
	 * @param apttype
	 * @param housingDetailsLocation
	 * @param aptnum
	 * @param family
	 */
	public void addAppartments(long rent, long deposit, String apttype,
			int housingDetailsLocation, int aptnum, int family) {
		Connection conn = DatabaseManager.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO appartments (rent, deposit,apttype,housingDetailsLocation,aptnum,family) VALUES(?,?,?,?,?,?)");
			ps.setFloat(1, rent);
			ps.setFloat(2, deposit);
			ps.setString(3, apttype);
			ps.setInt(4, housingDetailsLocation);
			ps.setInt(5, aptnum);
			ps.setInt(6, family);
			ps.executeUpdate();
			// TODO add payments to invoices
			/*
			 * ps =
			 * conn.prepareStatement("UPDATE invoices SET paymentdue=paymentdue+?"
			 * ); ps.setInt(0, fee); ps.executeUpdate();
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the cost for the specified parking classification
	 * 
	 * @param classification
	 * @return
	 */
	public float getParkingClassCosts(String classification) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn
					.prepareStatement("SELECT cost FROM parkingclasscosts WHERE classification = ?");
			ps.setString(1, classification);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				float cost = rs.getFloat("cost");
				rs.close();
				ps.close();
				return cost;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Adds the parkingcost
	 * 
	 * @param classification
	 * @param cost
	 */
	public void addParkingClassCosts(String classification, float cost) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO parkingclasscosts (classification, cost) VALUES(?,?)");
			ps.setString(1, classification);
			ps.setFloat(2, cost);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getParkingLotsNear(int nearLotNumber) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("SELECT lotnumber FROM parkinglotsnear WHERE near = ?");
			ps.setInt(1, nearLotNumber);
			ResultSet rs = ps.executeQuery();
			List<String> lotsNumber = new ArrayList<String>();
			if (rs.next()) {
				lotsNumber.add(rs.getString("lotnumber"));
				rs.close();
				ps.close();
				return lotsNumber;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * Adds the parkingcost
	 * 
	 * @param classification
	 * @param cost
	 */
	public void addParkingLotsNear(Long lotNumber, Long near) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO parkinglotsnear (lotnumber, near) VALUES(?,?)");
			ps.setLong(1, lotNumber);
			ps.setLong(2, near);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Long> getParkingSpotsForStudent(int snumber) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("SELECT spotnumber FROM parkingspots WHERE snumber = ?");
			ps.setInt(1, snumber);
			ResultSet rs = ps.executeQuery();
			List<Long> lotsNumber = new ArrayList<Long>();
			if (rs.next()) {
				lotsNumber.add(rs.getLong("lotnumber"));
				rs.close();
				ps.close();
				return lotsNumber;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ParkingSpotsBean> getAllParkingSpots() throws SQLException {
		String getAllParkingSpotsQuery = "SELECT * FROM parkingspots" + ";";
		List<ParkingSpotsBean> getAllParkingSpots = DatabaseManager.executeBeanQuery(getAllParkingSpotsQuery, ParkingSpotsBean.class);
		return getAllParkingSpots;
			
	}

	/**
	 * Adds the parkingcost
	 * 
	 * @param classification
	 * @param cost
	 */
	public void addParkingSpot(Long lotNumber, String classification, Long sNumber) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO parkingspots (lotnumber, classification, snumber) VALUES(?,?,?)");
			ps.setLong(1, lotNumber);
			ps.setString(2, classification);
			ps.setLong(3, sNumber);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<StudentHallInspectionBean> getStudentHallInspection(int inspectionID) throws SQLException {
		String getStudentHallInspectionQuery = "SELECT * FROM studenthallinspection WHERE inspectionID = " + inspectionID + ";";
		List<StudentHallInspectionBean> getStudentHallInspection = DatabaseManager.executeBeanQuery(getStudentHallInspectionQuery, StudentHallInspectionBean.class);
		return getStudentHallInspection;
			
	}

	public void addStudentHallInspectionInformation(Long staffNumber, Long leaseNumber, String inspectionDate, String propertyCondition, String comments) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO studenthallinspection (staffnumber, leasenumber, inspectiondate, propertycondition, comments) VALUES(?,?,?,?,?)");
			ps.setLong(1, staffNumber);
			ps.setLong(2, leaseNumber);
			ps.setString(3, inspectionDate);
			ps.setString(4, propertyCondition);
			ps.setString(5, comments);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<StaffBean> getStaffByStaffNumber(long staffNumber) throws SQLException {
		String getStaffByStaffNumberQuery = "SELECT * FROM staff WHERE staffnumber = " + staffNumber + ";";
		List<StaffBean> getStaffByStaffNumber = DatabaseManager.executeBeanQuery(getStaffByStaffNumberQuery, StaffBean.class);
		return getStaffByStaffNumber;
	}
	
	public List<StaffBean> getAllStaff() throws SQLException {
		String getAllStaffQuery = "SELECT * FROM staff" + ";";
		List<StaffBean> getAllStaff = DatabaseManager.executeBeanQuery(getAllStaffQuery, StaffBean.class);
		return getAllStaff;
	}
	
	public static List<MaintenanceTicketBean> getMaintenanceTicketsByStudent(long snumber) throws SQLException {
		String sql = "SELECT * FROM maintnencetickets WHERE createdby = " + snumber + ";";
		List<MaintenanceTicketBean> getMaintenanceTicketsByLeaseNumber = DatabaseManager.executeBeanQuery(sql, MaintenanceTicketBean.class);
		return getMaintenanceTicketsByLeaseNumber;
	}
	
	public List<MaintenanceTicketBean> getAllMaintenanceTickets() throws SQLException {
		String getAllMaintenanceQuery = "SELECT * FROM maintnencetickets" + ";";
		List<MaintenanceTicketBean> getAllMaintenanceTickets = DatabaseManager.executeBeanQuery(getAllMaintenanceQuery, MaintenanceTicketBean.class);
		return getAllMaintenanceTickets;
	}
	
	public void addMaintenanceTicket(MaintenanceTicketBean mtb) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO maintnencetickets (issue, createdon, status, createdby, comments) VALUES(?,?,?,?,?)");
			
			ps.setString(1, mtb.issue);
			ps.setDate(2, mtb.createdon);
			ps.setString(3, mtb.status);
			ps.setLong(4, mtb.createdby);
			ps.setString(5, mtb.comments);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addLeaseRequest(LeaseRequestBean lrb) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO newleasereq (snumber, reqloc1, reqloc2, reqloc3, startdate, enddate, paymentperiod, changedon) VALUES(?,?,?,?,?,?,?,CURRENT_TIMESTAMP)");

			ps.setLong(1, lrb.snumber);
			ps.setLong(2, lrb.reqloc1);
			if (lrb.reqloc2 != null)
				ps.setLong(3, lrb.reqloc2);
			else
				ps.setNull(3, java.sql.Types.INTEGER);
			if (lrb.reqloc3 != null)
				ps.setLong(4, lrb.reqloc3);
			else
				ps.setNull(4, java.sql.Types.INTEGER);
			
			ps.setDate(5, lrb.startdate);
			ps.setDate(6, lrb.enddate);
			ps.setString(7, lrb.paymentperiod);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static LeaseBean getCurrentlLease(long snumber) {
		try {
			List<LeaseBean> b = DatabaseManager.executeBeanQuery("SELECT * FROM `lease` WHERE `snumber`=" + snumber + " AND `active`=1 LIMIT 1;", LeaseBean.class);
			if (b.size() == 0)
				return null;
			return b.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting current lease status");
			return null;
		}
	}
	
	public static List<LeaseBean> getPastLeases(long snumber) {
		try {
			List<LeaseBean> b = DatabaseManager.executeBeanQuery("SELECT * FROM `lease` WHERE `snumber`=" + snumber + " AND `active`=0;", LeaseBean.class);
			if (b.size() == 0)
				return null;
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting current lease status");
			return null;
		}
	}
	
	public static List<HallSimpleInfo> getSimpleHallInfo(long snumber, boolean current) {
		String sql = "SELECT hallrooms.roomnum, housingdetails.name, startdate, enddate, leasenumber, paymentperiod FROM lease " +
				"JOIN hallrooms ON hallrooms.hallLocation=lease.hallLocation " +
				"JOIN housingdetails ON hallrooms.housingDetailsLocation = housingdetails.housingDetailsLocation " +
				"WHERE lease.snumber=" + snumber + " ";

		int flag = current?1:0;
		sql += " AND `active`=" + flag + ";";
		
		try {
			List<HallSimpleInfo> i = DatabaseManager.executeBeanQuery(sql, HallSimpleInfo.class);
			if (i == null || i.size() == 0){
				System.out.println("Error no current hall lease found");
				return null;
			}
			return i;
		} catch (SQLException e) {
			System.out.println("Error retrieving hall details");
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<SemesterBean> getSemesterList() {
		String sql = "SELECT * FROM `semesters`;";
		try {
			List<SemesterBean> l = DatabaseManager.executeBeanQuery(sql, SemesterBean.class);
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<AptFullInfo> getAppartments(Long year) {
		String sql = "SELECT * FROM `appartments` "+ 
			"JOIN `housingdetails` ON appartments.housingDetailsLocation = housingdetails.housingDetailsLocation " + 
			"WHERE requiredYear <= " + year + ";";
		try {
			List<AptFullInfo> i = DatabaseManager.executeBeanQuery(sql, AptFullInfo.class);
			if (i == null || i.size() == 0){
				System.out.println("No appartments availible for this student class year");
				return null;
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<AptSimpleInfo> getSimpleAptInfo(long snumber, boolean current) {
		String sql = "SELECT appartmentrooms.roomnum, appartments.aptnum, housingdetails.name, startdate, enddate, leasenumber, paymentperiod FROM lease " +
			"JOIN appartmentrooms ON lease.`aptLocation`=appartmentrooms.aptLocation " + 
			"JOIN `appartments` ON appartmentrooms.aptnum=appartments.aptnum " +
			"JOIN `housingdetails` ON housingdetails.housingDetailsLocation = appartments.housingDetailsLocation " +
			"WHERE lease.snumber=" + snumber + " ";
		
		int flag = current?1:0;
		sql += " AND `active`=" + flag + ";";
		
		try {
			List<AptSimpleInfo> i = DatabaseManager.executeBeanQuery(sql, AptSimpleInfo.class);
			if (i == null || i.size() == 0){
				System.out.println("Error no current appartment lease found");
				return null;
			}
			return i;
		} catch (SQLException e) {
			System.out.println("Error retrieving appartment details");
			e.printStackTrace();
		}
		return null;
	}
	
	public void addLeaseTerminationRequest(LeaseTerminationRequestBean ltrb) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("INSERT INTO leaseterminaterequest (leasenumber, status, reason, enddate, staffnumber) VALUES(?,?,?,?,?)");

			ps.setLong(1, ltrb.leasenumber);
			ps.setString(2, ltrb.status);
			ps.setString(3, ltrb.reason);
			ps.setDate(4, ltrb.enddate);
			ps.setLong(5, ltrb.staffnumber);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<HousingDetailsBean> getHousingLocations(Long year) {
		String sql = "SELECT * FROM `housingdetails` WHERE `requiredYear` <= " + year + ";";
		try {
			return DatabaseManager.executeBeanQuery(sql, HousingDetailsBean.class);
		} catch (SQLException e) {
			System.out.println("Error retrieving list of housing options");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void rejectLeaseRequestByReqID(Long reqid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("UPDATE newleasereq SET status='REJECTED' WHERE reqid=?");
			ps.setLong(1, reqid);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("resource")
	public static void approveLeaseRequest(StaffPendingHousingBean b) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			
			// Update the lease request to be processed
			ps = conn.prepareStatement("UPDATE newleasereq SET status='PROCESSED' WHERE reqid=?");
			ps.setLong(1, b.reqid);
			ps.executeUpdate();
			
			// Check to see if there is a the AssignedPlace references a halllocation
			ps = conn.prepareStatement("SELECT * FROM hallrooms WHERE hallLocation=?");
			
			ps.setLong(1, b.AssignedPlace);
			
			ResultSet rs = ps.executeQuery();
			
			// If AssignedPlace references a halllocation
			if(rs.next()) {
				// Update the room that this student is being assigned to with their snumber
				ps = conn.prepareStatement("UPDATE hallrooms SET snumber=? WHERE hallLocation=? AND roomnum=? ");
			} else {
				// If not the AssignedPlace should be an appartment. We will just assume that it is.
				ps = conn.prepareStatement("UPDATE appartmentrooms SET snumber=? WHERE aptLocation=? AND roomnum=?");
			}
			
			ps.setLong(1, b.snumber);
			ps.setLong(2, b.AssignedPlace);
			ps.setLong(3, b.AssignedRoom);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void approveLeaseTerminationRequest(StaffLeaseTerminationStorBean b) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DatabaseManager.getConnection();
			
			// Update the lease request to be processed
			ps = conn.prepareStatement("UPDATE leaseterminaterequest SET status='PROCESSED' WHERE reqid=?");
			ps.setLong(1, b.requestid);
			ps.executeUpdate();
			
			// Update the lease to reflect that it has been completed
			ps = conn.prepareStatement("UPDATE lease SET active=0 hallrooms WHERE leasenumber=?");
			ps.setLong(1, b.leasenumber);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("SELECT snumber FROM lease WHERE leasenumber=?");
			ps.setLong(1, b.leasenumber);
			
			ResultSet rs = ps.executeQuery();
			
			Long snumber = rs.getLong("snumber");
			
			ps = conn.prepareStatement("SELECT * FROM hallrooms WHERE snumber=?");
			ps.setLong(1, snumber);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = conn.prepareStatement("UPDATE hallrooms SET snumber=NULL WHERE snumber=?");
				ps.setLong(1, snumber);
			} else {
				ps = conn.prepareStatement("UPDATE appartmentrooms SET snumber=NULL WHERE snumber=?");
				ps.setLong(1, snumber);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<LeaseRequestBean> getLeaseRequestsByStudent(Long snumber) {
		String sql = "SELECT * FROM `newleasereq` WHERE `snumber`=" + snumber + " AND leasenumber IS NULL;";
		try {
			return DatabaseManager.executeBeanQuery(sql, LeaseRequestBean.class);
		} catch (SQLException e) {
			System.out.println("Error retreiving lease requests");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void rejectLeaseTerminationRequeset(StaffLeaseTerminationStorBean b) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Long l = b.requestid;
			conn = DatabaseManager.getConnection();
			ps = conn.prepareStatement("UPDATE leaseterminationrequest SET status='REJECTED' WHERE reqid=?");
			ps.setLong(1, l);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static List<ParkingNearBean> getParkingNear(Long loc) {
		String sql = "SELECT * FROM parkinglotsnear JOIN housingdetails ON near=housingDetailsLocation WHERE lotnumber=" + loc + ";";
		try {
			return DatabaseManager.executeBeanQuery(sql, ParkingNearBean.class);
		} catch (SQLException e) {
			System.out.println("Error retrieving nearby lots to location " + loc);
			e.printStackTrace();
			return null;
		}
	}
	
	public static SimpleParkingSlot getCurrentParking(Long snumber) {
		String sql = "SELECT * FROM `parkingspots` WHERE snumber=" + snumber + ";";
		List<SimpleParkingSlot> s;
		try {
			s = DatabaseManager.executeBeanQuery(sql, SimpleParkingSlot.class);
		} catch (SQLException e) {
			System.out.println("Failed to load current parking slot");
			e.printStackTrace();
			return null;
		}
		if (s == null || s.size() == 0)
			return null;
		return s.get(0);
	}
	
	public static List<ParkingAvailibleBean> getParkingAvailibilities() {
		String sql = "SELECT \r\n" + 
				"        *, COUNT(lotnumber) AS count\r\n" + 
				"    FROM\r\n" + 
				"        (SELECT \r\n" + 
				"        *\r\n" + 
				"    FROM\r\n" + 
				"        (SELECT \r\n" + 
				"        *\r\n" + 
				"    FROM\r\n" + 
				"        `parkingspots`\r\n" + 
				"    WHERE\r\n" + 
				"        `lotnumber` IN (SELECT \r\n" + 
				"                `lotnumber`\r\n" + 
				"            FROM\r\n" + 
				"                `parkinglots`\r\n" + 
				"            WHERE\r\n" + 
				"                `lotnumber` NOT IN (SELECT \r\n" + 
				"                        `lotnumber`\r\n" + 
				"                    FROM\r\n" + 
				"                        `parkinglotsnear`))\r\n" + 
				"            AND `snumber` IS NULL) AS A UNION (SELECT \r\n" + 
				"        *\r\n" + 
				"    FROM\r\n" + 
				"        `parkingspots`\r\n" + 
				"    WHERE\r\n" + 
				"        `lotnumber` IN (SELECT \r\n" + 
				"                `lotnumber`\r\n" + 
				"            FROM\r\n" + 
				"                `parkinglotsnear`)\r\n" + 
				"            AND `snumber` IS NULL)) AS B\r\n" + 
				"    GROUP BY classification , lotnumber;";
		try {
			return DatabaseManager.executeBeanQuery(sql, ParkingAvailibleBean.class);
		} catch (SQLException e) {
			System.out.println("Error retrieving list of availible parking spaces.");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void insertParkingRequestBean(CreateParkingRequestBean b) throws SQLException {
		String sql = "INSERT INTO `parkingrequests` (`snumber`, `classification`, `requestlot`, `changedon`) VALUES (?,?,?, CURRENT_TIMESTAMP);";
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(sql);
		ps.setLong(1, b.snumber);
		ps.setString(2, b.classification);
		if (b.requestlot == null)
			ps.setNull(3, java.sql.Types.INTEGER);
		else
			ps.setLong(3, b.requestlot);
		ps.executeUpdate();
		ps.close();
	}
	
	public static void createMaintinenceTicket(MaintenanceTicketBean b) throws SQLException {
		String sql = "INSERT INTO `csc440`.`maintnencetickets` (`issue`, `createdby`, `comments`, `createdon`) VALUES (?, ?, ?, CURRENT_DATE);";
		PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(sql);
		ps.setString(1, b.issue);
		ps.setLong(2, b.createdby);
		ps.setString(3, b.comments);
		ps.executeUpdate();
		ps.close();
	}
}
