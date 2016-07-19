
public class test {
	
	public static void main(String[] args) {
		
		int a = 0 ;
		
		for(int i = 0 ; i< 5 ; i++)
		{
			
			System.out.println("i값은?:"+i);
			if(i==3){
				a= i;
				break;
			}
			a = a+1;
			System.out.println("i값은?:"+i);
			
		}
		
		System.out.println("a값은?:"+a);
		
		
	}

}
