# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 7)	Como usuário do caixa, eu desejo logar na minha conta
				para poder realizar as operações disponíveis.

Esquema do CenÃ¡rio: Usuario cadastrando tentando logar na sua conta
	Dado aquele <usuario> cadastrado
	Quando ele tentar logar na sua conta
	EntÃ£o ele tem que conseguir

Exemplos:
 |  usuario     |
 |  ricardo     |
 |  paulovitor  |
 |  lucas       |
 |  marcelo     |