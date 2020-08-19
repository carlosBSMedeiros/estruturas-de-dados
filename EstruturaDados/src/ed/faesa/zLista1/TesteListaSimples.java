package ed.faesa.zLista1;

import ed.faesa.dados.Item;
import ed.faesa.simplesmente.ListaSimples;


public class TesteListaSimples {

	public static void main(String args[]) {
		
//		int[] itens1 = new int[]{};
//		int[] itens2 = new int[]{};
		
//		int[] itens1 = new int[]{4, 8, 17};
//		int[] itens2 = new int[]{4};

		
		int[] itens1 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] itens2 = new int[]{1, 2, 1};

		

		ListaSimples lista1 = new ListaSimples();
		ListaSimples lista2 = new ListaSimples();

		for (int i : itens1) {
			Item item = new Item(i);
			
			lista1.inserirUltimo(item);
		}
		
		for (int i : itens2) {
			Item item = new Item(i);
			
			lista2.inserirUltimo(item);
		}
		
//		System.out.println("lista 1 antes de inserir o numero 7 na posição nº 1 = " + lista1.toString());
//		
//		Item item7 = new Item(7);
//		lista1.InserirNaPosicaoK(item7, 1);
//		
//		System.out.println("lista 1 depois de inserir o numero 7 na posição nº 1 = " + lista1.toString());
//		
//		lista1.ExcluirNaPosicaoK(3);
//		
//		System.out.println("Lista 1 removendo o numero na posição 3 = " + lista1.toString());
//		lista1.ZerarLista();
//
//		System.out.println("Listas antes da concatenação");
//		System.out.println("Lista 1 = " + lista1.toString());
//		System.out.println("Lista 2 = " + lista2.toString());
//		
//		lista1.ConcatenarDuasListas(lista2);
//		
//		System.out.println("Listas após a concatenação:");
//		System.out.println("Lista 1 = " + lista1.toString());
//		System.out.println("Lista 2 = " + lista2.toString());
//		System.out.println("Quantidade de nos na lista = " + lista1.getQuantidade());
//		
//		int a = 8;
//		System.out.println( a / 2);
		
//		System.out.println("lista 1 terá a média do seus valores calculada: \rMédia = ");
//		double media = lista1.CalculaMediaArit();
//		System.out.println(media);
//		
//		lista2.ZerarLista();
//		System.out.println("Lista 1 = " + lista1.toString());
//		System.out.println("lista 1 será dividida");
//		lista1.DividirListaEmDuas(lista2);
//		
//		System.out.println("Lista 1 = " + lista1.toString());
//		System.out.println("Lista 2 = " + lista2.toString());
		
//		Integer auxiliar = 0;
//		int busca = 2;
//		System.out.println("Lista que terá o valor "+ busca +" buscado");
//		System.out.println("Lista 1 = " + lista1.toString());
//
//		auxiliar = lista1.pesquisaEContaNo(busca);
//		
//		if(auxiliar == -1) {
//		System.out.println("Lista vazia!");
//		} else {
//		System.out.println("O item "+busca+" aparece "+ auxiliar + " vezes na lista");
//		}
//		
//		System.out.println("Lista 1 = " + lista1.toString());
		
		
		ListaSimples L2Par = new ListaSimples();
		ListaSimples L3Impar = new ListaSimples();
		
		System.out.println("Divide a lista em duas, uma de itens pares, e outra de itens ímpares");
		System.out.println("Lista 1 = " + lista1.toString());
//		System.out.println("Lista 2 = " + lista2.toString());
		
		lista1.divideListaParesImpares(L2Par, L3Impar);
		
		System.out.println("\rListas após as alterações\r");
		
		System.out.println("Lista 1 = " + lista1.toString());
		System.out.println("Lista L2Par = " + L2Par.toString());
		System.out.println("Lista L3Impar = " + L3Impar.toString());
//		System.out.println("Lista 2 = " + lista2.toString());


//OS METODOS USADOS DENTRO DE OUTROS METODOS DEVEM ESTAR NA PROVA EM, LEMBRA DISSO
		
//		System.out.println("OS METODOS USADOS DENTRO DE OUTROS METODOS DEVEM ESTAR NA PROVA EM, LEMBRA DISSO");
	}
	
}
