# language: pt
#Author: Rahyan Azin
#Data: 21/07/2017

@testesAceitacao

Funcionalidade: Testar as operacoes basicas de conta

Esquema do Cenário: Testar saque e deposito
	Dado a conta criada para o dono <dono> e de senha <senha>
	Quando o dono realiza o deposito no valor de <deposito> na conta
	E o dono realiza o primeiro saque no valor de <primeiro_saque> na conta
	Então o dono tem o saldo no valor de <saldo_esperado> na conta

Exemplos:
 | dono   |	senha	    | deposito | primeiro_saque | saldo_esperado |
 | Brendo |	abc5d12!@	| 100      | 10             | 90             |
 | Hiago  |	ef5gh34#$	| 200      | 10             | 190            | 
 | Filipe |	isjklm5!aa	| 200      | 20             | 180            |    
 | Cinara |	dkfodi$44	| 200      | 30             | 170            |    