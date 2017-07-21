# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 4)Como usu·rio do caixa, eu desejo realizar
				pagamentos para poder quitar minhas dÌvidas.

Esquema do Cen√°rio: Usuario cadastrado realizando um pagamento
	Dado um <usuario> cadastrado com um <saldo> disponivel
	Quando ele solicitar realizar um <pagamento>
	Ent√£o saldo deve ter o valor <esperado>

Exemplos:
 |  usuario   |  saldo  | pagamento | esperado  |
 |  malaquias |  123    | 100       | 23        |
 |  buda      |  345    | 45        | 300       |
 |  dudu      |	200     | 56        | 144       |
 |  panda     |  701    | 1         | 700       |