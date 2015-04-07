package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="View current invoice", value=1),
		@SelectionOption(prompt="View past invoices", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class StudentViewInvoicesDialog extends SelectionDialog {

}
