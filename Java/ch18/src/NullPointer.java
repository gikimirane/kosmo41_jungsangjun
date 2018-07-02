class NullPointer {
	public static void main(String[] args) {
		String str = null;
		System.out.println(str); 	// null 출력
		if(str != null) {
		int len = str.length();		// Exception!
	}
  }
}
// 에러가 안나오게 한거
// 주석 5와 주석9를 삭제하면 에러가 나옴