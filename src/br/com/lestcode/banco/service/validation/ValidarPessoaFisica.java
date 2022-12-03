package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.Pessoa;
import br.com.lestcode.banco.entidades.PessoaFisica;
import br.com.lestcode.banco.exceptions.CpfCnpjException;
import br.com.lestcode.banco.exceptions.ValidacaoException;

public class ValidarPessoaFisica implements ValidarPessoa<PessoaFisica> {

     String cpf;
    @Override
    public void validarDocumento(PessoaFisica pessoa) throws CpfCnpjException {
       pessoa.getCpf();


        if (!isCpf(pessoa.getCpf())) {
            throw new CpfCnpjException("CPF/CNPJ invalido");
        }

    }

    public static boolean isCpf(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            return (false);
        } else {
            return (true);
        }
    }

    public void validarSexo(PessoaFisica pessoa) throws ValidacaoException {
        if (!pessoa.getSexo().equals("F") &&
                !pessoa.getSexo().equals("M")) {
            throw new ValidacaoException("Campo Sexo deve ser F ou M!");
        }
    }
}



