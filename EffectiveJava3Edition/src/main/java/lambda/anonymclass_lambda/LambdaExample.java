package lambda.anonymclass_lambda;

public class LambdaExample {
	
	public String exampleFour() 
	{
		return "Örnek 4";
	}
	
	public String exampleFour2() 
	{
		return "Örnek 10";
	}
	
	public static void main(String[] args) {
		
		// lambda nedir
		/*
		 * Kendi başına tanımlanabilen, parametre kabul eden ve döndürebilen
		 * fonksiyondur.
		 * 
		 * Kullanım şekli: (argument-list) -> {body}
		 * 
		 */
		
		
		// ######1Functional Lambda
		
		
		Print y = () -> {
			return "yazdım";
			};
		System.out.println(y.print());
		
		
		
		// ######2 Functional with param
		
		String param = "Parametre";
		// Lambda with parameter
		PrintParameter y2 = (paramAlacak) -> {
			return paramAlacak + " selam";
		};
		System.out.println(y2.printTheParameter(param));
		
		
		
		
		// ######3 Method referansları 43. bölümde detaylı işleyeceğiz burada giriş yaptım.
		LambdaExample le = new LambdaExample();
		
		Print write = le::exampleFour2;
		System.out.println(write.print());

		
		// @functionalinterface içinde sadece tek metod olması gerektiğinde bahset. implementasyon sıkıntısı cıkmasın diye..
		

		
	}

}
