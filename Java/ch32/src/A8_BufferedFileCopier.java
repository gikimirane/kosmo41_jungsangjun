import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

class A8_BufferedFileCopier {	// 1k바이트 버퍼 기반 파일 복사 프로그램
	
	
	public static void main(String[] args) {	
	Scanner sc = new Scanner(System.in);
			System.out.print("대상 파일 : ");
			String src = sc.nextLine();
			System.out.println("사본 이름 : ");
			String dst = sc.nextLine();
			
			try(InputStream in = new FileInputStream(src);
					OutputStream out = new FileOutputStream(dst)) {
				byte buf[] = new byte[1024];
				int len;
	
				while(true) {
					len = in.read(buf);	// 배열 buf로 데이터를 읽어 들이고
					if(len == -1)	    // (더 이상 읽어 들일 데이터 없으면 -1 반환)
						break;
					out.write(buf, 0, len);	// len 바이트만큼 데이터를 저장한다.
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	 }
}
// public int read(byte[] b) throws IOException
// -> 파일에 저장된 데이터를 b로 전달된 배열에 저장
// public void write(byte[] b, int off, int len) throws IOException
// -> b로 전달된 배열의 데이터를 인덱스 off에서부터 len 바이트만큼 파일에 저장