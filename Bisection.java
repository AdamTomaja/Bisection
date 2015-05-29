/**
 * Algorytm wyznaczania miejsca zerowego za pomocą bisekcji
 
 
 * @author Adam Tomaja
 */
public class Bisection {
 
	/** 
	 * Służy do przekazywania obiektów funkcji obliczających wartość dla podanego argumentu x
	 * @author unborn
	 *
	 */
	interface IFunction
	{
		public double calculate(double x);
	}
	
	/**
	 * Wyznacza miejsce zerowe za pomocą algorytmu bisekcji
	 * @param a - lewa granica 
	 * @param b - prawa granica
	 * @param function - obiekt funkcji, której miejsce zerowe będzie liczyć funkcja
	 * @return miejsce zerowe funkcji
	 */
	public static double bisection(double a, double b, IFunction function)
	{
		double x;
		double yX;
		while((yX = function.calculate(x = (a + b) / 2)) != 0)
		{	
			if(function.calculate(a) * yX > 0) //Sprawdzam wartości funkcji mają różne znaki dla podanych granic
				a = x; //Zawężam z lewej strony
			else 
				b = x; //Zawężam z prawej strony	
		}		
		return x;
	}
	
	/**
	 * Demonstracja
	 */
	public static void main(String[] args) {
		double a = -2, b = 2; //Granice bisekcji
		
		System.out.println("bisekcja: " + bisection(a, b, new IFunction() {
			@Override
			public double calculate(double x) {
				return Math.pow(x, 3) - x - 2;
			}
		}));
	}
}
