package steps;

import cucumber.api.java.pt.*;
import questao2.CaixaEletronico;
import questao2.Conta;

import static org.junit.Assert.*;

public class TesteSteps {
   
         private Conta conta;
         private CaixaEletronico caixa, caixa2;
   
         @Dado("^a conta criada para o dono (.*?) e de senha (.*?)$")
         public void a_conta_criada_para_o_dono_e_de_senha(String dono, String senha) throws Throwable {
        	 caixa = CaixaEletronico.getInstance();
        	 assertTrue(caixa.criarConta(dono, senha));
        	 assertTrue(caixa.logarConta(dono, senha));
         }
   
         @Quando("^o dono realiza o deposito no valor de (\\d+) na conta$")
         public void o_dono_realiza_o_deposito_no_valor_de_na_conta(Double valorDeposito) throws Throwable {
               assertTrue(caixa.deposito(valorDeposito));
         }
   
         @E("^o dono realiza o primeiro saque no valor de (\\d+) na conta$")
         public void o_dono_realiza_o_primeiro_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
               assertTrue(caixa.pagamento(valorSaque));
         }
   
   
         @Entao("^o dono tem o saldo no valor de (\\d+) na conta$")
         public void o_dono_tem_o_saldo_no_valor_de_na_conta(Double saldoEsperado) throws Throwable {
               assertEquals(saldoEsperado, caixa.saldo(), 0);
         }       
         
         @Dado("^que um caixa ja foi instanciado$")
         public void que_um_caixa_ja_foi_instanciado() throws Throwable {
        	 caixa = CaixaEletronico.getInstance();
         }
   
         @Quando("^o usuario tentar instanciar outro caixa$")
         public void o_usuario_tentar_instanciar_outro_caixa() throws Throwable {
        	 caixa2 = CaixaEletronico.getInstance();
         }
   
   
         @Entao("^ele nao consegue criar outra instancia$")
         public void ele_nao_conseugue_criar_outra_instancia() throws Throwable {
               assertEquals(caixa,caixa2);
         }
         
         private String usuario, senha;
         boolean ehForte;
         
         @Dado("^um (.*?) com uma (.*?)$")
         public void um_usuario_com_uma_senha(String usuario, String senha) throws Throwable {
        	 this.usuario = usuario;
        	 this.senha = senha;
         }
   
         @Quando("^um usuario tentar criar uma conta$")
         public void um_usuario_tentar_criar_uma_conta() throws Throwable {
        	 caixa = CaixaEletronico.getInstance();
        	 ehForte = caixa.senhaValida(senha);
         }
   
   
         @Entao("^ele deve conseguir apenas se a senha for forte$")
         public void ele_deve_conseguir_apenas_se_a_senha_for_forte() throws Throwable {    
        	 if(ehForte) assertTrue(caixa.criarConta(usuario, senha));
        	 else assertFalse(caixa.criarConta(usuario, senha));
         }   
         
         double saldo;
         
         @Dado("^um (.*?) cadastrado$")
         public void um_usuario_cadastrado(String usuario) throws Throwable {
        	 caixa = CaixaEletronico.getInstance();
        	assertTrue(caixa.criarConta(usuario, "usuario123!"));
        	assertTrue(caixa.logarConta(usuario, "usuario123!"));
         }
   
         @Quando("^ele solicitar o servico de checar saldo$")
         public void ele_solicitar_o_servico_de_chegar_saldo() throws Throwable {
        	 saldo = caixa.saldo();
        	 if(saldo != -99999999) assertTrue(true);
        	 else assertTrue(false);
         }
   
   
         @Entao("^o caixa deve retornar o valor correto$")
         public void o_caixa_deve_retornar_o_valor_correto() throws Throwable {    
        	 assertEquals(0, saldo, 0);
         }
       
         
         @Dado("^um (.*?) cadastrado com um (\\d+) disponivel$")
         public void um_usuario_cadastrado_com_um_saldo_disponivel(String usuario, Double saldo) throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	assertTrue(caixa.criarConta(usuario, "usuario123!"));
        	assertTrue(caixa.logarConta(usuario, "usuario123!"));
        	caixa.getContaAtual().setSaldo(saldo);
         }
   
         @Quando("^ele solicitar realizar um (\\d+)$")
         public void ele_solicitar_realizar_um_pagamento(Double pagamento) throws Throwable {
        	 assertTrue(caixa.pagamento(pagamento));
         }
   
   
         @Entao("^saldo deve ter o valor (\\d+)$")
         public void sald_deve_ter_o_valor_esperado(Double saldo) throws Throwable {    
        	 assertEquals(caixa.saldo(), saldo, 0);
         }
         
         @Dado("^algum (.*?) cadastrado com um (\\d+) disponivel$")
         public void algum_usuario_cadastrado_com_um_saldo_disponivel(String usuario, Double saldo) throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	assertTrue(caixa.criarConta(usuario, "usuario123!"));
        	assertTrue(caixa.logarConta(usuario, "usuario123!"));
        	caixa.getContaAtual().setSaldo(saldo);
         }
   
         @Quando("^ele realizar um (\\d+)$")
         public void ele_realizar_um_deposito(Double deposito) throws Throwable {
        	 assertTrue(caixa.deposito(deposito));
         }
   
   
         @Entao("^saldo deve ter o valor igual ao (\\d+)$")
         public void sald_deve_ter_o_valor_igual_ao_esperado(Double saldo) throws Throwable {    
        	 assertEquals(caixa.saldo(), saldo, 0);
         }
         
         String usuario_aux;
         
         @Dado("^algum (.*?) nao cadastrado com uma senha forte$")
         public void algum_usuario_nao_cadastrado_com_uma_senha_forte(String usuario) throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	usuario_aux = usuario;
         }
   
         @Quando("^ele realizar um cadastro$")
         public void ele_realizar_um_cadastro() throws Throwable {
        	 assertTrue(caixa.criarConta(usuario_aux, "usuario123!"));
         }
   
   
         @Entao("^ele deve conseguir$")
         public void ele_deve_conseguir() throws Throwable {    
        	 assertTrue(caixa.procuraConta(usuario_aux));
         }
         
         boolean bool_aux;         
         
         @Dado("^aquele (.*?) cadastrado$")
         public void usuario_cadastrado(String usuario) throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	caixa.criarConta(usuario, "usuario123!");
        	usuario_aux = usuario;
         }
   
         @Quando("^ele tentar logar na sua conta$")
         public void ele_tentar_logar_na_sua_conta() throws Throwable {
        	 bool_aux = caixa.logarConta(usuario_aux, "usuario123!");
         }
   
   
         @Entao("^ele tem que conseguir$")
         public void ele_tem_que_conseguir() throws Throwable {    
        	 assertTrue(bool_aux);
         }
         
         @Dado("^alguem usando o caixa sem estar logado$")
         public void alguem_usando_o_caixa_sem_estar_logado() throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	assertFalse(caixa.logado());
         }
   
         @Quando("^tentar utilizar algum servico$")
         public void tentar_utilizar_algum_servico() throws Throwable {
        	 //sera verirficado no Entao
         }
   
   
         @Entao("^o caixa nao ira funcionar$")
         public void o_caixa_nao_ira_funcionar() throws Throwable {    
        	 assertFalse(caixa.deposito(100));
        	 assertEquals(-99999999, caixa.saldo(), 0);
        	 assertFalse(caixa.pagamento(500));
         }
         
         boolean boolean_aux;
         
         @Dado("^um (.*?) cadastrado e logado no caixa$")
         public void um_usuario_cadastrdo_e_logado_no_caixa(String usuario) throws Throwable {
        	caixa = CaixaEletronico.getInstance();
        	assertTrue(caixa.criarConta(usuario, "usuario123!"));
        	assertTrue(caixa.logarConta(usuario, "usuario123!"));
         }
   
         @Quando("^tentar deslogar$")
         public void tentar_deslogar() throws Throwable {
        	 boolean_aux = caixa.deslogar();
         }
   
   
         @Entao("^ele deve conseguir deslogar$")
         public void ele_deve_conseguir_deslogar() throws Throwable {    
        	 if(boolean_aux) assertTrue(true);
        	 else assertTrue(false);
         }    
 }
