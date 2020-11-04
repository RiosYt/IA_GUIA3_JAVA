package senati;

import java.util.Scanner;

public class caso3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Ingrese número: ");
		int n = scn.nextInt();
		
		int i = 1, producto = 1;
		
		if (n <= 7)
			while (i <= n) {
				producto = producto * i;
							
				if (i == n)
					System.out.print("\nEl factorial de " + i + " es: " + producto);
				i++;
			}
		else
			System.out.println("El número es superior a 7");
		
	
	}
}
