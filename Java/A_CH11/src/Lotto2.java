
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Lotto2 {
 
    public static void main(String[] args) {
 
        Lotto2 lotto = new Lotto2();
        Scanner sc = new Scanner(System.in);
 
        System.out.print("로또번호 추출 개수 입력: ");
        int gameCnt = sc.nextInt();
 
        for (int i = 1; i <= gameCnt; i++) {
            System.out
                    .println(i + "번째 로또번호: " + lotto.lottoNumbers());
        }
    }
 
    String lottoNumbers() {
 
        Set<Integer> set = new HashSet<Integer>();
        while( set.size() < 6){
            Double d = Math.random() * 45 + 1;
            set.add(d.intValue()); 
        }
         
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
         
        return list.toString();
    }
}


