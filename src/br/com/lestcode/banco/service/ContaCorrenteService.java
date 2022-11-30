package br.com.lestcode.banco.service;

import br.com.lestcode.banco.entidades.Conta;
import br.com.lestcode.banco.exceptions.ValoresException;

import java.math.BigDecimal;

public class ContaCorrenteService extends ContaService {

    public void depositar(Conta conta, BigDecimal valor) {
        try {
            ContaService.depositar(conta, valor);
        }
        catch (ValoresException e){
            System.out.println(e.getMessage());
        }
    }
}
