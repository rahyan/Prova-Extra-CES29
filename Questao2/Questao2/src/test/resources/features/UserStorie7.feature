# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 7)	Como usu�rio do caixa, eu desejo logar na minha conta
				para poder realizar as opera��es dispon�veis.

Esquema do Cenário: Usuario cadastrando tentando logar na sua conta
	Dado aquele <usuario> cadastrado
	Quando ele tentar logar na sua conta
	Então ele tem que conseguir

Exemplos:
 |  usuario     |
 |  ricardo     |
 |  paulovitor  |
 |  lucas       |
 |  marcelo     |