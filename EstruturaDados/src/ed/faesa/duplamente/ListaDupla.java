package ed.faesa.duplamente;

import ed.faesa.dados.Item;

public class ListaDupla {

	private NoDupla primeiro;
	private NoDupla ultimo;
	private int quantidade;

	public ListaDupla() {
		this.quantidade = 0;
		this.primeiro = null;
		this.ultimo = null;
	}

	public NoDupla getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NoDupla primeiro) {
		this.primeiro = primeiro;
	}

	public NoDupla getUltimo() {
		return ultimo;
	}

	public void setUltimo(NoDupla ultimo) {
		this.ultimo = ultimo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String toString() {
		String mensagem = "";
		NoDupla atual = this.primeiro;
		if (this.primeiro == null) {
			mensagem = "Lista Vazia";
		}

		while (atual != null) {
			mensagem += atual.getInfo().getChave() + " ";
			atual = atual.getProx();
		}
		return mensagem;
	}

	public boolean isVazia() {
		if (this.quantidade == 0 || this.primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	// PESQUISAS
	public NoDupla pesquisaNoPosicao(int posicao) {
		NoDupla noBusca = this.primeiro;
		int posicaoAtual = 1;
		while (noBusca != null && posicaoAtual < posicao) {
			noBusca = noBusca.getProx();
			posicaoAtual++;
		}
		return noBusca;
	}

	public NoDupla pesquisaNoValor(int valor) {
		NoDupla noBusca = this.primeiro;
		while (noBusca != null && noBusca.getInfo().getChave() != valor) {
			noBusca = noBusca.getProx();
		}
		return noBusca;
	}

	// INSERIR

	public void inserirNoUltimo(Item item) {
		NoDupla novoNo = new NoDupla(item);
		if (this.isVazia()) {
			this.primeiro = novoNo;
		} else {
			novoNo.setAnt(this.ultimo);
			this.ultimo.setProx(novoNo);
		}
		this.ultimo = novoNo;
		this.quantidade++;
	}

	// REMOVER

	public boolean removePorValor(int valor) {
		NoDupla noRemover = this.primeiro;

		while (noRemover != null && noRemover.getInfo().getChave() != valor)
			noRemover = noRemover.getProx();

		if (noRemover == null) {
			return false;
		}

		if (noRemover == this.primeiro) {
			this.primeiro.getProx().setAnt(null);
			this.primeiro = this.primeiro.getProx();
			quantidade--;
			return true;
		} else if (noRemover == this.ultimo) {
			this.ultimo.getAnt().setProx(null);
			this.ultimo = this.ultimo.getAnt();
			quantidade--;
			return true;
		} else {
			noRemover.getAnt().setProx(noRemover.getProx());
			noRemover.getProx().setAnt(noRemover.getAnt());
			quantidade--;
			return true;
		}

	}

	public boolean removePorPosicao(int posicao) {
		NoDupla noRemover = this.primeiro;

		int contador = 1;
		while (noRemover != null && contador < posicao) {
			noRemover = noRemover.getProx();
			contador++;
		}

		if (noRemover == null) {
			return false;
		}

		if (noRemover == this.primeiro) {
			this.primeiro.getProx().setAnt(null);
			this.primeiro = this.primeiro.getProx();
			quantidade--;
			return true;
		} else if (noRemover == this.ultimo) {
			this.ultimo.getAnt().setProx(null);
			this.ultimo = this.ultimo.getAnt();
			quantidade--;
			return true;
		} else {
			noRemover.getAnt().setProx(noRemover.getProx());
			noRemover.getProx().setAnt(noRemover.getAnt());
			quantidade--;
			return true;
		}

	}
	
	public boolean ePalindroma() {
		
		NoDupla atual = this.primeiro;
		NoDupla aux = this.ultimo;
		
		while(atual != null) {
			if(atual.getInfo().getChave() != aux.getInfo().getChave()) {
				return false;
			}
			atual = atual.getProx();
			aux = aux.getAnt();
		}
		
		return true;
	}

	

}
