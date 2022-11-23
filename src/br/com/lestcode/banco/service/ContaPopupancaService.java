package br.com.lestcode.banco.service;

import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaPopupancaService extends ContaService{

    public void investir(BigDecimal valor) {
        try {
            BigDecimal valorDepositado =
                    valor.multiply(pessoa.getTaxaPoupanca());

            super.adicionarDinheiro(valorDepositado);
        }
        catch (ValoresException e){
            System.out.println(e.getMessage());
        }

    }
}
