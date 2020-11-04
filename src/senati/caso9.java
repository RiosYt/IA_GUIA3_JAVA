package senati;

import java.util.Scanner;
import java.text.DecimalFormat;

public class caso9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		
		String continuar = "S",alumno_mayor = "", alumno_menor = "";
		int i = 1, num_alum = 0, num_cer = 0, num_sincer = 0;
		float menor = 0, mayor = 0;
		
		while (continuar.equals("S") || continuar.equals("s")) {
			System.out.println("==================");
			System.out.println("    Registro " + i);
			System.out.println("==================");
			
			System.out.print("Nombre del Alumno: ");
			String nombre = scn.nextLine();
			
			System.out.print("Nota 1: ");
			int n1 = scn.nextInt();
			
			while (n1 < 0 || n1 > 20) {
				System.out.println("Nota fuera de rango aceptado");
				System.out.print("Nota 1: ");
				n1 = scn.nextInt();
			}
			
			System.out.print("Nota 2: ");
			int n2 = scn.nextInt();
			
			while (n2 < 0 || n2 > 20) {
				System.out.println("Nota fuera de rango aceptado");
				System.out.print("Nota 2: ");
				n2 = scn.nextInt();
			}
			
			System.out.print("Nota 3: ");
			int n3 = scn.nextInt();
			
			while (n3 < 0 || n3 > 20) {
				System.out.println("Nota fuera de rango aceptado");
				System.out.print("Nota 3: ");
				n3 = scn.nextInt();
			}
				
			System.out.print("Asistencia[1-12]: ");
			float asistencia = scn.nextFloat();
			
			while (asistencia < 1 || asistencia > 12) {
				System.out.println("Número fuera de rango de la asitencia [1-12]");
				System.out.print("Asistencia[1-12]: ");
				asistencia = scn.nextInt();
			}
			
			
			float promedio = 0.2f * n1 + 0.3f * n2 + 0.5f * n3;
			
			float por_asis = (asistencia / 12) * 100;
			
			String estado = "Sin certificado";
			
			if (promedio >= 13 && por_asis >= 70)
				estado = "Obtiene certificado";
			
				
			if (num_alum == 0) {
				mayor = promedio;
				alumno_mayor = nombre;
			}
			else if (promedio > mayor) {
				mayor = promedio;
				alumno_mayor = nombre;
			}
			
			if (num_alum == 0) {
				menor = promedio;
				alumno_menor = nombre;
			}
			else if (promedio < menor) {
				menor = promedio;
				alumno_menor = nombre;
			}
			
			if (estado.equals("Obtiene certificado"))
				num_cer ++;
			else
				num_sincer ++;
			
			System.out.println("================");
			System.out.println("---RESULTADOS---");
			System.out.println("================");
			System.out.println("Promedio........: " + promedio);
			System.out.println("Asistencia......: " + df.format(por_asis) + "%");
			System.out.println("Estado..........: " + estado);
			System.out.println("----------------");
		
			scn.nextLine();
			
			System.out.print("¿Registrar otro? [S/N]: ");
			continuar = scn.nextLine();
			
			System.out.println("----------------");
			
			num_alum++;
			i++;
		}
		
		System.out.println("=================");
		System.out.println("--R E S U M E N--");
		System.out.println("=================");
		System.out.println("Número de Alumnos: " + num_alum);
		System.out.println("Mayor promedio: " + mayor + " pertenece a: " + alumno_mayor);
		System.out.println("Menor promdeio: " + menor + " pertenece a: " + alumno_menor);
		System.out.println("Número de alumnos certificados: " + num_cer);
		System.out.println("Número de alumnos sin certidicado: " + num_sincer);
	}
}
