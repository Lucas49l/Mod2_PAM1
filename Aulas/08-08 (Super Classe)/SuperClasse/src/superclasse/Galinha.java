package superclasse;

public class Galinha extends Animal {

    public Galinha(String nome) {
        super(nome);
    }
    
    @Override
    public void fazerBarulho() {
        System.out.println("Pó pó, có có");
    }
}
