import java.io.FileOutputStream;
import java.io.IOException;

public class A5_Write7ToFile3 {

	public static void main(String[] args) {
		try(FileOutputStream out = new FileOutputStream("data.dat")) {
			out.write(65);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
