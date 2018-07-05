import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

 class Stringbinarysearch {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		
		// 정렬
		Collections.sort(list);	// 정렬이 먼저다!
		
		// 탐색
		int idx = Collections.binarySearch(list, "Robot");	// 탐색
		
		// 탐색 결과 출력
		System.out.println(list.get(idx));	 //탐색의 결과 출력
	}
}
