package ed.faesa.zLista2;

import ed.faesa.dados.ItemObj;
import ed.faesa.pilha.PilhaContigua;

public class TestesPilha {

	public static void main(String[] args) {

		int[] itensPilha = new int[] {15, 5, 78, 20, 2, 8, 3};
		PilhaContigua pilhaInts = new PilhaContigua(itensPilha.length);
		
		for(int item : itensPilha) {
			pilhaInts.empilhar(new ItemObj(item));
		}
		
		System.out.println(pilhaInts.toString());
		pilhaInts.removerMaioresQue500();
		System.out.println(pilhaInts.toString());

	}

}
