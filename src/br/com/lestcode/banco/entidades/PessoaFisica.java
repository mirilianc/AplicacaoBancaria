package br.com.lestcode.banco.entidades;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa{

    public static final BigDecimal TX_SAQUETRANSF = BigDecimal.valueOf(1.00);
    public static final BigDecimal TX_POUPANCA = BigDecimal.valueOf(1.01);
    public static final BigDecimal TX_INVEST = BigDecimal.valueOf(1.015);

    private String cpf;
    private String sexo;

    public PessoaFisica(String nome, String sexo, String endereco, String cpf) {
        super();
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
