import java.io.IOException;

public class main {

	public static void main(String[] args) {
		TestDialog t = new TestDialog();
		try {
			t.doCLIPrompt();
		} catch (IllegalAccessException |IOException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

}
