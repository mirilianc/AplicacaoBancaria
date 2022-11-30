package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(long numconta, BigDecimal saldo, PessoaFisica pessoa) {
        super(numconta,saldo,pessoa);
    }
}
