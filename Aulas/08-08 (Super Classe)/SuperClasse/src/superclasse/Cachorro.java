package superclasse;

public class Cachorro extends Animal {

    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }
    
    @Override
    public void fazerBarulho() {
        System.out.println("Ruff ruff");
    }
}
