package Lab202;

public class problem3 {
	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 7, 1, 9};
		
		int[][] arr2D = new int[6][6];
		for(int i=0; i<arr2D.length; i++) {
			for(int j=0; j<arr2D.length; j++) {
				arr2D[i][j]= arr[j];
			}
		}
		System.out.println(sum(arr2D,0,0));
	}
	
	public static int sum(int[][] arr2D, int x,int y) {
		if(arr2D.length==0) {
			return 0;
		}
		int num1 = arr2D[x][y];
		if(y==arr2D.length-1 && x!=arr2D.length-1) {
			return num1+sum(arr2D,x+1,0);
		}
		if(x==arr2D.length-1 && y==arr2D.length-1) {
			return 0;
		}
		else {
			return num1+sum(arr2D,x,y+1);
		}
		
		
	}

}
