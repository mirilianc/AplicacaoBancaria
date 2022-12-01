package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class ContaCorrente  extends Conta{
    public ContaCorrente(long numconta, BigDecimal saldo, Pessoa pessoa) {

        super(numconta, saldo, pessoa);
    }
}
