package ed.faesa.zLista1;

import ed.faesa.dados.Item;
import ed.faesa.duplamente.ListaDupla;

public class TesteListaDupla {

	public static void main(String[] args) {

		
		System.out.println("TESTE DE LISTAS DUPLAMENTE ENCADEADAS");
		
		int[] itens1 = new int[]{1, 5, 1, 6};
//		int[] itens2 = new int[]{7, 9, 2, 5, 19, 24};

		ListaDupla lista1 = new ListaDupla();
//		ListaDupla lista2 = new ListaDupla();

		for (int i : itens1) {
			Item item = new Item(i);
			
			lista1.inserirNoUltimo(item);
		}
		
		System.out.println("Verificando se a sequencia num�rica � palindroma");
		System.out.println(lista1.toString());
		
		if(lista1.ePalindroma()) {
			System.out.println("� palindroma");
		} else {
			System.out.println("N�O � PALINDROMA");
		}
		
//		for (int i : itens2) {
//			Item item = new Item(i);
//			
//			lista2.inserirNoUltimo(item);
//		}
		
//		System.out.println("/rListas que ser�o manipuladas:");
//		System.out.println("Lista 1: " + lista1.toString());
//		System.out.println("Lista 2: " + lista2.toString());
//		
//		System.out.println("Metodo que ser� testado a seguir:");
//		System.out.println("Remover n� por posi��o");
//		
//		System.out.println("lista 1 antes da manipula��o:" + lista1.toString());
//		if(lista1.removePorPosicao(1)) {
//			System.out.println("lista 1 depois da manipula��o:" + lista1.toString());
//		}
//	

		
	
	}

}
