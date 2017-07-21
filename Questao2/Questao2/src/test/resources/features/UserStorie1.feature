# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 1)Como um funcionario do banco, eu desejo que
				um caixa nao possa ser acessado simultaneamente por 
				mais de um usuario para evitar conflitos no sistema.

Esquema do Cenário: Testar saque e deposito
	Dado que um caixa ja foi instanciado
	Quando o usuario tentar instanciar outro caixa
	Então ele nao consegue criar outra instancia

Exemplos:
 | X |
 | A |
 | B |
 | C |
 | D |