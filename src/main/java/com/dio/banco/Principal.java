package com.dio.banco;

public class Principal {
    public static void main(String[] args) {
        // Intancia dos clientes
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        // Inserindo nome dos cliente
        c1.setNome("Bob");
        c2.setNome("Bartolomeu");

        // Instancia das contas
        Conta cc =  new ContaCorrente(c1);
        Conta cp =  new ContaPoupanca(c1);
        Conta cp2 =  new ContaPoupanca(c2);

        // Depositar
        cc.depositar(500.00);

        // Transferir
        cc.tranferir(250.00,cp);
        cc.tranferir(50.00,cp2);
        // Sacar
        cc.sacar(100.00);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cp2.imprimirExtrato();


    }
}
