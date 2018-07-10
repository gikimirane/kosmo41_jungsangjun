import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A6_CopyFilefromFiles {
	public static void main(String[] args) throws IOException{
		Path src = Paths.get("D:\\JavaStidy\\CopyFileFromFiles.java");
		Path dst = Paths.get("D:\\JavaStidy\\CopyFileFromFiles2.java");
		
		Files.copy(src,  dst, StandardCopyOption.REPLACE_EXISTING);

	}
}
