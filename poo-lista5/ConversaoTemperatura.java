
class ConversaoDeTemperatura{

	public static double deCelsiusParaFahrenheit(double celsius){	
		return ((9*celsius/5)+32);
	}
	
	public static double deFahrenheitParaCelsius(double fahrenheit){	
		return ((fahrenheit-32)*5/9);
	}
	
	public static double deCelsiusParaKelvin(double celsius){	
		return (celsius+273.15);
	}
	
	public static double deKelvinParaCelsius(double kelvin){	
		return (kelvin-273.15);
	}
	
	public static double deKelvinParaFahrenheit(double kelvin){	
		double celsius = deKelvinParaCelsius(kelvin);
		double fahrenheit = deCelsiusParaFahrenheit(celsius);
		return (fahrenheit);
		
	}
	
	public static double deFahrenheitParaKelvin(double fahrenheit){	
		double celsius = deFahrenheitParaCelsius(fahrenheit);
		double kelvin = deCelsiusParaKelvin(celsius);
		return (kelvin);
	}
	
}

public class ConversaoTemperatura {

	public static void main(String[] args) {

		System.out.println(ConversaoDeTemperatura.deCelsiusParaFahrenheit(15.23));
		System.out.println(ConversaoDeTemperatura.deFahrenheitParaCelsius(59.0));
		System.out.println(ConversaoDeTemperatura.deCelsiusParaKelvin(12.5));
		System.out.println(ConversaoDeTemperatura.deKelvinParaCelsius(278.15));
		System.out.println(ConversaoDeTemperatura.deKelvinParaFahrenheit(40.0));
		System.out.println(ConversaoDeTemperatura.deFahrenheitParaKelvin(30.5));
		
	}
}
