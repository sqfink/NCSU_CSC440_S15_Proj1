package dialogs.impl;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Create new student/guest", value=1),
		@SelectionOption(prompt="Create new staff member", value=2),
		@SelectionOption(prompt="Back", value=3),
})
public class CreatUserTypeSelectDialog extends SelectionDialog {

}
