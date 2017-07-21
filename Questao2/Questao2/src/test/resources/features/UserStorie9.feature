# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 9)Como usu�rio do caixa, eu desejo poder deslogar
				da minha conta para evitar que outras pessoas utilizem
				minha conta.

Esquema do Cenário: Usuario do caixa tentando deslogar sua conta
	Dado um <usuario> cadastrado e logado no caixa
	Quando tentar deslogar
	Então ele deve conseguir deslogar

Exemplos:
 |  usuario  |
 |  joel     |
 |  jackson  |
 |  rogerio  |
 |  bezerra  |