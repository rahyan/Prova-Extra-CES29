# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 6)Como usu·rio do caixa, eu desejo poder criar
                uma conta corrente para poder utilizar os serviÁos
                oferecidos pelo banco.

Esquema do Cen√°rio: Usuario tentando criar uma conta
	Dado algum <usuario> nao cadastrado com uma senha forte
	Quando ele realizar um cadastro
	Ent√£o ele deve conseguir

Exemplos:
 |  usuario     |
 |  rodrigo     |
 |  grande      |
 |  pequeno     |
 |  mumnome     |