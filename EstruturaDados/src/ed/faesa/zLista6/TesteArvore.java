package ed.faesa.zLista6;

import ed.faesa.arvore.Arvore;
import ed.faesa.dados.ItemObj;

public class TesteArvore {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		
		int[] itens = new int[] {14, 15, 16, 12, 11, 9};
		
		for(int item : itens) {
			arvore.inserir(new ItemObj((Integer) item));
		}
		
		int[] contador = new int[] {0};
		arvore.procuraMenoresQue(arvore.getRaiz(), 10 ,contador);
		
		System.out.println("Contador de nós maiores que 10: " + contador[0]);
		
		//toStrings
		System.out.println(arvore.toString(arvore.camCentral(), "In-Ordem"));
		System.out.print("\r");
		
		
		System.out.println(arvore.toString(arvore.camPreFixado(), "Pre-Ordem"));
		System.out.print("\r");
		System.out.println(arvore.toString(arvore.camPosFixado(), "Pos-Ordem"));
		System.out.print("\r");


	}

}
