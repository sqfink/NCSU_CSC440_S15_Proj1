package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Lease requests", value=1),
		@SelectionOption(prompt="Lease termination requests", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class ViewStatusPickerDialog extends SelectionDialog {

}
