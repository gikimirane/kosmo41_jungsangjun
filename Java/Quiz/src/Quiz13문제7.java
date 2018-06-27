
public class Quiz13문제7 {
	int[][] arr1 = {
			{1,2,3,4},
			{5,6,7,8}};
	public static void main(String[] args) {
	int[][] arr = {
			{1,5},
			{2,6},				
			{3,7},
			{4,8}	
	};
			for(int i = 0; i <arr.length; i++) {
				for(int j = 0; j <arr[i].length; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
	}	
	}
}

