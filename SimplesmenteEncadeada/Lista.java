package pacote;

public class Lista {
	No inicio;

	Lista() {
		inicio = null;
	}

	// METODO IMPRIMIR

	void imprimir() {
		if (inicio == null) {
			System.out.println("Lista vazia");
		} else {
			System.out.println();
			No ultimo = inicio;
			while (ultimo != null) {
				System.out.print(ultimo.conteudo + " ");
				ultimo = ultimo.proximo;
			}
		}
	}

	// METODO INSERIR

	void inserir(int nro) {
		No no = new No();
		no.conteudo = nro;

		if (inicio == null) {
			inicio = no;
		} else {
			No ultimo = inicio;
			while (ultimo.proximo != null) {
				ultimo = ultimo.proximo;
			}
			ultimo.proximo = no;
		}
	}

	// METODO LAST

	No last() {
		No ultimo = inicio;
		if (ultimo != null) {
			while (ultimo.proximo != null) {
				ultimo = ultimo.proximo;
			}
		}

		return ultimo;
	}

	// METODO COUNT

	int count(int quant, No no) {

		if (no == null) {
			return quant;
		} else {
			return count(++quant, no.proximo);
		}
	}

	// METODO SUMR

	int sumR(int soma, No no) {
		if (no == null) {
			return soma;
		} else {
			soma += no.conteudo;
			return sumR(soma, no.proximo);
		}
	}

	// METODO HEIGHT

	int height(int valor) {
		
		int contaPasso = -1;
		No ultimo = inicio;
		boolean contar = false;
		
		while (ultimo != null) {
			
			if (ultimo.conteudo==valor) {
				contar=true;
			}
			
			ultimo = ultimo.proximo;

			if (contar) {
				contaPasso++;
			}
			
		}
		
		return contaPasso;
	
	}

	// METODO DEPHT

	int depth(int valor) {
		No aux = inicio;
		int cont = 0;
		while (aux != null) {
			if (aux.conteudo == valor) {
				break;
			}
			cont++;
			aux = aux.proximo;
		}
		return cont;
	}

	// METODO SORT

	void sort() {
		boolean trocou = false;
		if (inicio != null && inicio.proximo != null) {
			No a, b, c;
			a = null;
			b = inicio;
			c = b.proximo;

			do {
				if (b.conteudo > c.conteudo) {
					trocou = true;

					if (a == null) {
						inicio = c;
						b.proximo = c.proximo;
						c.proximo = b;
					} else {
						a.proximo = c;
						b.proximo = c.proximo; 
						c.proximo = b;
					}
				}
				a = b;
				b = c;
				c = c.proximo;
			} while (c != null);
			if (trocou) {
				sort();
			}

		}
	}

	void unsort() { // errado
		boolean trocou = false;
		if (inicio != null && inicio.proximo != null) {
			No a, b, c;
			a = null;
			b = inicio;
			c = b.proximo;

			do {
				if (b.conteudo < c.conteudo) {
					trocou = true;

					if (a == null) {
						inicio = c;
						b.proximo = c.proximo;
						c.proximo = b;
					} else {
						a.proximo = c;
						b.proximo = c.proximo;
						c.proximo = b;
					}
				}
				if(a!=null) {
				System.out.println("\na :"+a.conteudo+"\nb :"+b.conteudo+"\nc :"+c.conteudo+"\n\n");
				}
				imprimir();
				a = b;
				b = c;
				c = c.proximo;
				
			} while (c != null);
		
			if (trocou) {
				sort();
			}

		}
	}
	
	// METODO TOARRAY

	int[] toArray() {
		
		int v[] = new int [count(0, inicio)];
		
		No ultimo = inicio;
		int k=0;
		while (ultimo != null) {
			v[k]=ultimo.conteudo;
			ultimo = ultimo.proximo;
			k++;
		}
		
		return v;
	
	}
	
}