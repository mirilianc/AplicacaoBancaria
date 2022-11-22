package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.PessoaFisica;

public class ValidarPessoaFisica implements ValidarPessoa<PessoaFisica>{

    @Override
    public boolean validarDocumento(PessoaFisica Pessoa) {
        return false;
    }
}
