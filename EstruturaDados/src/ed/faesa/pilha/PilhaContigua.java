package ed.faesa.pilha;

import ed.faesa.dados.ItemObj;

public class PilhaContigua {

	private ItemObj[] info;
	private int topo;

	public PilhaContigua(int tamanho) {
		this.info = new ItemObj[tamanho];
		topo = 0;
	}

	public int getTamanho() {
		return this.info.length;
	}

	public ItemObj getInfo() {
		return this.info[this.topo - 1];
	}

	public ItemObj[] getInfos() {
		return this.info;
	}

	public int getTopo() {
		return this.topo;
	}

	public boolean eVazia() {
		return (this.topo == 0);
	}

	public boolean eCheia() {
		return (this.topo == this.info.length);
	}

	// insere no topo

	public boolean empilhar(ItemObj novo) {

		if (this.eCheia()) {
			return false;
		} else {
			this.info[this.topo] = novo;
			this.topo++;
			return true;
		}
	}

	public ItemObj desempilhar() {

		if (this.eVazia()) {
			return null;
		} else {
			this.topo--;
			return this.info[this.topo];
		}
	}

	// inverte o conteudo

	public String InverteConteudo() {

		StringBuilder invertido = new StringBuilder();
		int aux = this.topo;

		for (int i = 0; i < aux; i++) {
			invertido.append(this.desempilhar().getChave().toString());
		}

		this.topo = aux;
		return invertido.toString();
	}

	public void removerMaioresQue500() {
		if (this.eCheia()) {

			try {
				PilhaContigua pilhaAux = new PilhaContigua(this.getTamanho());

				while (this.getTopo() != 0) {

					if ((Integer) this.getInfo().getChave() > 500) {
						this.desempilhar();
					} else {
						pilhaAux.empilhar(this.desempilhar());
					}
				}
				
				while(pilhaAux.getTopo() != 0) {
					this.empilhar(pilhaAux.desempilhar());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int compararPilhas(PilhaContigua pilha2) {

		if (this.getTopo() != pilha2.getTopo())
			return 0;

		ItemObj item1, item2;

		while (this.getTopo() != 0) {

			item1 = this.desempilhar();
			item2 = pilha2.desempilhar();

			if (!item1.getChave().equals(item2.getChave())) {
				return 0;
			}

		}

		return 1;
	}
	
	public boolean eInversaDe(String palavra) {
		int tamanho = palavra.length();
		int topo = this.getTopo();
		int contador = 0;
		
		if(tamanho != topo)
			return false;
		
		while(this.getTopo() != 0 && contador <= tamanho) {
			
			ItemObj aux = this.desempilhar();
			
			if((char) aux.getChave() != palavra.charAt(contador)) {
				return false;
			}
			
			contador++;
			
		}
		this.topo = topo;
		return true;
	}
	
	public boolean ePalindroma() {
		
		String auxiliar = "";
		int topo = this.topo;
		PilhaContigua pilhaAux = new PilhaContigua(topo);
		
		while(this.topo != 0) {
			ItemObj item = this.desempilhar();
			pilhaAux.empilhar(item);
			auxiliar += item.getChave();
		}
		this.topo = topo;
						
		for(int i = 0; i <auxiliar.length(); i++) {
			if((char) pilhaAux.desempilhar().getChave() != auxiliar.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public Integer calcularRaizes() {
		Integer somatorio = 0;
		
		PilhaContigua pilhaAux = this;
		
		while(pilhaAux.getTopo() != 0) {
			int expoente = pilhaAux.getTopo();
			int aux = (int) pilhaAux.desempilhar().getChave();
			for(int i = 0; i < expoente; i++) {
				
				somatorio += aux;
			}
			
		}
		
		return somatorio;
	}
	
	public String toString() {
		StringBuilder mensagem = new StringBuilder();

		if (this.getTopo() == 0) {
			mensagem.append("Pilha vazia!");

		} else {

			int topo = this.getTopo();
			while (this.getTopo() != 0) {
				ItemObj aux = this.desempilhar();
				mensagem.insert(0, aux.getChave().toString());
				mensagem.insert(0, " ");
			}
			this.topo = topo;
		}
		return mensagem.toString();
	}

}
