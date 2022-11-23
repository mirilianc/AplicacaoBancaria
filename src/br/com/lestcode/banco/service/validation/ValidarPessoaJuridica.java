package br.com.lestcode.banco.service.validation;

import br.com.lestcode.banco.entidades.PessoaJuridica;
import br.com.lestcode.banco.exceptions.CpfCnpjException;

public class ValidarPessoaJuridica implements ValidarPessoa<PessoaJuridica> {

    @Override
    public void validarDocumento(PessoaJuridica pessoa) {
        pessoa.getCnpj();
       }

    public void setCnpj(String cnpj) throws CpfCnpjException {

        if (!isCnpj(cnpj)) {
            throw new CpfCnpjException("CPF/CNPJ invalido");
        }
    }

    public static boolean isCnpj(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14)) {
            return (false);
        } else {
            return (true);
        }
    }
}
