# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 8)Como um funcion�rio do banco, eu desejo que seja
				poss�vel utilizar os servi�os do caixa eletr�nico
				apenas quando uma conta estiver logada para evitar
				panes do sistema.

Esquema do Cenário: Alguem tentando usar o caixa sem estar logado
	Dado alguem usando o caixa sem estar logado 
	Quando tentar utilizar algum servico
	Então o caixa nao ira funcionar

Exemplos:
 |  Y  |
 |  E  |
 |  F  |
 |  G  |
 |  H  |