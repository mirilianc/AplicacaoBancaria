package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa {

    private final BigDecimal TX_SAQUETRANSF = BigDecimal.valueOf(1.005);
    private final BigDecimal TX_POUPANCA = BigDecimal.valueOf(0.00);
    private final BigDecimal TX_INVEST = BigDecimal.valueOf(1.035);
    private String cnpj;

    public BigDecimal getTX_SAQUETRANSF() {
        return TX_SAQUETRANSF;
    }

    public BigDecimal getTX_POUPANCA() {
        return TX_POUPANCA;
    }

    public BigDecimal getTX_INVEST() {
        return TX_INVEST;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
