package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa {

    public static final BigDecimal TX_SAQUETRANSF = BigDecimal.valueOf(1.005);
    public static final BigDecimal TX_POUPANCA = BigDecimal.valueOf(0.00);
    public static final BigDecimal TX_INVEST = BigDecimal.valueOf(1.035);
    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String cnpj) {
        super();
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
