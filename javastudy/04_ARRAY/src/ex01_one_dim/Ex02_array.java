package ex01_one_dim;

public class Ex02_array {

	public static void main(String[] args) {
		
		
		// 배열의 초기화
		// int[] arr = new int[] {10, 20, 30, 40, 50};
		int[] arr = {10, 20, 30, 40, 50};
		
		
		// 최대/최소
		int max = arr[0];    // max와 min의 값을 첫번째 요소로 놓고 진행
		int min = arr[0];    //최소값의 초기값을 0으로 놓을 경우 최소값은 항상 0이 나오기 때문에 min의 반대값인 max의 값을 놓고 진행
			
		for(int i = 1; i < arr.length; i++) { 
			if(max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		
		
		
		
		
	}

}
