import dialogs.SelectionDialog;
import dialogs.annotations.*;

@SelectionOptions(options={
		@SelectionOption(prompt="A", value=0),
		@SelectionOption(prompt="B", value=1)
})
public class TestSelection extends SelectionDialog {

}
