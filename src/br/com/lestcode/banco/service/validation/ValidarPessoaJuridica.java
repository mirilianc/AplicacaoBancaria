package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.PessoaJuridica;

public class ValidarPessoaJuridica implements ValidarPessoa<PessoaJuridica> {

    @Override
    public boolean validarDocumento(PessoaJuridica Pessoa) {
        return false;
    }
}
