# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 3)Como usu�rio do caixa, eu desejo consultar meu
				saldo para saber quanto dinheiro tenho dispon�vel.

Esquema do Cenário: Usuario cadastrado verificando seu saldo
	Dado um <usuario> cadastrado
	Quando ele solicitar o servico de checar saldo
	Então o caixa deve retornar o valor correto

Exemplos:
 |  usuario  |
 |  henrique |
 |  cadeira  |
 |  roberto  |
 |  felipe   |