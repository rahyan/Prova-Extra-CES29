# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 5)Como usu·rio do caixa, eu desejo realizar
				depÛsitos para poder guardar meu dinheiro na minha conta.

Esquema do Cen√°rio: Usuario cadastrado realizando um deposito
	Dado algum <usuario> cadastrado com um <saldo> disponivel
	Quando ele realizar um <deposito>
	Ent√£o saldo deve ter o valor igual ao <esperado>

Exemplos:
 |  usuario   |  saldo  | deposito  | esperado  |
 |  gustavo   |  123    | 100       | 223       |
 |  alencar   |  345    | 45        | 390       |
 |  saraiva   |	 200    | 56        | 256       |
 |  giancarlo |  701    | 1         | 702       |