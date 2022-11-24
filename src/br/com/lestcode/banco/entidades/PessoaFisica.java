package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa{

    private final BigDecimal TX_SAQUETRANSF = BigDecimal.valueOf(1.00);
    private final BigDecimal TX_POUPANCA = BigDecimal.valueOf(1.01);
    private final BigDecimal TX_INVEST = BigDecimal.valueOf(1.015);

    private String cpf;
    private String sexo;

    public BigDecimal getTX_SAQUETRANSF() {
        return TX_SAQUETRANSF;
    }

    public BigDecimal getTX_POUPANCA() {
        return TX_POUPANCA;
    }

    public BigDecimal getTX_INVEST() {
        return TX_INVEST;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
