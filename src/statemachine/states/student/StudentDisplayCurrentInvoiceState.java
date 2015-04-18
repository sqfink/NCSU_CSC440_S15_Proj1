package statemachine.states.student;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import daos.Dao;
import dbms.beans.InvoiceBean;
import dbms.beans.LineItemBean;
import dbms.beans.StudentBean;
import statemachine.Runner;
import statemachine.State;

public class StudentDisplayCurrentInvoiceState extends State {

	@Override
	public String doState(Runner r) {
		StudentBean user = (StudentBean) r.getKV("LoggedInUser"); 
		HashMap<InvoiceBean, List<LineItemBean>> invoiceData = new HashMap<InvoiceBean, List<LineItemBean>>();
		try {
			List<InvoiceBean> invoices = Dao.getUnpaidInvoices(user.snumber);
			if (invoices == null || invoices.size() == 0) {
				System.out.println("No unpaid invoices");
				return StudentViewInvoicesState.class.getName();
			}
			invoiceData = new HashMap<InvoiceBean, List<LineItemBean>>();
			for (InvoiceBean b : invoices) {
				invoiceData.put(b, Dao.getLineItems(b.invoicenumber));
			}
		} catch (SQLException e) {
			System.out.println("Error retreiving invoice data. Check error log for details");
			e.printStackTrace();
		}
		for (InvoiceBean b : invoiceData.keySet()) {
			System.out.println("Invoice " + b.invoicenumber);
			System.out.println("Itemized charges:");
			double total = 0;
			for (LineItemBean charge : invoiceData.get(b)) {
				System.out.println("\t$" + charge.fee + "\t" + charge.description);
				total += charge.fee;
			}
			System.out.println("Payment of " + total + " due " + b.duedate);
		}
		return StudentViewInvoicesState.class.getName();
	}

}
