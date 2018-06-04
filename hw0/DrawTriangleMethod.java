public class DrawTriangleMethod{

	public static void DrawTriangle(int N){
		String star = "*";
		for(int i = 0; i<N; i++){
			System.out.println(star);
			star = star + "*";
		}
	}

	public static void main(String[] args){
		DrawTriangle(15);
	}

}
