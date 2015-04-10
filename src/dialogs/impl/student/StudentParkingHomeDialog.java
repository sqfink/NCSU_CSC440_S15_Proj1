package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="New request", value=1),
		@SelectionOption(prompt="View parking lot information", value=2),
		@SelectionOption(prompt="View current parking assignment", value=3),
		@SelectionOption(prompt="View nearby housing", value=4),
		@SelectionOption(prompt="View parking permit request status", value=5),
		@SelectionOption(prompt="Back", value=6),
})
public class StudentParkingHomeDialog extends SelectionDialog {

}
