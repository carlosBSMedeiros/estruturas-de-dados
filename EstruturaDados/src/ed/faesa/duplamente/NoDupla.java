package ed.faesa.duplamente;

import ed.faesa.dados.Item;

public class NoDupla {

	private NoDupla proximo;
	private NoDupla anterior;
	private Item info;
	
	public NoDupla(Item item) {
		this.info = item;
		this.proximo = null;
		this.anterior = null; 
	}
	
	public NoDupla getProx() {
		return proximo;
	}
	public void setProx(NoDupla proximo) {
		this.proximo = proximo;
	}
	public NoDupla getAnt() {
		return anterior;
	}
	public void setAnt(NoDupla anterior) {
		this.anterior = anterior;
	}
	public Item getInfo() {
		return info;
	}
	public void setInfo(Item info) {
		this.info = info;
	}
	
	
	
}
