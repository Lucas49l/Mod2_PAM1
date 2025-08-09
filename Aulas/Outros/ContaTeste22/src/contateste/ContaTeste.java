package contateste;

import javax.swing.JOptionPane;

public class ContaTeste {
    
    public static void main(String[] args) {
        Conta conta = new Conta();
        Conta conta2 = new Conta();
        
        // a classe double.parseDouble converte o valor que vem da caixa de texto em double
        // converter o valor String em double  e armazenando o valor na variavel s
        conta.saldo= Double.parseDouble (JOptionPane.showInputDialog("Informe o valor do saldo"));
        conta.cliente = JOptionPane.showInputDialog("Nome do cliente: ");
        conta2.cliente = JOptionPane.showInputDialog("Digite o nome do cliente");
        
  
        conta.transferir(conta2, 100);
      
        
    }
    
}
