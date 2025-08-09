
package media;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Media {
    /**
     * @param args
     */
    public static void main(String[] args) {
        double nota1, nota2, nota3, media;
        String nome;
        Scanner lerTeclado = new Scanner(System.in);

        System.out.println("Digite o nome");
        nome = JOptionPane.showInputDialog("Digite o Nome");

        System.out.println("Digite a 1° nota");
        nota1 = lerTeclado.nextDouble();
        System.out.println("Digite a 2° nota");
        nota2 = lerTeclado.nextDouble();
        System.out.println("Digite a 3° nota");
        nota3 = lerTeclado.nextDouble();        
        
        System.out.println("Nome: "+nome);
        
        media = (nota1+nota2+nota3)/3;

        if(media <= 5){

            if(media >=6){
                JOptionPane.showMessageDialog(null, "APROVADO \n Média: " +media);
            }else{
                JOptionPane.showMessageDialog(null, "Recuperação \n Média: " +media);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Reprovado \n Média: " +media);
        }
        
    }
    
}
