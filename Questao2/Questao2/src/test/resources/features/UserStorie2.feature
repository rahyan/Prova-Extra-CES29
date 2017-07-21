# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: 2)Como um funcionario do banco, eu desejo que
				os usuarios possuam uma senha forte (pelo menos
				8 caracteres, pelo menos 1 numero, pelo menos 1 letra
				e pelo menos 1 caractere especial) para evitar fraudes.

Esquema do Cenário: Testar aceitacao/negacao de senha forte/fraca
	Dado um <usuario> com uma <senha>
	Quando um usuario tentar criar uma conta
	Então ele deve conseguir apenas se a senha for forte

Exemplos:
 |  usuario  | senha     |
 |  rahyan   | rahyan11@ |
 |  pedro    | pedro12!  |
 |  roberto  | 1rR@      |
 |  felipe   | 1         |