import java.nio.file.Path;
import java.nio.file.Paths;

class A2_CurrentDir {
	public static void main(String[] args) {
		Path cur = Paths.get("");// 현재 디렉토리 정보 '상대 경로' 형태로 담긴 인스턴스
		String cdir;
		
		if(cur.isAbsolute())
			cdir = cur.toString();
		else
			cdir = cur.toAbsolutePath().toString();
		
		System.out.println("Current dir: " + cdir);

	}

}
