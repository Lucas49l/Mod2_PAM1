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
        JOptionPane.showMessageDialog(null, cliente + "\n Saque no valor de R$ " + valor + " realizado");
    }
    public void depositar(double valor){    
        saldo += valor;
        JOptionPane.showMessageDialog(null, cliente + "\n Deposito no valor de R$ " + valor + " realizado");
    }
    public void exibirSaldo(){
        //exibir na tela
        System.out.println(cliente + ", saldo de R$ " + saldo);
    }
    public void transferir(Conta destino, double valor){
        this.sacar(valor);
        destino.depositar(valor);
        JOptionPane.showMessageDialog(null, this.cliente + " Transferencia de R$ " + valor+ " para "+ destino.cliente + " ");    
    }
}