package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.Pessoa;

public interface ValidarPessoa <T extends Pessoa> {

    boolean validarDocumento(T Pessoa);
}
