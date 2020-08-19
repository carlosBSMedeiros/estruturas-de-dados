package ed.faesa.simplesmente;

import ed.faesa.dados.Item;

public class ListaSimples {

	private No primeiro;
	private No ultimo;
	private int quantidadeNos;

	public ListaSimples() {
		this.primeiro = null;
		this.ultimo = null;
		this.quantidadeNos = 0;
	}

	public No getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No prim) {
		this.primeiro = prim;
	}

	public No getUltimo() {
		return ultimo;
	}

	public void setUltimo(No ult) {
		this.ultimo = ult;
	}

	public int getQuantidade() {
		return quantidadeNos;
	}

	public void setQuantidade(int quantidade) {
		this.quantidadeNos = quantidade;
	}

	public boolean eVazia() {
		return (this.primeiro == null);
	}

	public String toString() {
		String mensagem = "";
		No atual = this.primeiro;
		if (this.primeiro == null) {
			mensagem = "Lista Vazia";
		}

		while (atual != null) {
			mensagem += atual.getInfo().getChave() + " ";
			atual = atual.getProx();
		}
		return mensagem;

	}

	public No pesquisaNoValor(int chave) {
		No atual = this.primeiro;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProx();
		}
		return atual;

	}

	public No pesquisaNoPosicao(int posicao) {
		No atual = this.primeiro;
		int posicaoAtual = 1;
		while ((atual != null) && posicaoAtual < (posicao)) {
			atual = atual.getProx();
			posicaoAtual++;
		}

		return atual;
	}

	// INSERIR NÓ

	public void inserirUltimo(Item elemento) {

		No novoNo = new No(elemento);
		if (eVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProx(novoNo);
		}

		this.ultimo = novoNo;
		this.quantidadeNos++;
	}

	public void inserirDepoisDoPrimeiro(Item elemento) {
		No aux = new No(elemento);
		aux.setProx(this.primeiro.getProx());
		this.primeiro.setProx(aux);
		this.quantidadeNos++;
	}

	public void inserirNaPosicaoK(Item elemento, int posicaoK) {

		No novoNo = new No(elemento);

		if (posicaoK == 1) {
			novoNo.setProx(this.primeiro);
			this.primeiro = novoNo;
		} else {
			No atual = pesquisaNoPosicao(posicaoK - 1);
			novoNo.setProx(atual.getProx());
			atual.setProx(novoNo);
		}
		this.quantidadeNos++;
	}

	// EXCLUIR NO

	public void excluirNaPosicaoK(int posicaoK) {

		if (posicaoK == 1) {
			this.primeiro = this.primeiro.getProx();
		} else {
			No noAnterior = pesquisaNoPosicao(posicaoK - 1);
			No noExcluir = pesquisaNoPosicao(posicaoK);

			noAnterior.setProx(noExcluir.getProx());
		}
		this.quantidadeNos--;

	}

	public void excluirDepoisDoAtual(No atual) {
		atual = atual.getProx();
		this.primeiro.setProx(atual);
		this.quantidadeNos--;
	}

	public void excluiUltimo(No atual) {

	}

	// MANIPULAR LISTAS

	public boolean concatenarDuasListas(ListaSimples lista) {
		if (lista.eVazia()) {
			return false;
		} else if (this.eVazia()) {
			this.primeiro = lista.primeiro;
			this.ultimo = lista.ultimo;
			this.quantidadeNos = lista.quantidadeNos;
			lista.zerarLista();

		} else {

			this.ultimo.setProx(lista.primeiro);
			this.quantidadeNos += lista.getQuantidade();
			lista.zerarLista();
			return true;
		}
			return true; 
	}

	public void dividirListaEmDuas(ListaSimples lista) {
		
		No meioDaL1 = this.pesquisaNoPosicao((this.quantidadeNos)/2);
		lista.setPrimeiro(meioDaL1.getProx());
		lista.setUltimo(this.ultimo);
		
		int quantidadeNosLista2 = this.quantidadeNos - (this.quantidadeNos / 2 + 1); 
		
		this.quantidadeNos /= 2;
		lista.setQuantidade(quantidadeNosLista2);
		
		meioDaL1.setProx(null);
		this.setUltimo(meioDaL1);
	}

	public double calculaMediaArit() {
		int mediaArit = 0;
		if(this.eVazia()) {
			mediaArit = -1;
		} else {
			No atual = this.getPrimeiro();
			for (int i = 1; i < this.getQuantidade(); i++) {
				mediaArit += atual.getInfo().getChave();
				atual = atual.getProx();
	
			}
			mediaArit /= this.getQuantidade();
		}
		
		return mediaArit;
	}

	public boolean compararListas(ListaSimples lista) {

		boolean iguais = true;
		if (this.quantidadeNos != lista.getQuantidade() || (this.eVazia() || lista.eVazia())) {
			iguais = false;
		} else {
			No atualLista1 = this.primeiro;
			No atualLista2 = lista.getPrimeiro();
			while (atualLista1 != null) {
				if (atualLista1.getInfo().getChave() != atualLista2.getInfo().getChave()) {
					iguais = false;
				}
				atualLista1.setProx(this.primeiro.getProx());
				atualLista2.setProx(lista.getPrimeiro().getProx());
			}
		}

		return iguais;
	}
	
	public int pesquisaEContaNo(int chave) {
		if(this.eVazia()) {
			return -1;
		}else {
			Integer contador = 0;
			No atual = this.primeiro;
			for(int i = 0; i < this.getQuantidade(); i++) {
				if(atual.getInfo().getChave() == chave) {
					contador++;
				}
				atual = atual.getProx();
			}
			
			if(contador == 0) {
				this.inserirUltimo(new Item(chave));
				contador = 1;
			}
			return contador;
		}
	}
	
	public boolean estaContidaNaLista(ListaSimples lista2) {
		if(this.eVazia() || lista2.eVazia() || lista2.getQuantidade() < this.getQuantidade()) {
			return false;
		}
	
		No thisAtual = this.getPrimeiro();
		No lista2Atual = lista2.getPrimeiro();
			
		int contadorIguais = 0;
		for(int i = 0; i < this.getQuantidade(); i++) {
			
			for(int j = 0; j < lista2.getQuantidade(); j++) {
				if(thisAtual.getInfo().getChave() == lista2Atual.getInfo().getChave()) {
					contadorIguais++;
				}
				lista2Atual = lista2Atual.getProx();
			}
				
			lista2Atual = lista2.getPrimeiro();
			thisAtual = thisAtual.getProx();

		}
		
		if(contadorIguais == this.getQuantidade()) {
			return true;
		} else {
			return false;
		}
		
	}

	//REVISÃO PROVA
	/*
	 * QUESTÃO 1 - Construa um método que crie uma lista encadeada reversa, de modo que os dados
	fornecidos em primeiro lugar sejam os últimos, e os últimos dados, os primeiros na nova lista. A lista
	não está vazia. Exemplo:
	 */

	public ListaSimples inverteLista() {
		ListaSimples lista = new ListaSimples();
		
		No atual;
		int aux = 0;		
		
		while(lista.getQuantidade() != this.getQuantidade()) {
		
			atual = this.pesquisaNoPosicao(this.getQuantidade() - aux);
			
			lista.inserirUltimo(atual.getInfo());
		
			aux++;
		}
			
		return lista;
	}
	
	/*
	 * QUESTÃO 2 - Construa um método que receba como parâmetro uma lista (L2) e um número inteiro
	N e retorne a lista resultante da inserção da segunda lista na primeira, sequencialmente, a partir da
	posição N da primeira lista. As listas não estão vazias.
	Exemplo: N = 3*/
	
	public void uneListasDepoisDo(int posicao, ListaSimples lista) {
		
		No atual = this.pesquisaNoPosicao(posicao);
		No aux = atual.getProx();
		lista.getUltimo().setProx(aux);
		atual.setProx(lista.getPrimeiro());
	}
	
	/*
	 * QUESTÃO 03 - Dada a Lista Linear Simplesmente Encadeada, faça um método que caminhe na
	lista somando os elementos que são pares. Depois que percorreu toda a lista, insira um novo elemento
	no final da lista contendo o valor da soma.*/
	
	public void somaParesEInsere() {
		No atual = this.getPrimeiro();
		int aux = 0;
		
		while(atual != null) {
			if(atual.getInfo().getChave() % 2 == 0) 
				aux += atual.getInfo().getChave();
			
			atual = atual.getProx();
		}
		
		this.inserirUltimo(new Item(aux));
	}
	
	/*
	 * PROVA
	 */
	
	public void somaImparesEInsereMedia() {
		No atual = this.primeiro;
		int somatorio = 0;
		int quantidade = 0;

		while (atual != null) {
			if (atual.getInfo().getChave() % 2 != 0) {
				somatorio += atual.getInfo().getChave();
				quantidade++;
			}
			atual = atual.getProx();
		}

		int media = somatorio / quantidade;
		this.inserirUltimo(new Item(media));
	}
	
	public void divideListaParesImpares(ListaSimples L2Par, ListaSimples L3Impar) {
		No atual = this.primeiro;

		while (atual != null) {

			int aux = atual.getInfo().getChave();

			if (aux % 2 == 0) {
				L2Par.inserirUltimo(new Item(aux));
			} else {
				L3Impar.inserirUltimo(new Item(aux));
			}

			atual = atual.getProx();
		}

		this.zerarLista();
	}
	
	public void zerarLista() {
		this.setPrimeiro(null);
		this.setUltimo(null);
		this.quantidadeNos = 0;
	}

}
