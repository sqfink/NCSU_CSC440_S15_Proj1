package dialogs.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;


@DialogAttributes(
		prompt = "Login"
	)
public class LoginPrompt extends InputDialog {
	@InputField(
			failMessage = "Invalid User ID",
			prompt = "User ID",
			regex = "[a-zA-Z0-9]+"
		)
	public String username;
	
	@InputField(
			failMessage = "Invalid password",
			prompt = "Password"
		)
	public String password;
	
	public String hashString(String input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] pwHash = md.digest(input.getBytes());
		
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pwHash.length; i++) {
          sb.append(Integer.toString((pwHash[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
}
