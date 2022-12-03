package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.Pessoa;
import br.com.lestcode.banco.exceptions.CpfCnpjException;
import br.com.lestcode.banco.exceptions.ValidacaoException;


public interface ValidarPessoa <T extends Pessoa> {

    void validarDocumento(T Pessoa) throws ValidacaoException, CpfCnpjException;


}
