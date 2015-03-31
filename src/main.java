import java.io.IOException;

public class main {

	public main() {};
	
	public static void main(String[] args) {
		try {
			TestDialog t = new TestDialog();
			t.doCLIPrompt();
			TestSelection s = new TestSelection();
			s.doCLIPrompt();
		} catch (IllegalAccessException |IOException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

}
