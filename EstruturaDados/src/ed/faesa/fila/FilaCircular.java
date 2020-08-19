package ed.faesa.fila;

import ed.faesa.dados.ItemObj;
import ed.faesa.pilha.PilhaContigua;

public class FilaCircular {

	private ItemObj[] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int quant) {
		info = new ItemObj[quant];
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;

	}

	public ItemObj[] getInfo() {
		return info;
	}

	public int getFrente() {
		return frente;
	}

	public int getTras() {
		return tras;
	}

	public int getTamanho() {
		return tamanho;
	}

	public boolean eVazia() {
		return (this.tamanho == 0);
	}

	public boolean eCheia() {
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar(ItemObj item) {

		if (this.eCheia()) {
			return false;
		} else {

			this.info[this.getTras()] = item;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;

			return true;
		}
	}

	public ItemObj desenfileirar() {
		if (this.eVazia()) {
			return null;
		} else {

			ItemObj no = this.info[this.getFrente()];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}

	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		if(!this.eVazia()) {
			int aux = this.frente;
			for (int i = 1; i <= this.tamanho; i++) {
				msg.append( this.info[aux].getChave()).append(" ");
				aux = (++aux % this.info.length);
			}
		}else {
			msg.append("Fila vazia!");
		}
		return msg.toString();
	}
	
	public void numero04() {
		
		PilhaContigua pilhaAux = new PilhaContigua(this.tamanho);

		//ordena o conteudo da fila na pilha
		while(this.tamanho != 0) {
			pilhaAux.empilhar(this.desenfileirar());
		}
		
		//adiciona an fila o conteudo da pilha
		while(!pilhaAux.eVazia()) {
			this.enfileirar(pilhaAux.desempilhar());
		}
	}
	
	public void numero05(FilaCircular filaPrio) {
		
		FilaCircular filaAtual = new FilaCircular(this.getInfo().length);
		
		while(this.tamanho != 0){
			if((int) this.getInfo()[this.getFrente()].getChave() >= 70) {
				filaPrio.enfileirar(this.desenfileirar());
			} else {
				filaAtual.enfileirar(this.desenfileirar());
			}
		}
		
		while(filaAtual.getTamanho() != 0) {
			this.enfileirar(filaAtual.desenfileirar());
		}
		
	}
	
	/*
	 * Escreva uma função que altere os valores armazenados na em uma 
	 * Fila Circular aumentando em 10%. A fila contém dados do tipo inteiro e deverão permanece na fila
	 * .*/
	
	public boolean prova01() {
		
		if(this.eVazia()) {
			return false;
		}
		
		for(int aux = this.tamanho; aux > 0; aux--) {
			int valorItem = (Integer) this.desenfileirar().getChave();
			this.enfileirar(new ItemObj(valorItem * 1.1));
		}
		
		return true;
	}

}
