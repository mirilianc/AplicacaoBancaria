package br.com.lestcode.banco.service;

import br.com.lestcode.banco.entidades.Conta;
import br.com.lestcode.banco.entidades.PessoaFisica;
import br.com.lestcode.banco.entidades.PessoaJuridica;
import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaInvestimentoService extends ContaService{

    public void depositar(Conta conta, BigDecimal valor) {
        if (conta.getPessoa() instanceof PessoaJuridica){
            BigDecimal valorDepositado = valor.multiply(PessoaJuridica.TX_INVEST);
            conta.setSaldo(conta.getSaldo().add(valorDepositado));
            System.out.println("Depósito realizado com Sucesso!!");
            System.out.printf("Valor depositado: R$%.2f\n",valor);
            consultarSaldo(conta);
        }else {
            BigDecimal valorDepositado = valor.multiply(PessoaFisica.TX_INVEST);
            conta.getSaldo().add(valorDepositado);
            conta.setSaldo(conta.getSaldo().add(valorDepositado));
            System.out.println("Depósito realizado com Sucesso!!");
            System.out.printf("Valor depositado: R$%.2f\n",valor);
            consultarSaldo(conta);
        }
    }
}


