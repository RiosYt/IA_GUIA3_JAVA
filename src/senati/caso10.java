package senati;

import java.util.Scanner;
import java.text.DecimalFormat;

public class caso10 {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		
		String continuar = "s", nombre = "", nom_mayor = "", nom_menor = "", nom_min = "";
		int min = 0, i = 1, num_em = 0, min_mayor = 0, num_meta = 0;
		float tarifa = 0,por_horas = 0, mayor = 0, menor = 0, horas =0;
		
		while(continuar.equals("S") || continuar.equals("s")) {
			System.out.println("==============================");
			System.out.println("  Resgistro de Empleados (" + i + ")  ");
			System.out.println("==============================");
			System.out.print("Empleado: ");
			nombre = scn.nextLine();
			System.out.print("Horas Trabajadas: ");
			horas = scn.nextFloat();
			while (horas < 0) {
				System.out.println("Número de horas no permitidas");
				System.out.print("Horas Trabajadas: ");
				horas = scn.nextFloat();
			}
			
			System.out.print("Tarifa por hora: ");
			tarifa = scn.nextFloat();
			while (tarifa < 0) {
				System.out.println("Número de tarifa no permitida");
				System.out.print("Tarifa por hora: ");
				tarifa = scn.nextFloat();
			}
			
			System.out.print("Minutos de tardanza: ");
			min = scn.nextInt();
			while(min < 0) {
				System.out.println("Número de minutos por tardanza no permitidos");
				System.out.print("Minutos de tardanza: ");
				min = scn.nextInt();
			}
			
			float sb = horas * tarifa;
			float bono = 0;
			
			if (horas > 50 && horas <= 60) 
				bono = 0.02f * sb;
			else if (horas > 60 && horas <= 70)
				bono = 0.08f * sb;
			else if (horas > 70 && horas <= 80)
				bono = 0.13f * sb;
			else if(horas > 80)
				bono = 0.15f * sb;
			
			float dscto = 0;
			
			if (min > 15 && min <= 30)
				dscto = 0.003f * sb * min;
			else if (min > 30)
				dscto = 0.005f * sb * min;
			
			float sn = sb + bono - dscto;
			
			if (num_em == 0) {
				mayor = sn;
				nom_mayor = nombre;
				menor = sn;
				nom_menor = nombre;
				min_mayor = min;
				nom_min = nombre;
			}
			else {
				if (sn > mayor) {
					mayor = sn;
					nom_mayor = nombre;
				}
			
				if (sn < menor) {
					menor = sn;
					nom_menor = nombre;
				}
				if (min > min_mayor) {
					min_mayor = min;
					nom_min = nombre;
				}
			}
			
		
			
			
			por_horas = (horas / 80) * 100;
			
			if (por_horas > 90)
				num_meta++;
			
			System.out.println("================");
			System.out.println("   RESULTADOS   ");
			System.out.println("================");
			System.out.println("Sueldo Bruto : " + df.format(sb));
			System.out.println("Bonificación : " + df.format(bono));
			System.out.println("Descuento    : " + df.format(dscto));
			System.out.println("Sueldo Neto  : " + df.format(sn));
			System.out.println("% Alcanzado  : " + df.format(por_horas) + "%");
			System.out.println("================");
			scn.nextLine();
			System.out.print("¿Nuevo Empleado? [S/N]: ");
			continuar = scn.nextLine();
			System.out.println("");
			
			num_em++;
			i++;
		}
		
		System.out.println("-----------------");
		System.out.println("--R E S U M E N--");
		System.out.println("-----------------");
		System.out.println("Número de empleado: " + num_em);
		System.out.println("Sueldo neto mayor: " + df.format(mayor) + " pertenece a: " + nom_mayor);
		System.out.println("Sueldo neto menor: " + df.format(menor) + " pertenece a: " + nom_menor);
		System.out.println("Empleado con la mayor cantidad de minutos de tardanza: " + nom_min + " (" + min + " min. )");
		System.out.println("Cantidad de empleados con más del 90% de la meta: " + num_meta);
	}
}
