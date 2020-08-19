package ed.faesa.arvore;

import ed.faesa.dados.ItemObj;

public class Arvore {

	private NoArvore raiz;
	private int quantidadeNos;

	public Arvore() {
		this.raiz = null;
		this.quantidadeNos = 0;
	}

	public NoArvore getRaiz() {
		return this.raiz;
	}

	public int getQuantNos() {
		return this.quantidadeNos;
	}

	public boolean eVazia() {
		return (this.raiz == null);
	}

	// pesquisa inicial, que inicia a recursão
	private boolean pesquisar(int chave) {
		if (pesquisar(chave, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}

	// pesquisa da recursão
	private NoArvore pesquisar(int chave, NoArvore no) {

		if (no != null) {
			if (chave < (Integer) no.getInfo().getChave()) {
				no = pesquisar(chave, no.getEsq());
			} else if (chave > (Integer) no.getInfo().getChave()) {
				no = pesquisar(chave, no.getDir());
			}
		}

		return no;
	}

	// inclusão inicial, que inicia a recursão
	public boolean inserir(ItemObj item) {
		if (this.pesquisar((Integer) item.getChave())) {
			return false;
		} else {
			this.raiz = this.inserir(item, this.raiz);
			quantidadeNos++;
			return true;
		}
	}

	//inclusão da recursão
	private NoArvore inserir(ItemObj item, NoArvore no) {
		if (no == null) {
			NoArvore novoNo = new NoArvore(item);
			return novoNo;
		} else {
			if ((Integer) item.getChave() < (Integer) no.getInfo().getChave()) {
				no.setEsq(inserir(item, no.getEsq()));
				return no;
			} else {
				no.setDir(inserir(item, no.getDir()));
				return no;
			}
		}
	}

	public boolean remover(int chave) {
		if (pesquisar(chave, this.raiz) != null) {
			this.raiz = remover(chave, this.raiz);
			this.quantidadeNos--;
			return true;
		} else {
			return false;
		}
	}

	public NoArvore remover(int chave, NoArvore arv) {
		if (chave < (Integer) arv.getInfo().getChave()) {
			arv.setEsq(remover(chave, arv.getEsq()));
		} else {
			if (chave > (Integer) arv.getInfo().getChave()) {
				arv.setDir(remover(chave, arv.getDir()));
			} else {
				if (arv.getDir() == null) {
					return arv.getEsq();
				} else {
					if (arv.getEsq() == null) {
						return arv.getDir();
					} else {
						arv.setEsq(arrumar(arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}

	private NoArvore arrumar(NoArvore arv, NoArvore maior) {
		if (maior.getDir() != null) {
			maior.setDir(arrumar(arv, maior.getDir()));
		} else {
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}

	public ItemObj[] camCentral() {
		int[] n = new int[1];
		n[0] = 0;
		ItemObj[] vet = new ItemObj[this.quantidadeNos];
		return (fazCamCentral(this.raiz, vet, n));
	}

	private ItemObj[] fazCamCentral(NoArvore arv, ItemObj[] vet, int[] n) {
		if (arv != null) {
			vet = fazCamCentral(arv.getEsq(), vet, n);
			// visita o no em si
			vet[n[0]] = arv.getInfo();
			n[0]++;
			// visita o no em si
			vet = fazCamCentral(arv.getDir(), vet, n);
		}
		return vet;
	}

	public ItemObj[] camPreFixado() {
		int[] n = new int[1];
		n[0] = 0;
		ItemObj[] vet = new ItemObj[this.quantidadeNos];
		return (fazCamPreFixado(this.raiz, vet, n));
	}

	private ItemObj[] fazCamPreFixado(NoArvore arv, ItemObj[] vet, int[] n) {
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = fazCamPreFixado(arv.getEsq(), vet, n);
			vet = fazCamPreFixado(arv.getDir(), vet, n);
		}
		return vet;
	}

	public ItemObj[] camPosFixado() {
		int[] n = new int[1];
		n[0] = 0;
		ItemObj[] vet = new ItemObj[this.quantidadeNos];
		return (fazCamPosFixado(this.raiz, vet, n));
	}

	private ItemObj[] fazCamPosFixado(NoArvore arv, ItemObj[] vet, int[] n) {
		if (arv != null) {
			vet = fazCamPosFixado(arv.getEsq(), vet, n);
			vet = fazCamPosFixado(arv.getDir(), vet, n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}
	
	/*03) Faça um método recursivo para contar o número de nós não terminais numa Árvore Binária de Pesquisa*/

	public void contaNosNaoTerminais(NoArvore arv, int[] contador) {
		if (arv != null) {
			
			if(arv.getEsq() != null && arv.getDir() != null) {
				contador[0]++;
			}
			
			contaNosNaoTerminais(arv.getEsq(), contador);
			contaNosNaoTerminais(arv.getDir(), contador);
			
		}
	}
	
	public int procuraMenoresQue(NoArvore arv, int valor, int[] contador) {
		
		if(arv != null) {

			if((Integer) arv.getInfo().getChave() < valor) {
				contador[0]++;
			}
			
			procuraMenoresQue(arv.getEsq(), valor, contador);
			procuraMenoresQue(arv.getDir(), valor, contador);
				
		}
		
		return contador[0];
	}
	
	
	public String toString(ItemObj[] vet, String nomeCaminhamento) {
		StringBuilder msg = new StringBuilder();
		msg.append("Arvore segundo o caminhamento ").append(nomeCaminhamento).append("\r");
		for(ItemObj item : vet) {
			msg.append(item.getChave().toString()).append(" ");
		}
		
		return msg.toString();
	}
	

}
