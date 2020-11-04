package senati;

import java.util.Scanner;

public class caso5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = 0, i = 1, menor = 0;
		
		while (i <= 5) {
			System.out.print("Ingrese número " + i + ": ");
			n = scn.nextInt();
			
			if (i == 1) 
				menor = n;
			else if (n < menor)
				menor = n;
			
			i++;
		}
		System.out.println("El número menor es: " + menor);
	}
}
