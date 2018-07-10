import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A3_MakeFileAndDir {

	public static void main(String[] args) {
		Path fp = Paths.get("D\\JavaStudy\\empty.txt");
	//	fp = Files.createFile(fp);	// 파일 생성
		
		Path dp1 = Paths.get("D\\JavaStudy\\empty");
	//	dp1 = Files.createDirectory(dp1);	// 디렉토리 생성
		
		Path dp2 = Paths.get("D\\JavaStudy2\\empty");
	//	dp2 = Files.createDirectories(dp2);	// 경로의 모든 디렉토리 생성

		
		System.out.println("File: " +dp1);
		System.out.println("Dir1: " +dp1);
		System.out.println("Dir2: " +dp2);
		
		
	}

}
