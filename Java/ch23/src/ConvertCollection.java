import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConvertCollection {

	public static void main(String[] args) { // 중복을 허용하는 리스트
		List<String> lst = Arrays.asList("Box", "Toy","Box", "Toy");
		ArrayList<String> list = new ArrayList<>(lst);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
		
		// 중복된 인스턴스를 걸러 내기 위한 작업
		HashSet<String> set = new HashSet<>(list);
		                     // 중복을 허용 않는 집합
		// 원래대로 ArrayList<String> 인스턴스로 저장물을 옮긴다.
		list = new ArrayList<>(set);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();

	}
}
//public HashSet(Collection<? extends E> c)
//	->	다른 컬렉션 인스턴스로부터 HashSet<E> 인스턴스 생성