package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;
import statemachine.Runner;
import statemachine.State;

@SelectionOptions(options={
		@SelectionOption(prompt="View current lease", value=1),
		@SelectionOption(prompt="View past leases", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class StudentViewLeasesDialog extends SelectionDialog {

}
