package br.edu.recursividade;

public class Main {

	public static void main(String[] args) {
		
		int vetor[] = {10,0,5,20};
		
		System.out.println("Fatorial de 5: "+fatorial(5));
		System.out.println("5 elevado a 2: "+potencia(5, 2));
		System.out.println("Maior elemento de um vetor: "+maiorValor(vetor, vetor.length-1, vetor[vetor.length-1]) );
		System.out.println("Somatorio do Vetor: "+somaarrayrec(vetor, 0 ) );
/*
		for(int k=0 ; k<10 ; k++){
			System.out.println("O "+k+"° Termo de Fibonacci eh: "+fibonacci(k) );
		}
*/
	}

	public static int somaarrayrec(int v[],int i){
	  
		System.out.println(i);
		
		if (i < v.length)
		
		  return v[i] + somaarrayrec(v, i++);
	  	
	  return 0;
	}
	
	public static int fibonacci(int termo){
		
		if (termo == 0){
			return 1;
		}
		else if (termo == 1){
			return 1;
		}
		else{
			
			return fibonacci(termo-1)+fibonacci(termo-2);
		}
	}
	
	public static int fatorial(int n){
		
		if (n<=1){
			return 1;
		}
		else{
			
			return n * fatorial(n-1);
		}
	}

	public static int potencia(int base, int expoente){
		
		if (expoente==0){
			return 1;
		}
		else {
			return base* potencia(base, expoente-1);
		}
	}

	public static int somatorio(int vetor[], int elementos){
	
		if (elementos<0){
			return 0;
		}

		return vetor [elementos] + somatorio(vetor, elementos-1);
		
	}

	public static int maiorValor(int vetor[], int elementos, int maior){
		
		if (elementos<0){
			return maior;
		}
		
		if ( vetor[elementos]> maior){
			maior=vetor[elementos];
		}
		
		return maiorValor (vetor, elementos-1, maior);
	}
}

/*								
	5*	fatorial(int 4)		Multiplicou 5* o retorno de "fatorial(int 4)", que no caso eh 6, resultando em 120
		|
		4*	fatorial(int 3)		Multiplicou 4* o retorno de "fatorial(int 3)", que no caso eh 6, resultando em 24
			|
			3*	fatorial(int 2)		Multiplicou 3* o retorno de "fatorial(int 2)", que no caso eh 2, resultando em  6
				|
				2*	fatorial(int 1)		Multiplicou 2* o retorno de "fatorial(int 1)", que no caso eh 1, resultando em 2
					|
					1	 				retornou 1 para o  "fatorial(int 1)"

	Ou seja, todo esse termo se repete até chegar	nao chamar ele mesmo...			
	
	==> Processo de Pilha <==
	
	Agora, devemos pensar da seguinte forma, desempilhamos o que as chamadas recursivas nos proporcionou
	
	1*
	2*
	3*
	4*
	5*
	=	120
*/

/*
Potencia

5* Potencia(5, 3-1)
		|
		5* Potencia(5, 2-1)
				|
			5* Potencia(5, 1-1)
					|		|
				return 1	----> 1-1 = 0 ("Então retorna 1")

5*5*5

base * Potencia(base, expoente-1)
			|
		base * Potencia(base, expoente-1)
					|
				base * Potencia(base, expoente-1)
							|
							...
								até expoente==0

*/

/*

vetor [1, 2, 3]

somatorio(vetor[], elementos)

vetor [3] + somatorio(vetor[], 3-1)		//	3+3 "retorna 6"
					|
				vetor[2]+somatorio(vetor[], 2-1)		// 1+2 "retorna 3"
								|
						vetor[1]+somatorio(vetor[], 1-1)	// 0+1 "retorna 1"
										|
										0					// elementos==0
 
*/

/*

Onde o vetor tem 3 elementos, onde os mesmos são
vetor [1, 2, 3]

FUNÇÂO -> somatorio(vetor[], elementos)

vetor [3] + somatorio(vetor[], 3-1)		//	3+3 "retorna 6"
					|
				vetor[2]+somatorio(vetor[], 2-1)		// 1+2 "retorna 3"
								|
						vetor[1]+somatorio(vetor[], 1-1)	// 0+1 "retorna 1"
										|
		if (elementos == 0)			return 0				// elementos==0

*/
 
/*
FUNÇÂO -> maiorValor (vetor, elementos-1, maior)

FORMA DE PASSAGEM -> maiorValor (vetor, vetor.leght-1, vetor[vetor.leght-1])

situação hipotetica:
Onde o vetor tem 3 elementos, onde os mesmos são
vetor [10, 20, 0]

maiorValor (vetor, 2, 0)
					|				
			verifica vetor[2]>0		//vetor[2]=0 é > maior=0 ?, se sim faça maior=vetor[2]
					|				//logo, maior=0
					|
				maiorValor (vetor, 1, 0)	//vetor[1]=20 é > maior=0 ?, se sim faça maior=vetor[1] 
									|		//logo, maior=20
									|
						maiorValor(vetor, 0, 20)	//vetor[0]=10 é > maior=20 ?, se sim faça maior=vetor[0] 
									|				//logo, maior=20
									|
					elementos é < 0 ?, se sim return maior=20
*/