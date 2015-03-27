import beans.InputDialog;
import beans.annotations.DialogAttributes;
import beans.annotations.InputField;

@DialogAttributes(
	prompt = "Test input dialog"
)
public class TestDialog extends InputDialog {
	@InputField(
		failMessage = "Invalid name",
		prompt = "Name"
	)
	public String name;
	
	@InputField(
		failMessage = "Invalid count",
		prompt = "Count",
		regex = "\\d+"
	)
	public Integer i;
}
