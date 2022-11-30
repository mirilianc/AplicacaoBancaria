package br.com.lestcode.banco;

import br.com.lestcode.banco.entidades.*;
import br.com.lestcode.banco.exceptions.CpfCnpjException;
import br.com.lestcode.banco.exceptions.ValidacaoException;
import br.com.lestcode.banco.exceptions.ValoresException;
import br.com.lestcode.banco.service.ContaCorrenteService;
import br.com.lestcode.banco.service.ContaInvestimentoService;
import br.com.lestcode.banco.service.ContaPopupancaService;
import br.com.lestcode.banco.service.ContaService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {
            static Scanner a = new Scanner(System.in);
            static String encerrar;

            public static void main(String[] args) {

                Aplicacao aplicacao = new Aplicacao();

                while (true) {
                    try {
                        aplicacao.abrirConta();
                    } catch (ValidacaoException e) {
                        System.out.println("Erro de validacao: " + e.getMessage() + "\n" +
                                "Entre com os dados novamente.");
                    } catch (CpfCnpjException e) {
                        System.out.println("Erro validação: " + e.getMessage() + "\n" +
                                "Entre com os dados novamente.");
                    } catch (ValoresException e) {
                        System.out.println(e.getMessage() + "\n" +
                                "Entre com os dados novamente.");
                    } finally{
                        aplicacao.a = new Scanner(System.in);
                    }

                }
            }

            private void abrirConta() throws ValidacaoException, CpfCnpjException, ValoresException {
                String tipoConta = null;
                Pessoa pessoa = null;
                Conta conta = null;
                ContaService contaService = null;

                System.out.println("<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("        BEM VINDO AO BANCO ITAU-LETSCODE      ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Bom dia vamos abrir sua conta: ");

                System.out.printf("Informe seu nome:  ");
                String nome = a.nextLine().toUpperCase();
                if (nome.isBlank()) {
                    throw new ValidacaoException("Nome é obrigatorio");
                }

                System.out.printf("Informe seu endereço: ");
                String endereco = a.nextLine().toUpperCase();
                if (endereco.isBlank()){
                    throw new ValidacaoException("Campo Endereço é Obrigatório!");
                }

                System.out.printf("Informe se a conta será de PF ou PJ: ");
                String tipoPessoa = a.nextLine().toUpperCase();
                if (!tipoPessoa.equals("PF") && !tipoPessoa.equals("PJ")){
                    throw new ValidacaoException("Campo Tipo Pessoa deve ser PF ou PJ!");
                }

                switch (tipoPessoa){
                    case "PF":
                        System.out.printf("Informe seu sexo ('F' ou 'M'):  ");
                        String sexo = a.nextLine().toUpperCase();
                        if (!sexo.equals("F") && !sexo.equals("M")){
                            throw new ValidacaoException("Campo Sexo deve ser F ou M!");
                        }

                        System.out.printf("Informe seu CPF: ");
                        String cpf = a.nextLine();

                        pessoa = new PessoaFisica(nome, sexo, endereco, cpf);

                        System.out.println("Informe o tipo de conta que quer abrir: ");
                        System.out.printf("CC - Conta Corrente, CI - Conta Investimento, CP - Conta Popupança \n Tipo: ");
                        tipoConta = a.nextLine().toUpperCase();
                        if (!tipoConta.equals("CC") && !tipoConta.equals("CI") && !tipoConta.equals("CP")){
                            throw new ValidacaoException("Campo Tipo Conta para PF deve ser CC, CI ou CP!");
                        }
                        break;
                    case "PJ":
                        System.out.printf("Informe seu CNPJ: ");
                        String cnpj = a.nextLine();

                        pessoa = new PessoaJuridica(nome, endereco, cnpj);

                        System.out.println("Informe o tipo de conta que quer abrir: ");
                        System.out.println("CC - Conta Corrente, CI - Conta Investimento \n Tipo: ");
                        tipoConta = a.nextLine().toUpperCase();
                        if (!tipoConta.equals("CC") && !tipoConta.equals("CI")){
                            throw new ValidacaoException("Campo Tipo Conta para PJ deve ser CC ou CI!");
                        }
                        break;
                    default:
                        System.out.println("OPÇÃO INVALIDA");
                        System.exit(0);
                }

                System.out.printf("Informe o saldo que irá iniciar sua conta: ");
                BigDecimal saldo = a.nextBigDecimal();

                long numconta = System.currentTimeMillis();

                switch (tipoConta) {
                    case "CC":
                        conta = new ContaCorrente(numconta, saldo, pessoa);
                        contaService = new ContaCorrenteService();
                        break;
                    case "CI":
                        conta = new ContaInvestimento(numconta, saldo, pessoa);
                        contaService = new ContaInvestimentoService();
                        break;
                    case "CP":
                        conta = new ContaPoupanca(numconta, saldo, (PessoaFisica)pessoa);
                        contaService = new ContaPopupancaService();
                        break;
                    default:
                        System.out.println("OPÇÃO INVALIDA");
                        System.exit(0);
                }
                operacoes(contaService, conta);
            }

            private void operacoes(ContaService contaService, Conta conta) {
                int operacao;
                do {
                    System.out.println("\nOperações:");
                    System.out.println("1-SACAR");
                    System.out.println("2-DEPOSITAR");
                    System.out.println("3-TRANSFERIR");
                    System.out.println("5-CONSULTAR SALDO");
                    System.out.println("6-CONSULTAR DADOS DA CONTA");
                    System.out.println("7-ENCERRAR");
                    System.out.printf("Informe a operacao que deseja realizar: ");
                    operacao = a.nextInt();


                    System.out.println("Saldo da CONTA" + conta.getSaldo());
                    try {
                        switch (operacao) {
                            case 1:
                                System.out.printf("Informe o valor do saque: ");
                                BigDecimal saque = a.nextBigDecimal();
                                contaService.sacar(conta, saque);
                                break;
                            case 2:
                                System.out.printf("Informe o valor do deposito: ");
                                BigDecimal deposito = a.nextBigDecimal();
                                contaService.depositar(conta, deposito);
                                break;
                            case 3:
                                System.out.printf("Informe o valor da transferencia: ");
                                BigDecimal transferencia = a.nextBigDecimal();
                                contaService.transferir(conta,transferencia);
                                break;
                            case 5:
                                contaService.consultarSaldo(conta);
                                break;
                            case 6:
                                System.out.println(conta.toString());
                                break;
                            case 7:
                                System.exit(0);
                            default:
                                System.out.println("OPÇÃO INVALIDA");
                                System.exit(0);
                        }
                    }catch (ValoresException e) {
                        System.out.println(e.getMessage() + "\n" +
                                "Entre com os dados novamente.");
                    }
                    System.out.print("\nDigite S se deseja continuar:  ");
                    encerrar = a.next().toUpperCase();
                }while(encerrar.equals("S"));

                System.exit(0);

            }
        }
