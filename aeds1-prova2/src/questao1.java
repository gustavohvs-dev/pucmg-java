
public class questao1 {

	public static void main(String[] args) {

		System.out.println(fatorial(3));

	}
	
	public static int fatorial(int num) {
		
		if(num==0) {
			return 1;
		}else {
			return num*fatorial(num-1);
		}
		
	}

}


