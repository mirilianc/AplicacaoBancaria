package br.com.lestcode.banco.service;

import br.com.lestcode.banco.entidades.Conta;
import br.com.lestcode.banco.entidades.PessoaFisica;
import br.com.lestcode.banco.entidades.PessoaJuridica;
import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaPopupancaService extends ContaService{

    public void depositar(Conta conta, BigDecimal valor) {
        if (conta.getPessoa() instanceof PessoaJuridica){
            BigDecimal valorDepositado = valor.multiply(PessoaJuridica.TX_POUPANCA);
            conta.getSaldo().add(valorDepositado);
        }else {
            BigDecimal valorDepositado = valor.multiply(PessoaFisica.TX_POUPANCA);
            conta.getSaldo().add(valorDepositado);
        }

    }
}
