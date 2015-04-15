package dialogs.impl.newlease;

import java.util.List;

import dbms.beans.AptFullInfo;
import dialogs.ListSelectionDialog;

public class AptDataListDailog extends ListSelectionDialog {

	public AptDataListDailog(List in) {
		super(in);
	}

	@Override
	protected String EntityPrinter(Object element) {
		AptFullInfo i = (AptFullInfo) element;
		StringBuilder s = new StringBuilder();
		s.append(i.locationName);
		s.append(" Appartment ");
		s.append(i.aptnum);
		s.append(" (");
		s.append(i.apttype);
		s.append(")");
		return s.toString();
	}

}
