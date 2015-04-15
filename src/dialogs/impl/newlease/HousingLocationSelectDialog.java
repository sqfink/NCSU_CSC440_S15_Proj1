package dialogs.impl.newlease;

import java.util.List;

import dbms.beans.HousingDetailsBean;
import dialogs.ListSelectionDialog;

public class HousingLocationSelectDialog extends ListSelectionDialog {

	public HousingLocationSelectDialog(List in) {
		super(in);
	}

	@Override
	protected String EntityPrinter(Object element) {
		if (element == null) {
			return "Skip selection";
		} 
		HousingDetailsBean b = (HousingDetailsBean) element;
		StringBuilder s = new StringBuilder();
		s.append(b.name);
		s.append(" ");
		s.append(b.address);
		s.append(" ");
		s.append(b.city);
		s.append(", ");
		s.append(b.zip);
		return s.toString();
	}

}
