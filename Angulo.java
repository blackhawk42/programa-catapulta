import java.util.Scanner;

public class Angulo {
	
	public static final double G = 9.81; // Gravedad
	public static final double K = 0.0136248946; // K del resorte
	public static final double M = 0.08147 + 0.6; // Masas de chancla y base
	
	public static void main (String args[])
	{
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Inserte el valor de Y: ");
		double y = entrada.nextDouble();
		System.out.print("Inserte el valor de X: ");
		double x = entrada.nextDouble();
		System.out.print("Inserte el valor de la deformación: ");
		double d = entrada.nextDouble();
		
		double angulo = radToDeg(angle(velocidad(d,K,M), G, y, x));
		
		System.out.printf("Velocidad: " + velocidad(d,K,M));
		System.out.printf("Ángulo necesario: " + angulo);
		
		
	}
	
	public static double gradToRad(double x)
	{
		return x * (Math.PI/180);
	}
	
	public static double radToDeg(double x)
	{
		return x * (180/Math.PI);
	}
	
	public static double velocidad(double x, double k, double m)
	{
		return Math.sqrt( (Math.pow(x,2)*k)/m);
	}
	
	public static double angle(double v, double g, double y, double x)
	{
		return Math.atan(( Math.pow(v, 2) - Math.sqrt( Math.pow(v, 4) - g*(g*Math.pow(x,2) + 2*y*Math.pow(v,2))) )/(g*x));
	}
}
