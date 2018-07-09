import java.time.LocalDate;
import java.time.Period;

class A3_LocalDateDemol {
	public static void main(String[] args) {
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		
		// 올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// 크리스마스까지 앞으로 며칠?
		Period left = Period.between(today, xmas);
		System.out.println("Xmas까지 앞으로 " + 
		left.getMonths() + "월 " + left.getDays() + "일");
	}
}
// Public int getYears()	->  // Period의 메소드
// Public int getMonths()	->	// Period의 메소드
// Public int getDays		->	// Period의 메소드