# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 6)Como usu�rio do caixa, eu desejo poder criar
                uma conta corrente para poder utilizar os servi�os
                oferecidos pelo banco.

Esquema do Cenário: Usuario tentando criar uma conta
	Dado algum <usuario> nao cadastrado com uma senha forte
	Quando ele realizar um cadastro
	Então ele deve conseguir

Exemplos:
 |  usuario     |
 |  rodrigo     |
 |  grande      |
 |  pequeno     |
 |  mumnome     |