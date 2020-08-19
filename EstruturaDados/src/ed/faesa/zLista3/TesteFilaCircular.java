package ed.faesa.zLista3;

import ed.faesa.dados.ItemObj;
import ed.faesa.fila.FilaCircular;

public class TesteFilaCircular {

	public static void main(String[] args) {

		Integer[] objetos = new Integer[] {10, 20, 30, 40, 60, 120};
		
		FilaCircular fila = new FilaCircular(objetos.length + 1);
		
		for(int objeto : objetos) {
			fila.enfileirar(new ItemObj(objeto));
		}
		
		System.out.println("Fila antes da manipulação");
		System.out.println(fila.toString());
		
		fila.prova01();
		
		System.out.println("Fila depois da manipulação");
		System.out.println(fila.toString());
	}

}
