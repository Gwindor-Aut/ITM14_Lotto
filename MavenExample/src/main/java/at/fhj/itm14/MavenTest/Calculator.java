package at.fhj.itm14.MavenTest;

public class Calculator {

	public Calculator(){
		
	}
	
	public int add(int a, int b){
		return a + b;
	}
	
	public int sub(int a, int b){
		return a - b;
	}
	
	public int mul(int a, int b){
		return a*b;
	}
	
	public int div(int a, int b) throws Exception{
		if (b == 0){
			throw new IndexOutOfBoundsException("Division by 0 not allowed");
		}
		return a/b;
	}
	
}
