package com.dio.banco;

public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected int saques;
    protected double saldo;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero =  SEQUENCIAL++;

        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
            saques++;
        }else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    @Override
    public void tranferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void Extrato() {
        System.out.println("\tEXTRATO");
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d ", this.agencia));
        System.out.println(String.format("Numero da Conta: %d ", this.numero));
        System.out.println(String.format("Saldo: %.2f ", this.saldo));
        System.out.println(String.format("Retiradas realizadas hoje: " + this.saques + "\n"));
    }

}
