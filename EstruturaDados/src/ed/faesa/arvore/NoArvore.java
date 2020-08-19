package ed.faesa.arvore;

import ed.faesa.dados.ItemObj;

public class NoArvore {

	private ItemObj info;
	private NoArvore esq, dir;
	
	public NoArvore(ItemObj item) {
		this.info = item;
		this.esq = null;
		this.dir = null;
	}
	
	public ItemObj getInfo() {
		return info;
	}
	public void setInfo(ItemObj info) {
		this.info = info;
	}
	public NoArvore getEsq() {
		return esq;
	}
	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}
	public NoArvore getDir() {
		return dir;
	}
	public void setDir(NoArvore dir) {
		this.dir = dir;
	}
	
	
	
}
