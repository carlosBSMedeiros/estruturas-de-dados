package ed.faesa.simplesmente;

import ed.faesa.dados.Item;

public class No {

	private Item info;
	private No proximo;
	
	public No(Item elemento) {
		this.info = elemento;
		this.proximo = null;
	}

	public Item getInfo() {
		return info;
	}

	public void setInfo(Item info) {
		this.info = info;
	}

	public No getProx() {
		return proximo;
	}

	public void setProx(No prox) {
		this.proximo = prox;
	}
	
	
	
}
