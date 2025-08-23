package contateste;

import javax.swing.JOptionPane;

public class Conta {
    //atributos 
    public double saldo;
    public String cliente;
    //Métodos
    public void sacar(double valor){
        //saldo = saldo - valor;
        saldo -= valor;
        //JOptionPane.showMessageDialog(null,...) menssagem 
        JOptionPane.showMessageDialog(null, cliente + " operação de saque no valor de R$ " + valor);
    }
    public void depositar(double valor){    
        saldo += valor;
        JOptionPane.showMessageDialog(null, cliente + " operação de deposito no valor de R$ " + valor);
    }
    public void exibirSaldo(){
        //exibir na tela
        System.out.println(cliente + ", seu saldo é R$ " + saldo);
    }
    public void transferir(Conta destino, double valor){
        this.sacar(valor);
        destino.depositar(valor);
        JOptionPane.showMessageDialog(null, this.cliente + " Transferencia de R$ " + valor+ " para "+ destino.cliente + " ");    
    }
}