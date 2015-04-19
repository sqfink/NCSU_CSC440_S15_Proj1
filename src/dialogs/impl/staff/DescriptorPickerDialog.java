package dialogs.impl.staff;

import java.util.List;

import dbms.beans.AptDescriptorBean;
import dbms.beans.HallDescriptorBean;
import dialogs.ListSelectionDialog;

public class DescriptorPickerDialog extends ListSelectionDialog {

	public DescriptorPickerDialog(List in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String EntityPrinter(Object element) {
		if(element == null) 
			return "Back";
		StringBuilder sb = new StringBuilder();
		if (element instanceof HallDescriptorBean) {
			HallDescriptorBean d = (HallDescriptorBean) element;
			sb.append(d.name);
			sb.append(" hall room ");
			sb.append(d.roomnum);
		} else if (element instanceof AptDescriptorBean) {
			AptDescriptorBean d = (AptDescriptorBean) element;
			sb.append("Appartment ");
			sb.append(d.aptnum);
			sb.append(" (");
			sb.append(d.name);
			sb.append(") room ");
			sb.append(d.roomnum);
		} else {
			throw new IllegalArgumentException("Unexpected element type " + element.getClass().getName());
		}
		return sb.toString();
	}

}
