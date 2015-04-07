package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Housing Option", value=1),
		@SelectionOption(prompt="Parking Option", value=2),
		@SelectionOption(prompt="Log Out", value=3)
})
public class StudentHomepageDialog extends SelectionDialog {

}
