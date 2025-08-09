
package superclasse;

public class Animal {
    String nome, raca;
    double peso;
    
    //construtor da classe passando o nome
    public Animal(String nome){
    }
    //construtor da classe passando o nome e raça
    public Animal(String nome, String raca){
    }
    //construtor da classe passando o nome, raça e peso
    public Animal(String nome, String raca, double peso) {
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
    }
    
       
    public void fazerBarulho() {
        System.out.println("Ruff ruff");
    }
}
