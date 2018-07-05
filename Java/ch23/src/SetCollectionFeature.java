// 저장 순서가 유지되지 않는다.
// 데이터의 중복 저장을 허용하지 않는다.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCollectionFeature {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Toy");		set.add("Box");
		set.add("Robot");	set.add("Box");
		System.out.println("인스턴스 수: " + set.size());
		
		// 반복자를 이용한 전체 출력
		for(Iterator<String> itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		// for~each 문을 이용한 전체 출력
		for(String s : set)
			System.out.print(s + '\t');
		System.out.println();		
	}
}
// 출력 결과를 통해 동일 인스턴스가 저장되지 않음을 알 수 있다.