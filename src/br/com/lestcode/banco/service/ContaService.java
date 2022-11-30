package br.com.lestcode.banco.service;

import br.com.lestcode.banco.entidades.Conta;
import br.com.lestcode.banco.entidades.PessoaJuridica;
import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaService {

    protected void adicionarDinheiro(Conta conta, BigDecimal valor) throws ValoresException{
        if(valor.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new ValoresException("Valor nao permitido!");
        }
        conta.setSaldo(conta.getSaldo().add(valor));
        System.out.println("Investimento realizado com Sucesso!!");
        System.out.printf("Valor investido: R$%.2f\n",valor);
        consultarSaldo(conta);

    }

    public static void sacar(Conta conta, BigDecimal valor) throws ValoresException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValoresException("Valor nao permitido!");
        }
        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new ValoresException("Saldo Insuficiente!");
        }
        if (conta.getPessoa() instanceof PessoaJuridica){

            BigDecimal valorsacado = valor.multiply(PessoaJuridica.TX_SAQUETRANSF);
            conta.getSaldo().subtract(valorsacado);
        }else {
            conta.getSaldo().subtract(valor);
        }
        System.out.println("Saque realizado com Sucesso!!");
        System.out.printf("Valor sacado: R$%.2f\n",valor);
        consultarSaldo(conta);
    }

    public static void transferir(Conta conta, BigDecimal valor) throws ValoresException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValoresException("Valor nao permitido!");
        }
        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new ValoresException("Saldo Insuficiente!");
        }

        if (conta.getPessoa() instanceof PessoaJuridica){
            BigDecimal valorsacado = valor.multiply(PessoaJuridica.TX_SAQUETRANSF);
            conta.getSaldo().subtract(valorsacado);
        }else {
            conta.getSaldo().subtract(valor);
        }
        System.out.println("Transferência realizada com Sucesso!!");
        System.out.printf("Valor transferido: R$%.2f\n",valor);
        consultarSaldo(conta);
    }
    public static void depositar(Conta conta, BigDecimal valor) throws ValoresException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValoresException("Valor nao permitido!");
        }

        conta.setSaldo(conta.getSaldo().add(valor));
        System.out.println("Depósito realizado com Sucesso!!");
        System.out.printf("Valor depositado: R$%.2f\n",valor);
        consultarSaldo(conta);
    }

    public static void consultarSaldo(Conta conta) {
        System.out.printf("\nO Saldo de sua conta é de R$%.2f\n", conta.getSaldo());
    }

}


