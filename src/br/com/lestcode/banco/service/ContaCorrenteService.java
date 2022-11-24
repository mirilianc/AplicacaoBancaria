package br.com.lestcode.banco.service;

import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaCorrenteService extends ContaService {

    public void investir(BigDecimal valor) {
        try {
            super.adicionarDinheiro(valor);
        }
        catch (ValoresException e){
            System.out.println(e.getMessage());
        }
    }
}
