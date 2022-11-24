package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class Conta {

    private long numconta;
    private BigDecimal saldo;
    Pessoa pessoa;

    public long getNumconta() {
        return numconta;
    }

    public void setNumconta(long numconta) {
        this.numconta = numconta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
